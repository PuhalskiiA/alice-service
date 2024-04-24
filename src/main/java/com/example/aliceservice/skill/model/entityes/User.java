package com.example.aliceservice.skill.model.entityes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "sex")
    private String sex;

    @Column(name = "psuid")
    private String psuid;

    @Column(name = "application_id")
    private String applicationID;
}
