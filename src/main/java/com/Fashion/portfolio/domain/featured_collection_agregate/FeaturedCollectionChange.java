package com.Fashion.portfolio.domain.featured_collection_agregate;

import com.Fashion.portfolio.domain.featured_collection_agregate.events.FeaturedCollectionCreated;
import com.Fashion.portfolio.generic.EventChange;

public class FeaturedCollectionChange extends EventChange {

    public FeaturedCollectionChange(FeaturedCollectionAggregate project) {
        apply((FeaturedCollectionCreated event) -> {
            project.firstProjectContent(event.getProjectDescription(), event.getParagraph());
        });

    }

}

