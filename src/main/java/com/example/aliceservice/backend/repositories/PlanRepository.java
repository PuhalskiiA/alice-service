package com.example.aliceservice.backend.repositories;

import com.example.aliceservice.backend.entityes.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

}
