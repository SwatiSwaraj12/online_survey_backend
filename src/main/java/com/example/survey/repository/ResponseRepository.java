package com.example.survey.repository;

import com.example.survey.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {

    List<Response> findBySurveyId(Long surveyId);

}
