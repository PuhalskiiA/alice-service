package com.example.aliceservice.skill.repositories;

import com.example.aliceservice.skill.model.entityes.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, UUID> {
    @Query(value = "select configuration from configs where id = ?1" , nativeQuery = true)
    Configuration getConfigurationByUserId(UUID userId);
}
