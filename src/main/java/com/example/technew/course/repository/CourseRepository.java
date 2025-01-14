package com.example.technew.course.repository;

import com.example.technew.course.model.Course;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {

    private final JdbcTemplate jdbc;


    public CourseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void addNewCourse(Course course) {
        String sql = "INSERT INTO Courses (name, description, personID) VALUES (?, ?, ?)";
        jdbc.update(sql, course.getName(), course.getDescription(), course.getPersonID());
    }
}
