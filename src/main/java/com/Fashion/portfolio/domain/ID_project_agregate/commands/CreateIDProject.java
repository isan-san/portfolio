package com.Fashion.portfolio.domain.ID_project_agregate.commands;

import com.Fashion.portfolio.generic.Command;
import com.Fashion.portfolio.generic.DomainEvent;

public class CreateIDProject extends Command {

    private final String projectDescription;
    private final String paragraph;

    public CreateIDProject(String projectDescription, String paragraph) {
        this.projectDescription = projectDescription;
        this.paragraph = paragraph;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public String getParagraph() {
        return paragraph;
    }
}
