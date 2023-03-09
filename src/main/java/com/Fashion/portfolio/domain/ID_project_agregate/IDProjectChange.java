package com.Fashion.portfolio.domain.ID_project_agregate;

import com.Fashion.portfolio.domain.ID_project_agregate.values.IDProjectState;
import com.Fashion.portfolio.domain.common_project.events.DescriptionContentAdded;
import com.Fashion.portfolio.domain.common_project.events.DesignerAdded;
import com.Fashion.portfolio.domain.common_project.events.DesignerRemoved;
import com.Fashion.portfolio.domain.common_project.events.MediaContentAdded;
import com.Fashion.portfolio.domain.featured_collection_agregate.FeaturedCollectionAggregate;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.FeaturedCollectionCreated;
import com.Fashion.portfolio.generic.EventChange;

public class IDProjectChange extends EventChange {

    public IDProjectChange(IDProjectAggregate project) {
        apply((FeaturedCollectionCreated event) -> {
            project.firstProjectContent(event.getProjectDescription(), event.getParagraph());
            project.state = new IDProjectState();
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

    }

}
