package com.Fashion.portfolio.domain.common_project.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class DescriptionContentAdded extends DomainEvent {
    private final String title;
    private final String description;
    private final String author;
    private final String paragraph;

    public DescriptionContentAdded(String title, String description, String author, String paragraph) {
        super("franco.isan.DescriptionContentAdded");
        this.title = title;
        this.description = description;
        this.author = author;
        this.paragraph = paragraph;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    public String getParagraph() {
        return paragraph;
    }
}
