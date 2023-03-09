package com.Fashion.portfolio.domain.own_collection_agregate.commands;

import com.Fashion.portfolio.generic.Command;
import com.Fashion.portfolio.generic.DomainEvent;

public class CreateOwnCollection extends Command {

    private final String projectDescription;
    private final String paragraph;
    private final String editor;

    public CreateOwnCollection(String projectDescription, String paragraph, String editor) {
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
