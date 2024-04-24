package com.example.aliceservice.skill.repositories;

import com.example.aliceservice.skill.model.entityes.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
   User getUserById(UUID id);

   @Modifying
   @Transactional
   @Query(value = "INSERT INTO users (id, name, surname, email, sex, psuid, application_id) VALUES (?, ?, ?, ?, ?, ?, ?)",
           nativeQuery = true)
   void addUser(UUID id, String name, String surname, String email, String sex, String psuid, String applicationID);

   void deleteUserById(UUID user_id);
}
