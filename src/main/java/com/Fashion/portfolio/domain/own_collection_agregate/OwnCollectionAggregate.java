package com.Fashion.portfolio.domain.own_collection_agregate;

import com.Fashion.portfolio.domain.common_project.Project;
import com.Fashion.portfolio.domain.featured_collection_agregate.FeaturedCollectionAggregate;
import com.Fashion.portfolio.domain.featured_collection_agregate.FeaturedCollectionChange;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.FeaturedCollectionCreated;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.FeaturedCollectionID;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.FeaturedPartner;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.PublishingInformation;
import com.Fashion.portfolio.domain.own_collection_agregate.events.OwnCollectionCreated;
import com.Fashion.portfolio.domain.own_collection_agregate.values.OwnCollectionID;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.ArrayList;

public class OwnCollectionAggregate extends Project<OwnCollectionID> {

    protected FeaturedPartner partner;
    protected PublishingInformation publishingInformation;

    public OwnCollectionAggregate(String projectDescription, String paragraph,
                                       String name,    String role,    String partnerDescription) {
        super(new OwnCollectionID());
        subscribe(new OwnCollectionChange(this));
        appendChange(new OwnCollectionCreated(projectDescription, paragraph)).apply();
    }
    private OwnCollectionAggregate(String ID){
        super(OwnCollectionID.of(ID));
    }

    private OwnCollectionAggregate from(String ID, ArrayList<DomainEvent> events){
        OwnCollectionAggregate project = new OwnCollectionAggregate(ID);
        events.forEach(project::applyEvent);
        return project;
    }

    protected void firstProjectContent(String projectDescription, String paragraph){
        firstContent(projectDescription, paragraph);
    }

}
