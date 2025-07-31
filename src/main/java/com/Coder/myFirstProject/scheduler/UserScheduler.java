package com.Coder.myFirstProject.scheduler;

import com.Coder.myFirstProject.cache.AppCache;
import com.Coder.myFirstProject.entity.JournalEntry;
import com.Coder.myFirstProject.entity.User;
import com.Coder.myFirstProject.repository.UserRepositoryImpl;
import com.Coder.myFirstProject.service.EmailService;
import com.Coder.myFirstProject.service.SentimentAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserScheduler {


    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;

    @Autowired
    private AppCache appCache;

    @Scheduled(cron = "0 35 12 ? * 3\n")
    public void fetchUsersAndSendSaMail(){
        List<User> users=userRepository.getUserForSA();
        for(User user:users){
            List<JournalEntry> journalEntries=user.getJournalEntries();
            List<String> filteredEntries= journalEntries.stream().filter(x->x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x->x.getContent()).collect(Collectors.toList());
            String entry=String.join(" ",filteredEntries);
            String sentiment=sentimentAnalysisService.getSentiment(entry);
            emailService.sendEmail(user.getEmail(),"Your Sentiment for Last 7 days",sentiment);
        }
    }


    @Scheduled(cron = "0 0/10 * ? * *")
    public void clearAppCache() {
        appCache.init();
    }
}
