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

   User getUserByPsuid(String psuid);

   @Modifying
   @Transactional
   @Query(value = "insert into users (id, name, surname, email, sex, psuid, application_id) values (?, ?, ?, ?, ?, ?, ?)",
           nativeQuery = true)
   void addUser(UUID id, String name, String surname, String email, String sex, String psuid, String applicationID);

   void deleteUserById(UUID user_id);

   @Query(value = "select id from users where psuid = ?1", nativeQuery = true)
   UUID getIdByPsuid(String psuid);

}
