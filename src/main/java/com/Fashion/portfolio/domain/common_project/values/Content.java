package com.Fashion.portfolio.domain.common_project.values;


public abstract class Content {

    protected final String title;
    protected final String description;
    protected final String author;
    protected final Boolean isPublic;

    public Content(String title, String description, String author) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.isPublic = false;
    }

    public Content(String title, String description, String author, Boolean isPublic) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.isPublic = isPublic;
    }

    public abstract <T extends Content> T publish();

}
