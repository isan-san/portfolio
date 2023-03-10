package com.Fashion.portfolio.domain.featured_collection_agregate.commands;

import com.Fashion.portfolio.generic.Command;

public class CreateFeaturedCollection extends Command {

    private final String projectDescription;
    private final String paragraph;
    private final String name;
    private final String role;
    private final String partnerDescription;
    private final String editor;


    public CreateFeaturedCollection(String projectDescription, String paragraph, String name, String role, String partnerDescription, String author) {
        this.projectDescription = projectDescription;
        this.paragraph = paragraph;
        this.name = name;
        this.role = role;
        this.partnerDescription = partnerDescription;
        this.editor = author;
    }

    public String getProjectDescription() {
        return projectDescription;
    }


    public String getParagraph() {
        return paragraph;
    }


    public String getName() {
        return name;
    }


    public String getRole() {
        return role;
    }


    public String getPartnerDescription() {
        return partnerDescription;
    }


    public String getEditor() {
        return editor;
    }

}
