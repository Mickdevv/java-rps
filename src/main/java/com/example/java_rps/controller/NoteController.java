package com.example.java_rps.controller;

import com.example.java_rps.model.Note;
import com.example.java_rps.service.NoteService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {
    private  final NoteService noteService;

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/")
    public ResponseEntity<Object> createNote(@RequestBody Note note) {
        return noteService.newNote(note);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateNote(@PathVariable UUID id, @RequestBody Note note) {
        return noteService.updateNote(id, note);
    }

    @GetMapping("/")
    public List<Note> getNotes() {
        return noteService.getNotes();
    }


    @GetMapping("/session")
    public String getSessionId(HttpServletRequest request) {
        return request.getSession().getId();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getNoteById(@PathVariable UUID id) {
        return noteService.getNoteById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteNote(@PathVariable UUID id) {
        return noteService.deleteNote(id);
    }
}
