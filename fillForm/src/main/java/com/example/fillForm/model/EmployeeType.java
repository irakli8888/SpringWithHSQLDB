package com.example.fillForm.model;

public enum EmployeeType {
    JUNIOR ("JUNIOR"),
    MIDDLE ("MIDDLE"),
    SENIOR ("SENIOR"),
    TEAM_LEAD ("TEAM LEAD");

    private final String classification;

    EmployeeType(String classification) {
        this.classification = classification;
    }

    public String getType(){
        return classification;
    }
}
