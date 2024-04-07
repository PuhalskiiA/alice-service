package com.example.aliceservice.skill.model.entityes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Entity
@Table(name = "configs")
public class Configuration {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "configuration")
    private String configuration;
}
