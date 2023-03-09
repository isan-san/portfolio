package com.Fashion.portfolio.domain.common_project.commands;

import com.Fashion.portfolio.generic.Command;

public class AddMediaContent extends Command {
    private final String title;
    private final String description;
    private final String author;
    private final String URL;
    private final String projectID;

    public AddMediaContent(String title, String description, String author, String url, String projectID) {
        this.title = title;
        this.description = description;
        this.author = author;
        URL = url;
        this.projectID = projectID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getURL() {
        return URL;
    }

    public String getProjectID() {
        return projectID;
    }
}
