package com.Fashion.portfolio.domain.own_collection_agregate;

import com.Fashion.portfolio.domain.common_project.events.*;
import com.Fashion.portfolio.domain.own_collection_agregate.events.OwnCollectionCreated;
import com.Fashion.portfolio.domain.own_collection_agregate.events.ProjectPublished;
import com.Fashion.portfolio.domain.own_collection_agregate.values.PublishingInformation;
import com.Fashion.portfolio.generic.EventChange;

public class OwnCollectionChange extends EventChange {

    public OwnCollectionChange(OwnCollectionAggregate project) {
        apply((OwnCollectionCreated event) -> {
            project.designTeam(event.getDesignTeamID());
            project.projectContent(event.getProjectContentID());
            project.firstProjectContent(event.getProjectDescription(), event.getParagraph());
            project.publishingInformation = new PublishingInformation(event.getEditor());
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
            project.publishDescription(event.getContentTitle());
        });
        apply((MediaContentPublished event) -> {
            project.publishMedia(event.getContentTitle());
        });
        apply((ProjectPublished event) -> {
            project.publishingInformation.publish();
        });

    }

}
