package com.Fashion.portfolio.domain.own_collection_agregate;

import com.Fashion.portfolio.domain.featured_collection_agregate.FeaturedCollectionAggregate;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.FeaturedCollectionCreated;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.PublishingInformation;
import com.Fashion.portfolio.domain.own_collection_agregate.events.OwnCollectionCreated;
import com.Fashion.portfolio.generic.EventChange;

public class OwnCollectionChange extends EventChange {

    public OwnCollectionChange(OwnCollectionAggregate project) {
        apply((OwnCollectionCreated event) -> {
            project.firstProjectContent(event.getProjectDescription(), event.getParagraph());
            project.publishingInformation = new PublishingInformation(event.getEditor());
        });

    }

}
