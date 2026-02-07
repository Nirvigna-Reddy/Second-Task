package com.example.feedback;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class FeedbackController {

    @Autowired
    private FeedbackRepository feedbackRepository;

    // Save feedback to DB
    @PostMapping("/feedback")
    public String submitFeedback(
            @RequestParam String username,
            @RequestParam String useremail,
            @RequestParam String feedback) {

        Feedback fb = new Feedback();
        fb.setUsername(username);
        fb.setUserEmail(useremail);
        fb.setFeedback(feedback);

        feedbackRepository.save(fb);

        return "Feedback saved successfully";
    }

    // Show all feedbacks (JSON)
    @GetMapping("/contacts")
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }
}
