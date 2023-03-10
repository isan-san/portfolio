package com.Fashion.portfolio.domain.featured_collection_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class ProjectUnpublished extends DomainEvent {
    public ProjectUnpublished() {
        super("franco.isan.ProjectPublished");
    }
}
