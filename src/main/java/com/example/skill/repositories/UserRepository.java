package com.example.skill.repositories;

import com.example.skill.model.entityes.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
   User getUserById(UUID id);

   @Query(value = "select * from users where psuid = ?1", nativeQuery = true)
   User getUserByPsuid(String psuid);

   @Modifying
   @Transactional
   @Query(value = "insert into users (id, name, surname, email, sex, psuid) values (?, ?, ?, ?, ?, ?)",
           nativeQuery = true)
   void addUser(UUID id, String name, String surname, String email, String sex, String psuid);

   void deleteUserById(UUID user_id);

   @Query(value = "select id from users where psuid = ?1", nativeQuery = true)
   UUID getIdByPsuid(String psuid);

   @Query(value = "select users.* from users " +
           "inner join tokens on users.id = user_id " +
           "where psuid = ?1 and source = ?2", nativeQuery = true)
   User checkSourceForUser(String psuid, String source);
}
