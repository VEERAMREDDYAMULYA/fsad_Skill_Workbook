package com.klu.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.CourseRepository.CourseRepository;
import com.klu.entity.Course;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public Course addCourse(Course course) {
        return repository.save(course);
    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return repository.findById(id);
    }

    public Course updateCourse(Long id, Course newCourse) {
        Optional<Course> existing = repository.findById(id);

        if(existing.isPresent()) {
            Course course = existing.get();
            course.setTitle(newCourse.getTitle());
            course.setDuration(newCourse.getDuration());
            course.setFee(newCourse.getFee());
            return repository.save(course);
        }
        return null;
    }

    public boolean deleteCourse(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Course> searchByTitle(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }
}