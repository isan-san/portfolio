package com.Fashion.portfolio.domain.own_collection_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class OwnCollectionCreated extends DomainEvent {

    private final String projectDescription;
    private final String paragraph;
    private final String editor;

    public OwnCollectionCreated(String projectDescription, String paragraph, String editor) {
        super("franco.isan.OwnCollectionCreated");
        this.projectDescription = projectDescription;
        this.paragraph = paragraph;
        this.editor = editor;
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
}
