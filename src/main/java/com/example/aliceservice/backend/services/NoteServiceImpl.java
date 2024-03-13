package com.example.aliceservice.backend.services;

import com.example.aliceservice.backend.entityes.Note;
import com.example.aliceservice.backend.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public List<Note> getNotes(UUID user_id) {
        return null;
    }

    @Override
    public Note getNote(UUID id, UUID user_id) {
        return null;
    }

    @Override
    public Note addNote(UUID id, UUID user_id, String title, String content) {
        return null;
    }

    @Override
    public Note deleteNote(UUID id, UUID user_id) {
        return null;
    }

    @Override
    public Note updateNote(UUID id, UUID user_id, String title, String content) {
        return null;
    }
}
