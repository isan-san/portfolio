package com.Fashion.portfolio.domain.ID_project_agregate.commands;

import com.Fashion.portfolio.generic.Command;

public class FinishProject extends Command {

    private final String projectID;

    public FinishProject(String projectID) {
        this.projectID = projectID;
    }

    public String getProjectID() {
        return projectID;
    }
}
