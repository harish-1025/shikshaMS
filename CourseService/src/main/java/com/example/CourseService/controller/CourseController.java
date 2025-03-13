package com.example.CourseService.controller;

import com.example.CourseService.dto.CourseDto;
import com.example.CourseService.entity.Course;
import com.example.CourseService.service.CourseService;
import com.example.CourseService.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseServiceImpl courseServiceImpl;

    @PostMapping("/createCourse/{userId}")
    public ResponseEntity<?> createCourse(@RequestBody Course course,@PathVariable Long userId){
        try{
            CourseDto createdCourse=courseServiceImpl.createCourse(course,userId);
            return ResponseEntity.ok(createdCourse);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/getAllCourse")
    public List<CourseDto> getAllCourse(){
        return courseServiceImpl.getAllCourse();
    }

    @GetMapping("/getCourseById/{id}")
    public ResponseEntity <?> getCourseById(@PathVariable Long id){
        try {
            Optional<Course> course = courseServiceImpl.getCourseById(id);
            return ResponseEntity.ok(course);
        }catch(RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long courseId,@RequestParam Long userId){
        try{
            courseServiceImpl.deleteCourse(courseId,userId);
            return ResponseEntity.ok("Deleted successfully");
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
