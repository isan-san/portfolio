package com.Fashion.portfolio.domain.ID_project_agregate;

import com.Fashion.portfolio.domain.ID_project_agregate.events.IDProjectCreated;
import com.Fashion.portfolio.domain.ID_project_agregate.values.IDProjectID;
import com.Fashion.portfolio.domain.ID_project_agregate.values.IDProjectState;
import com.Fashion.portfolio.domain.common_project.Project;
import com.Fashion.portfolio.domain.common_project.events.DesignerAdded;
import com.Fashion.portfolio.domain.common_project.events.DesignerRemoved;
import com.Fashion.portfolio.domain.featured_collection_agregate.FeaturedCollectionAggregate;
import com.Fashion.portfolio.domain.featured_collection_agregate.FeaturedCollectionChange;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.FeaturedCollectionCreated;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.FeaturedCollectionID;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class IDProjectAggregate extends Project<IDProjectID> {

    protected IDProjectState state;

    public IDProjectAggregate(String projectDescription, String paragraph) {
        super(new IDProjectID());
        subscribe(new IDProjectChange(this));
        appendChange(new IDProjectCreated(projectDescription, paragraph)).apply();
    }

    private IDProjectAggregate(String ID) {
        super(IDProjectID.of(ID));
    }

    public static IDProjectAggregate from(String ID, List<DomainEvent> events) {
        IDProjectAggregate project = new IDProjectAggregate(ID);
        events.forEach(project::applyEvent);
        return project;
    }

    protected void firstProjectContent(String projectDescription, String paragraph) {
        firstContent(projectDescription, paragraph);
    }

    public void designerRemoved(String name) {
        appendChange(new DesignerRemoved(name)).apply();
    }

    protected Boolean removeDesigner(String name) {
        return removeDesigner(name);
    }

    public void designerAdded(String name, String role, String description) {
        appendChange(new DesignerAdded(name, role, description)).apply();
    }

    protected void addDesigner(String name, String role, String description) {
        addDesigner(name, role, description);
    }

}
