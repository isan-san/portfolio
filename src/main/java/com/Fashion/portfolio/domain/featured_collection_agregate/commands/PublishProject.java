package com.Fashion.portfolio.domain.featured_collection_agregate.commands;

import com.Fashion.portfolio.generic.Command;

public class PublishProject extends Command {

    private final String projectID;

    public PublishProject(String projectID) {
        this.projectID = projectID;
    }

    public String getProjectID() {
        return projectID;
    }
}
