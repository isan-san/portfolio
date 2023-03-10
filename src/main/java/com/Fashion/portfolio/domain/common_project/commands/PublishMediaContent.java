package com.Fashion.portfolio.domain.common_project.commands;

import com.Fashion.portfolio.generic.Command;

public class PublishMediaContent extends Command {

    private final String contentTitle;
    private final String projectID;

    public PublishMediaContent(String contentTitle, String projectID) {
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
