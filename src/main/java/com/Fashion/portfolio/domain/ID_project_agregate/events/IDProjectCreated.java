package com.Fashion.portfolio.domain.ID_project_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class IDProjectCreated extends DomainEvent {

    private String projectDescription;
    private String paragraph;

    public IDProjectCreated(String projectDescription, String paragraph) {
        super("franco.isan.IDProjectCreated");
        this.projectDescription = projectDescription;
        this.paragraph = paragraph;
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
}
