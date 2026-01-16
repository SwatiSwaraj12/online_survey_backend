package com.example.survey.controller;

import com.example.survey.model.Survey;
import com.example.survey.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/survey")
@CrossOrigin(origins = "*")
public class SurveyController {

    @Autowired
    private SurveyRepository repo;

    @PostMapping
    public Survey addSurvey(@RequestBody Survey survey) {
        System.out.println("Received Question: " + survey.getQuestion());
        return repo.save(survey);
    }

    @GetMapping
    public List<Survey> getAllSurveys() {
        return repo.findAll();
    }
}
