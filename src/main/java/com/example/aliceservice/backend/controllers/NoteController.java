package com.example.aliceservice.backend.controllers;

import com.example.aliceservice.backend.exceptions.NoteException;
import com.example.aliceservice.backend.entityes.Note;
import com.example.aliceservice.backend.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private NoteService noteService;

    @GetMapping("/getNotes/{user_id}")
    public ResponseEntity<List<Note>> getNotes(@PathVariable("user_id") UUID user_id) {
        try {
            return new ResponseEntity<>(noteService.getNotes(user_id), HttpStatus.OK);
        } catch (NoteException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notes not found");
        }
    }

    @GetMapping("/getNote/{id}/{user_id}")
    public ResponseEntity<Note> getNote(@PathVariable("id") UUID id,
                                        @PathVariable("user_id") UUID user_id) {
        try {
            return new ResponseEntity<>(noteService.getNote(id, user_id), HttpStatus.OK);
        } catch (NoteException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found");
        }
    }

//    @PostMapping("/addNote/")
//    public ResponseEntity<Note> addNote() {
//        try {
//            return new ResponseEntity<>(noteService.getNote(id, user_id), HttpStatus.OK);
//        } catch (NoteException e) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found");
//        }
//    }

    @DeleteMapping("/deleteNote/{id}/{user_id}")
    public ResponseEntity<Note> deleteNote(@PathVariable("id") UUID id,
                                           @PathVariable("user_id") UUID user_id) {
        try {
            return new ResponseEntity<>(noteService.deleteNote(id, user_id), HttpStatus.OK);
        } catch (NoteException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found");
        }
    }

    @PutMapping("/updateNote/{id}/{user_id}/{title}/{content}")
    public ResponseEntity<Note> updateNote(@PathVariable("id") UUID id,
                                           @PathVariable("user_id") UUID user_id,
                                           @PathVariable("title") String title,
                                           @PathVariable("content") String content) {
        try {
            return new ResponseEntity<>(noteService.updateNote(id, user_id, title, content), HttpStatus.OK);
        } catch (NoteException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found");
        }
    }

    @Autowired
    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }
}
