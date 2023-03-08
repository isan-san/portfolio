package com.Fashion.portfolio.domain.ID_project_agregate;

import com.Fashion.portfolio.domain.ID_project_agregate.events.IDProjectCreated;
import com.Fashion.portfolio.domain.ID_project_agregate.values.IDProjectID;
import com.Fashion.portfolio.domain.ID_project_agregate.values.IDProjectState;
import com.Fashion.portfolio.domain.common_project.Project;
import com.Fashion.portfolio.domain.featured_collection_agregate.FeaturedCollectionAggregate;
import com.Fashion.portfolio.domain.featured_collection_agregate.FeaturedCollectionChange;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.FeaturedCollectionCreated;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.FeaturedCollectionID;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.ArrayList;

public class IDProjectAggregate extends Project<IDProjectID> {

    protected IDProjectState state;

    public IDProjectAggregate(IDProjectID ID, String projectDescription, String paragraph) {
        super(ID);
        subscribe(new IDProjectChange(this));
        appendChange(new IDProjectCreated(projectDescription, paragraph)).apply();
    }

    private IDProjectAggregate(String ID) {
        super(IDProjectID.of(ID));
    }

    private IDProjectAggregate from(String ID, ArrayList<DomainEvent> events) {
        IDProjectAggregate project = new IDProjectAggregate(ID);
        events.forEach(project::applyEvent);
        return project;
    }

    protected void firstProjectContent(String projectDescription, String paragraph) {
        firstContent(projectDescription, paragraph);
    }

}
