package com.example.java_rps.service;

import com.example.java_rps.model.Note;
import com.example.java_rps.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public ResponseEntity<Object> newNote(Note note) {
        noteRepository.save(note);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }

    public ResponseEntity<Object> getNoteById(UUID id) {
        Optional<Note> noteOptional = noteRepository.findById(id);

        if (noteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(noteOptional.get());
    }

    public ResponseEntity<Object> updateNote(UUID id, Note updatedNote) {
        Optional<Note> noteOptional = noteRepository.findById(id);

        if (noteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Note existingNote = noteOptional.get();
        existingNote.setTitle(updatedNote.getTitle());
        existingNote.setContent(updatedNote.getContent());
        noteRepository.save(existingNote);

        return ResponseEntity.ok(existingNote);
    }

    public List<Note> getNotes() {
        return noteRepository.findAll();
    }

    public ResponseEntity<Object> deleteNote(UUID id) {
        Optional<Note> noteOptional = noteRepository.findById(id);

        if (noteOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        noteRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
