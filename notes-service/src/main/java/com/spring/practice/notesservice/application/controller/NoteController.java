package com.spring.practice.notesservice.application.controller;

import com.spring.practice.notesservice.domain.model.Note;
import com.spring.practice.notesservice.domain.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/get-notes/{userId}")
    public List<Note> getAllNotes(@PathVariable String userId) {
        return noteService.getAllNotesByUserId(userId);
    }

    @PostMapping("/add-note")
    public Note addNewNote(@RequestBody Note note) {
        return noteService.createNote(note);
    }

    @PostMapping("/update-note")
    public void updateNote(@RequestBody Note note) {
        noteService.updateNote(note);
    }

    @DeleteMapping("/delete-note/{noteId}")
    public void deleteNoteById(@PathVariable String noteId) {
        noteService.deleteNoteById(noteId);
    }

}
