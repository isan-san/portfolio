package com.Fashion.portfolio.domain.featured_collection_agregate;

import com.Fashion.portfolio.domain.common_project.events.*;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.FeaturedCollectionCreated;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.PartnerApproved;
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

        apply((DesignerAdded event) -> {
            project.addDesigner(event.getDesignerName(), event.getDesignerRole(), event.getDesignerDescription());
        });
        apply((DesignerRemoved event) -> {
            project.removeDesigner(event.getDesignerName());
        });
        apply((MediaContentAdded event) -> {
            project.addMediaContent(event.getTitle(), event.getDescription(), event.getAuthor(), event.getURL());
        });
        apply((DescriptionContentAdded event) -> {
            project.addDescriptionContent(event.getTitle(), event.getDescription(), event.getAuthor(), event.getParagraph());
        });
        apply((DescriptionContentPublished event) -> {
            project.publishDescriptionContent(event.getContentTitle());
        });
        apply((MediaContentPublished event) -> {
            project.publishMediaContent(event.getContentTitle());
        });
        apply((PartnerApproved event) -> {
            project.publishingInformation.partnerApprovement();
        });
    }

}

