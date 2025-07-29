package com.Coder.myFirstProject.repository;

import com.Coder.myFirstProject.entity.ConfigJournalAppEntity;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

@Configuration
public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalAppEntity, ObjectId> {



}
