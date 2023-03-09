package com.Fashion.portfolio.domain.common_project.commands;

import com.Fashion.portfolio.generic.Command;
import com.Fashion.portfolio.generic.DomainEvent;

public class AddDesigner extends Command {

    private final String name;
    private final String role;
    private final String description;
    private final String projectID;


    public AddDesigner(String name, String role, String description, String projectID) {
        this.name = name;
        this.role = role;
        this.description = description;
        this.projectID = projectID;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }

    public String getProjectID() {
        return projectID;
    }
}
