package com.Fashion.portfolio.domain.featured_collection_agregate;

import com.Fashion.portfolio.domain.common_project.Project;
import com.Fashion.portfolio.domain.common_project.events.DesignerAdded;
import com.Fashion.portfolio.domain.common_project.events.DesignerRemoved;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.FeaturedCollectionCreated;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.FeaturedCollectionID;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.FeaturedPartner;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.PublishingInformation;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class FeaturedCollectionAggregate extends Project<FeaturedCollectionID> {

    protected FeaturedPartner partner;
    protected PublishingInformation publishingInformation;

    public FeaturedCollectionAggregate(String projectDescription, String paragraph,
                                       String name, String role, String partnerDescription, String editor) {
        super(new FeaturedCollectionID());
        subscribe(new FeaturedCollectionChange(this));
        appendChange(new FeaturedCollectionCreated(projectDescription, paragraph, name, role, partnerDescription, editor)).apply();
    }

    private FeaturedCollectionAggregate(String ID) {
        super(FeaturedCollectionID.of(ID));
    }


    public static FeaturedCollectionAggregate from(String ID, List<DomainEvent> events) {
        FeaturedCollectionAggregate project = new FeaturedCollectionAggregate(ID);
        events.forEach(project::applyEvent);
        return project;
    }

    protected void firstProjectContent(String projectDescription, String paragraph) {
        firstContent(projectDescription, paragraph);
    }

    public void designerAdded(String name, String role, String description) {
        appendChange(new DesignerAdded(name, role, description)).apply();
    }

    public void designerRemoved(String name) {
        appendChange(new DesignerRemoved(name)).apply();
    }

    protected Boolean removeDesigner(String name) {
        return removeDesigner(name);
    }

    protected void addDesigner(String name, String role, String description) {
        addDesigner(name, role, description);
    }

}
