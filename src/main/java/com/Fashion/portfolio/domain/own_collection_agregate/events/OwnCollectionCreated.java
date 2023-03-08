package com.Fashion.portfolio.domain.own_collection_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class OwnCollectionCreated extends DomainEvent {

    private String projectDescription;
    private String paragraph;

    public OwnCollectionCreated(String projectDescription, String paragraph) {
        super("franco.isan.OwnCollectionCreated");
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
