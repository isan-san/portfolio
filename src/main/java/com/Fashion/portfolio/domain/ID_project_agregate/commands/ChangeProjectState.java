package com.Fashion.portfolio.domain.ID_project_agregate.commands;

import com.Fashion.portfolio.generic.Command;

public class ChangeProjectState extends Command {

    private final String newState;
    private final String projectID;

    public ChangeProjectState(String newState, String projectID) {
        this.newState = newState;
        this.projectID = projectID;
    }

    public String getProjectID() {
        return projectID;
    }

    public String getNewState() {
        return newState;
    }
}
