package com.Fashion.portfolio.domain.featured_collection_agregate;

import com.Fashion.portfolio.domain.common_project.Project;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.FeaturedCollectionCreated;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.FeaturedCollectionID;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.FeaturedPartner;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.PublishingInformation;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.ArrayList;

public class FeaturedCollectionAggregate extends Project<FeaturedCollectionID> {

    protected FeaturedPartner partner;
    protected PublishingInformation publishingInformation;

    public FeaturedCollectionAggregate(String projectDescription, String paragraph,
                                       String name, String role, String partnerDescription) {
        super(new FeaturedCollectionID());
        subscribe(new FeaturedCollectionChange(this));
        appendChange(new FeaturedCollectionCreated(projectDescription, paragraph, name, role, partnerDescription)).apply();
    }

    private FeaturedCollectionAggregate(String ID) {
        super(FeaturedCollectionID.of(ID));
    }

    private FeaturedCollectionAggregate from(String ID, ArrayList<DomainEvent> events) {
        FeaturedCollectionAggregate project = new FeaturedCollectionAggregate(ID);
        events.forEach(project::applyEvent);
        return project;
    }

    protected void firstProjectContent(String projectDescription, String paragraph) {
        firstContent(projectDescription, paragraph);
    }

}
