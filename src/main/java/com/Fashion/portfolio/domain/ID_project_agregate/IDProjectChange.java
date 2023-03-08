package com.Fashion.portfolio.domain.ID_project_agregate;

import com.Fashion.portfolio.domain.ID_project_agregate.values.IDProjectState;
import com.Fashion.portfolio.domain.featured_collection_agregate.FeaturedCollectionAggregate;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.FeaturedCollectionCreated;
import com.Fashion.portfolio.generic.EventChange;

public class IDProjectChange extends EventChange {

    public IDProjectChange(IDProjectAggregate project) {
        apply((FeaturedCollectionCreated event) -> {
            project.firstProjectContent(event.getProjectDescription(), event.getParagraph());
            project.state = new IDProjectState();
        });

    }

}
