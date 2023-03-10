package com.Fashion.portfolio.domain.common_project.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class DescriptionContentPublished extends DomainEvent {

    private final String contentTitle;

    public DescriptionContentPublished(String contentTitle) {
        super("franco.isan.DescriptionContentPublished");
        this.contentTitle = contentTitle;
    }

    public String getContentTitle() {
        return contentTitle;
    }
}
