package com.Fashion.portfolio.domain.featured_collection_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class ProjectPublished extends DomainEvent {
    public ProjectPublished() {
        super("franco.isan.ProjectPublished");
    }
}
