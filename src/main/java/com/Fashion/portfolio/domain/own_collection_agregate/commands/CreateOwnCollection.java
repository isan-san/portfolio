package com.Fashion.portfolio.domain.own_collection_agregate.commands;

import com.Fashion.portfolio.generic.Command;

public class CreateOwnCollection extends Command {

    private final String projectDescription;
    private final String paragraph;
    private final String editor;
    private final String designTeamID;
    private final String projectContentID;

    public CreateOwnCollection(String projectDescription, String paragraph, String editor, String designTeamID, String projectContentID) {
        this.projectDescription = projectDescription;
        this.paragraph = paragraph;
        this.editor = editor;
        this.designTeamID = designTeamID;
        this.projectContentID = projectContentID;
    }

    public String getProjectDescription() {
        return projectDescription;
    }


    public String getParagraph() {
        return paragraph;
    }

    public String getEditor() {
        return editor;
    }

    public String getDesignTeamID() {
        return designTeamID;
    }

    public String getProjectContentID() {
        return projectContentID;
    }
}
