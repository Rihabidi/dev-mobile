package com.example.internship_app;

public class CV {

    private String FullName,Education,Experience,Skills;

    public CV( ) {

    }

    public CV(String fullName, String education, String experience, String skills) {
        FullName = fullName;
        Education = education;
        Experience = experience;
        Skills = skills;
    }

    public String getFullName() {
        return FullName;
    }

    public String getEducation() {
        return Education;
    }

    public String getExperience() {
        return Experience;
    }

    public String getSkills() {
        return Skills;
    }
}
