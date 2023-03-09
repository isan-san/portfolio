package com.Fashion.portfolio.domain.common_project.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class MediaContentAdded extends DomainEvent {
    private final String title;
    private final String description;
    private final String author;
    private final String URL;

    public MediaContentAdded(String title, String description, String author, String url) {
        super("franco.isan.MediaContentAdded");
        this.title = title;
        this.description = description;
        this.author = author;
        URL = url;
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

    public String getURL() {
        return URL;
    }
}
