package com.Fashion.portfolio.domain.common_project.values;

import com.Fashion.portfolio.generic.ValueObject;

public class DescriptionContent extends Content implements ValueObject<DescriptionContent.Props> {

    private final String paragraph;
    private final MediaContent relatedMedia;

    public DescriptionContent(String title, String description, String author, String paragraph, MediaContent relatedMedia) {
        super(title, description, author);
        this.paragraph = paragraph;
        this.relatedMedia = relatedMedia;
    }

    public DescriptionContent(String title, String description, String author, String paragraph) {
        super(title, description, author);
        this.paragraph = paragraph;
        this.relatedMedia = null;
    }

    public DescriptionContent(String title, String description, String author, String paragraph, MediaContent relatedMedia, Boolean isPublic) {
        super(title, description, author, isPublic);
        this.paragraph = paragraph;
        this.relatedMedia = relatedMedia;
    }

    @Override
    public DescriptionContent publish() {
        return new DescriptionContent(this.title, this.description, this.author, this.paragraph, this.relatedMedia, true);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String title() {
                return title;
            }

            @Override
            public String description() {
                return description;
            }

            @Override
            public String author() {
                return author;
            }

            @Override
            public Boolean isPublic() {
                return isPublic;
            }

            @Override
            public String paragraph() {
                return paragraph;
            }

            @Override
            public MediaContent relatedMedia() {
                return relatedMedia;
            }
        };
    }

    public interface Props {
        String title();

        String description();

        String author();

        Boolean isPublic();

        String paragraph();

        MediaContent relatedMedia();
    }

}
