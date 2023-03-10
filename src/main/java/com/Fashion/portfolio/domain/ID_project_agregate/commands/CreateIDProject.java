package com.Fashion.portfolio.domain.ID_project_agregate.commands;

import com.Fashion.portfolio.generic.Command;

public class CreateIDProject extends Command {

    private final String projectDescription;
    private final String paragraph;
    private final String designTeamID;
    private final String projectContentID;

    public CreateIDProject(String projectDescription, String paragraph, String designTeamID, String projectContentID) {
        this.projectDescription = projectDescription;
        this.paragraph = paragraph;
        this.designTeamID = designTeamID;
        this.projectContentID = projectContentID;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public String getParagraph() {
        return paragraph;
    }

    public String getDesignTeamID() {
        return designTeamID;
    }

    public String getProjectContentID() {
        return projectContentID;
    }
}
