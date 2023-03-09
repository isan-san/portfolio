package com.Fashion.portfolio.domain.ID_project_agregate;

import com.Fashion.portfolio.domain.ID_project_agregate.events.IDProjectCreated;
import com.Fashion.portfolio.domain.ID_project_agregate.values.IDProjectID;
import com.Fashion.portfolio.domain.ID_project_agregate.values.IDProjectState;
import com.Fashion.portfolio.domain.common_project.Project;
import com.Fashion.portfolio.domain.common_project.events.DescriptionContentAdded;
import com.Fashion.portfolio.domain.common_project.events.DesignerAdded;
import com.Fashion.portfolio.domain.common_project.events.DesignerRemoved;
import com.Fashion.portfolio.domain.common_project.events.MediaContentAdded;
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

    public void designerAdded(String name, String role, String description) {
        appendChange(new DesignerAdded(name, role, description)).apply();
    }

    public void designerRemoved(String name) {
        appendChange(new DesignerRemoved(name)).apply();
    }


    public void mediaContentAdded(String title, String description, String author, String URL){
        appendChange(new MediaContentAdded(title, description, author, URL)).apply();
    }

    public void descriptionContentAdded(String title, String description, String author, String paragraph){
        appendChange(new DescriptionContentAdded(title, description, author, paragraph)).apply();
    }

    protected Boolean removeDesigner(String name) {
        return removeDesigner(name);
    }


    protected void addDesigner(String name, String role, String description) {
        addDesigner(name, role, description);
    }

    protected void addMediaContent(String title, String description, String author, String URL) {
        addProjectMediaContent(title, description, author, URL);
    }

    protected void addDescriptionContent(String title, String description, String author, String paragraph) {
        addProjectDescriptionContent(title, description, author, paragraph);
    }
}
