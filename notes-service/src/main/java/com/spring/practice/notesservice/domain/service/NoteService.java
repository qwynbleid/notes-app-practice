package com.spring.practice.notesservice.domain.service;

import com.spring.practice.notesservice.domain.model.Note;
import com.spring.practice.notesservice.domain.repository.NoteRepository;

import java.util.List;

public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }
    public List<Note> getAllNotesByUserId(String userId) {
        return noteRepository.findAllByUserId(userId);
    }

    public Note createNote(Note note) {
        noteRepository.save(note);
        return note;
    }
    public void updateNote(Note note) {
        noteRepository.update(note);
    }
    public void deleteNoteById(String noteId) {
        noteRepository.delete(noteId);
    }
}
