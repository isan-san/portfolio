package com.Fashion.portfolio.domain.common_project.commands;

import com.Fashion.portfolio.generic.Command;
import com.Fashion.portfolio.generic.DomainEvent;

public class PublishDescriptionContent extends Command {

    private final String contentTitle;
    private final String projectID;

    public PublishDescriptionContent(String contentTitle, String projectID) {
        this.contentTitle = contentTitle;
        this.projectID = projectID;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public String getProjectID() {
        return projectID;
    }
}
