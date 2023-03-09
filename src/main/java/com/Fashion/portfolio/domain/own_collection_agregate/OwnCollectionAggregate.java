package com.Fashion.portfolio.domain.own_collection_agregate;

import com.Fashion.portfolio.domain.common_project.Project;
import com.Fashion.portfolio.domain.common_project.events.DesignerAdded;
import com.Fashion.portfolio.domain.common_project.events.DesignerRemoved;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.PublishingInformation;
import com.Fashion.portfolio.domain.own_collection_agregate.events.OwnCollectionCreated;
import com.Fashion.portfolio.domain.own_collection_agregate.values.OwnCollectionID;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class OwnCollectionAggregate extends Project<OwnCollectionID> {

    protected PublishingInformation publishingInformation;

    public OwnCollectionAggregate(String projectDescription, String paragraph,
                                  String editor) {
        super(new OwnCollectionID());
        subscribe(new OwnCollectionChange(this));
        appendChange(new OwnCollectionCreated(projectDescription, paragraph, editor)).apply();
    }

    private OwnCollectionAggregate(String ID) {
        super(OwnCollectionID.of(ID));
    }

    public static OwnCollectionAggregate from(String ID, List<DomainEvent> events) {
        OwnCollectionAggregate project = new OwnCollectionAggregate(ID);
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
