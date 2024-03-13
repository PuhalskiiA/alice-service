package com.example.aliceservice.backend.repositories;

import com.example.aliceservice.backend.entityes.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    @Query(value = "select id, title from notes where user_id = ?1", nativeQuery = true)
    List<Note> getNotes(UUID user_id);

    @Query(value = "select * from notes where id = ?1 and user_id = ?2", nativeQuery = true)
    Note getNote(UUID id, UUID user_id);

    @Query(value = "insert into notes (id, user_id, title, content) values (?, ?, ?, ?)", nativeQuery = true)
    Note addNote(UUID id, UUID user_id, String title, String content);

    @Query(value = "delete from notes where id = ?1 and user_id = ?2", nativeQuery = true)
    Note deleteNote(UUID id, UUID user_id);

    @Query(value = "update notes set title = ?3 and content = ?4 where id = ?1 and user_id = ?2", nativeQuery = true)
    Note updateNote(UUID id, UUID user_id, String title, String content);
}
