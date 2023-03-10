package com.Fashion.portfolio.domain.common_project.commands;

import com.Fashion.portfolio.generic.Command;

public class AddDescriptionContent extends Command {
    private final String title;
    private final String description;
    private final String author;
    private final String paragraph;
    private final String projectID;



    public AddDescriptionContent(String title, String description, String author, String paragraph, String projectID) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.paragraph = paragraph;
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

    public String getParagraph() {
        return paragraph;
    }

    public String getProjectID() {
        return projectID;
    }
}
