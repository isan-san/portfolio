package com.Fashion.portfolio.domain.ID_project_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class IDProjectCreated extends DomainEvent {

    private String projectDescription;
    private String paragraph;
    private final String designTeamID;
    private final String projectContentID;

    public IDProjectCreated(String projectDescription, String paragraph, String designTeamID, String projectContentID) {
        super("franco.isan.IDProjectCreated");
        this.projectDescription = projectDescription;
        this.paragraph = paragraph;
        this.designTeamID = designTeamID;
        this.projectContentID = projectContentID;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public String getDesignTeamID() {
        return designTeamID;
    }

    public String getProjectContentID() {
        return projectContentID;
    }
}
