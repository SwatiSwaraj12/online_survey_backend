package com.example.survey.controller;

import com.example.survey.model.Response;
import com.example.survey.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responses")
@CrossOrigin(origins = "*")
public class ResponseController {

    @Autowired
    private ResponseRepository repo;

    // ✅ Submit response
    @PostMapping
    public Response addResponse(@RequestBody Response response) {
        return repo.save(response);
    }

    // ✅ Get all responses
    @GetMapping
    public List<Response> getAllResponses() {
        return repo.findAll();
    }

    // ✅ Get responses of a particular question
    @GetMapping("/survey/{surveyId}")
    public List<Response> getResponsesBySurveyId(@PathVariable Long surveyId) {
        return repo.findBySurveyId(surveyId);
    }
}

