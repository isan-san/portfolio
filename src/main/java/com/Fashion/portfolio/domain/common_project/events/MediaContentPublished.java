package com.Fashion.portfolio.domain.common_project.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class MediaContentPublished extends DomainEvent {

    private final String contentTitle;

    public MediaContentPublished(String contentTitle) {
        super("franco.isan.MediaContentPublished");
        this.contentTitle = contentTitle;
    }

    public String getContentTitle() {
        return contentTitle;
    }
}
