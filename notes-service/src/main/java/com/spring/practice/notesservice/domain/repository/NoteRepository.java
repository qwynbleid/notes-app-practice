package com.spring.practice.notesservice.domain.repository;

import com.spring.practice.notesservice.domain.model.Note;

import java.util.List;

public interface NoteRepository {
    //    Note findById(String id);
    List<Note> findAllByUserId(String userId);
    Note save(Note note);
    void update(Note note);
    void delete(String id);
}
