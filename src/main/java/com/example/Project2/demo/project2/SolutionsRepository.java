package com.example.Project2.demo.project2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionsRepository extends JpaRepository<Solutions,Long> {
    Solutions findBySymptoms(String symptom);
}