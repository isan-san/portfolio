package com.Fashion.portfolio.domain.featured_collection_agregate;

import com.Fashion.portfolio.domain.featured_collection_agregate.events.FeaturedCollectionCreated;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.FeaturedPartner;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.PublishingInformation;
import com.Fashion.portfolio.generic.EventChange;

public class FeaturedCollectionChange extends EventChange {

    public FeaturedCollectionChange(FeaturedCollectionAggregate project) {
        apply((FeaturedCollectionCreated event) -> {
            project.firstProjectContent(event.getProjectDescription(), event.getParagraph());
            project.publishingInformation = new PublishingInformation(event.getEditor());
            project.partner = new FeaturedPartner(event.getName(), event.getRole(), event.getPartnerDescription());
        });

    }

}

