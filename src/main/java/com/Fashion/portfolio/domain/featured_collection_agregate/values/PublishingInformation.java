package com.Fashion.portfolio.domain.featured_collection_agregate.values;

import com.Fashion.portfolio.generic.ValueObject;

import java.time.LocalDate;

public class PublishingInformation implements ValueObject<PublishingInformation.Props> {

    private final Boolean isPublished;
    private final LocalDate publishingDate;
    private final String editor;
    private final Boolean partnerAproval;

    private PublishingInformation(Boolean isPublished, LocalDate publishingDate, String editor, Boolean partnerAproval) {
        this.isPublished = isPublished;
        this.publishingDate = publishingDate;
        this.editor = editor;
        this.partnerAproval = partnerAproval;
    }

    public PublishingInformation(String editor) {
        this.partnerAproval = false;
        this.isPublished = false;
        this.publishingDate = null;
        this.editor = editor;
    }

    public PublishingInformation publish(){
        if (this.partnerAproval) {
            return new PublishingInformation(true, LocalDate.now(), this.editor, true);
        }else{
            return null;
        }
    }

    public PublishingInformation partnerApprovement(){
        return new PublishingInformation(this.isPublished, this.publishingDate, this.editor, true);
    }

    @Override
    public PublishingInformation.Props value() {
        return new Props() {
            @Override
            public Boolean isPublished() {
                return isPublished;
            }

            @Override
            public LocalDate publishingDate() {
                return publishingDate;
            }

            @Override
            public String editor() {
                return editor;
            }

            @Override
            public Boolean partnerAproval() {
                return partnerAproval;
            }
        };
    }

    public interface Props {
        Boolean isPublished();
        LocalDate publishingDate();
        String editor();
        Boolean partnerAproval();
    }
}
