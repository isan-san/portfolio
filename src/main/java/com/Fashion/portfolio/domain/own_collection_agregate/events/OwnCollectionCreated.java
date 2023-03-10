package com.Fashion.portfolio.domain.own_collection_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class OwnCollectionCreated extends DomainEvent {

    private final String projectDescription;
    private final String paragraph;
    private final String editor;
    private final String designTeamID;
    private final String projectContentID;

    public OwnCollectionCreated(String projectDescription, String paragraph, String editor, String designTeamID, String projectContentID) {
        super("franco.isan.OwnCollectionCreated");
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
