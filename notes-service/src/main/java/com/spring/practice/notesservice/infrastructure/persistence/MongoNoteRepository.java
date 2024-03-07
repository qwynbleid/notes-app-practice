package com.spring.practice.notesservice.infrastructure.persistence;

import com.spring.practice.notesservice.domain.model.Note;
import com.spring.practice.notesservice.domain.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Repository
public class MongoNoteRepository implements NoteRepository {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoNoteRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Note save(Note note) {
        note.setCreatedAt(Date.from(Instant.now()));
        note.setUpdatedAt(Date.from(Instant.now()));
        return mongoTemplate.save(note);
    }

    @Override
    public List<Note> findAllByUserId(String userId) {
//        return mongoTemplate.findAll(Note.class);
        Query query = new Query(Criteria.where("userId").is(userId));
        return mongoTemplate.find(query, Note.class);
    }

    @Override
    public void update(Note note) {
        mongoTemplate.save(note);
    }

    @Override
    public void delete(String noteId) {
        Query query = new Query(Criteria.where("_id").is(noteId));
        mongoTemplate.remove(query, Note.class);
    }

}
