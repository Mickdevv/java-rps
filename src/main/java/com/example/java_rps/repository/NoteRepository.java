package com.example.java_rps.repository;

import com.example.java_rps.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, UUID> {

}
