package com.Fashion.portfolio.domain.portfolio_agregate.events;

import com.Fashion.portfolio.domain.common_project.values.DescriptionContent;
import com.Fashion.portfolio.domain.common_project.values.MediaContent;
import com.Fashion.portfolio.generic.DomainEvent;

public class MediaContentAppended extends DomainEvent {

    private final MediaContent content;


    public MediaContentAppended(MediaContent content) {
        super("franco.isan.DescriptionContentAppended");
        this.content = content;
    }

    public MediaContent getContent() {
        return content;
    }
}
