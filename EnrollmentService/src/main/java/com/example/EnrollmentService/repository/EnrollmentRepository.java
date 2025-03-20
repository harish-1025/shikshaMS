package com.example.EnrollmentService.repository;

import com.example.EnrollmentService.dto.CourseDto;
import com.example.EnrollmentService.dto.UserDto;
import com.example.EnrollmentService.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
    Enrollment findByStudentIdAndCourseId(Long studentId, Long courseId);
}
