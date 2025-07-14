package com.Coder.myFirstProject.repository;

import com.Coder.myFirstProject.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.io.ObjectInput;

public interface JournalEntryRepository extends MongoRepository< JournalEntry, ObjectId> {

}
