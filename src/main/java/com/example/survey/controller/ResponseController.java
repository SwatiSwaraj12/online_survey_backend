package com.example.survey.controller;

import com.example.survey.model.Response;
import com.example.survey.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> addResponse(@RequestBody Response response) {

        // ✅ Validation
        if (response.getSurveyId() == null) {
            return ResponseEntity.badRequest().body("❌ surveyId is required");
        }

        if (response.getAnswer() == null || response.getAnswer().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("❌ answer is required");
        }

        Response saved = repo.save(response);
        return ResponseEntity.ok(saved);
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

    // ✅ Delete response (optional)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResponse(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.badRequest().body("❌ Response not found");
        }
        repo.deleteById(id);
        return ResponseEntity.ok("✅ Response deleted");
    }
}
