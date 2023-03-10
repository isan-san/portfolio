package com.Fashion.portfolio.domain.featured_collection_agregate;

import com.Fashion.portfolio.domain.common_project.events.*;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.FeaturedCollectionCreated;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.PartnerApproved;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.ProjectPublished;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.ProjectUnpublished;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.FeaturedPartner;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.PublishingInformation;
import com.Fashion.portfolio.generic.EventChange;

public class FeaturedCollectionChange extends EventChange {

    public FeaturedCollectionChange(FeaturedCollectionAggregate project) {
        apply((FeaturedCollectionCreated event) -> {
            project.designTeam(event.getDesignTeamID());
            project.projectContent(event.getProjectContentID());
            project.firstProjectContent(event.getProjectDescription(), event.getParagraph());
            project.publishingInformation = new PublishingInformation(event.getEditor());
            project.partner = new FeaturedPartner(event.getName(), event.getRole(), event.getPartnerDescription());
        });

        apply((DesignerAdded event) -> {
            project.addDesignerToTeam(event.getDesignerName(), event.getDesignerRole(), event.getDesignerDescription());
        });
        apply((DesignerRemoved event) -> {
            project.removeDesignerFromTeam(event.getDesignerName());
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
            project.publishingInformation = project.publishingInformation.partnerApprovement();
        });
        apply((ProjectPublished event) -> {
            project.publishingInformation = project.publishingInformation.publish();
        });
        apply((ProjectUnpublished event) -> {
            project.publishingInformation = project.publishingInformation.unpublish();
        });
    }

}

