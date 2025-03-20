package com.example.EnrollmentService.controller;

import com.example.EnrollmentService.service.EnrollmentService;
import com.example.EnrollmentService.service.impl.EnrollmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    @Autowired
    private EnrollmentServiceImpl enrollmentServiceImpl;

    @PostMapping("/enrollCourse")
    public ResponseEntity<?> enrollmentCourse(@RequestParam Long studentId, @RequestParam Long courseId){
        try{
            enrollmentServiceImpl.enrollment(studentId,courseId);
            return ResponseEntity.ok("Student enrolled successfully");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/{studentId}/{courseId}")
    public ResponseEntity<?> updateProgress(@PathVariable Long studentId, @PathVariable Long courseId, @RequestParam int progress){
        try {
            String result = enrollmentServiceImpl.updateProgress(studentId, courseId, progress);
            return ResponseEntity.ok(result);
        }catch(RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/{studentId}/{courseId}/progress")
    public ResponseEntity<?> getProgress(@PathVariable Long studentId, @PathVariable Long courseId) {
        try {
            Integer progress = enrollmentServiceImpl.getProgress(studentId, courseId);
            return ResponseEntity.ok(progress);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}
