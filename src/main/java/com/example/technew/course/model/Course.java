package com.example.technew.course.model;

public class Course {

    private int courseID;
    private String name;
    private String description;
    private int personID;

    public Course() {
    }

    public Course(int courseID, String name, String description, int personID) {
        this.courseID = courseID;
        this.name = name;
        this.description = description;
        this.personID = personID;
    }

    public int getCourseID() {
        return courseID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPersonID() {
        return personID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }
}
