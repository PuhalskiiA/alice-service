package com.example.aliceservice.backend.services;

import com.example.aliceservice.backend.entityes.Note;

import java.util.List;
import java.util.UUID;

public interface NoteService {
    List<Note> getNotes(UUID user_id);

    Note getNote(UUID id, UUID user_id);

    Note addNote(UUID id, UUID user_id, String title, String content);

    Note deleteNote(UUID id, UUID user_id);

    Note updateNote(UUID id, UUID user_id, String title, String content);
}
