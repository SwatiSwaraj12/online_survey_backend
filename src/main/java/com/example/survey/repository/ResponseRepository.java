package com.example.survey.repository;

import com.example.survey.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResponseRepository extends JpaRepository<Response, Long> {
    List<Response> findBySurveyId(Long surveyId);
}
