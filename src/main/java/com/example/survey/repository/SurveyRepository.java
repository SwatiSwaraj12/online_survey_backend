package com.example.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.survey.model.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
}

