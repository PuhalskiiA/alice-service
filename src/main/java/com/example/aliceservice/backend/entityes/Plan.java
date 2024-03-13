package com.example.aliceservice.backend.entityes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Plan {
    @Id
    UUID id;
}
