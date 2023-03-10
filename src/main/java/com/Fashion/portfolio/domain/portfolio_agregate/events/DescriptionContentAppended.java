package com.Fashion.portfolio.domain.portfolio_agregate.events;

import com.Fashion.portfolio.domain.common_project.values.DescriptionContent;
import com.Fashion.portfolio.generic.DomainEvent;

public class DescriptionContentAppended extends DomainEvent {

    private final DescriptionContent content;


    public DescriptionContentAppended(DescriptionContent content) {
        super("franco.isan.DescriptionContentAppended");
        this.content = content;
    }

    public DescriptionContent getContent() {
        return content;
    }
}
