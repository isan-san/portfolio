package com.Fashion.portfolio.domain.own_collection_agregate.values;

import com.Fashion.portfolio.generic.ValueObject;

import java.time.LocalDate;

public class PublishingInformation implements ValueObject<PublishingInformation.Props> {

    private final Boolean isPublished;
    private final LocalDate publishingDate;
    private final String editor;

    private PublishingInformation(Boolean isPublished, LocalDate publishingDate, String editor) {
        this.isPublished = isPublished;
        this.publishingDate = publishingDate;
        this.editor = editor;
    }

    private PublishingInformation(String editor) {
        this.isPublished = false;
        this.publishingDate = null;
        this.editor = editor;
    }

    public PublishingInformation publish() {
        return new PublishingInformation(true, LocalDate.now(), this.editor);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Boolean isPublished() {
                return isPublished;
            }

            @Override
            public LocalDate publishingDate() {
                return publishingDate;
            }
        };
    }

    public interface Props {
        Boolean isPublished();

        LocalDate publishingDate();
    }
}
