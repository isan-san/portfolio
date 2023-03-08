package com.Fashion.portfolio.domain.common_project.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class ProjectCreated extends DomainEvent {

    private String description;
    private String paragraph;

    public ProjectCreated(String description, String paragraph) {
        super("franco.isan.ProjectCreated");
        this.description = description;
        this.paragraph = paragraph;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }
}
