package com.Fashion.portfolio.domain.ID_project_agregate;

import com.Fashion.portfolio.domain.ID_project_agregate.events.IDProjectCreated;
import com.Fashion.portfolio.domain.ID_project_agregate.events.ProjectFinished;
import com.Fashion.portfolio.domain.ID_project_agregate.events.ProjectStateChanged;
import com.Fashion.portfolio.domain.ID_project_agregate.values.IDProjectID;
import com.Fashion.portfolio.domain.ID_project_agregate.values.IDProjectState;
import com.Fashion.portfolio.domain.common_project.DesignTeam;
import com.Fashion.portfolio.domain.common_project.Project;
import com.Fashion.portfolio.domain.common_project.ProjectContent;
import com.Fashion.portfolio.domain.common_project.events.*;
import com.Fashion.portfolio.domain.common_project.values.DesignTeamID;
import com.Fashion.portfolio.domain.common_project.values.ProjectContentID;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;

public class IDProjectAggregate extends Project<IDProjectID> {

    protected IDProjectState state;

    public IDProjectAggregate(String projectDescription, String paragraph, String designTeamID, String projectContentID) {
        super(new IDProjectID());
        subscribe(new IDProjectChange(this));
        appendChange(new IDProjectCreated(projectDescription, paragraph, designTeamID, projectContentID)).apply();
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


    public void mediaContentAdded(String title, String description, String author, String URL) {
        appendChange(new MediaContentAdded(title, description, author, URL)).apply();
    }

    public void descriptionContentAdded(String title, String description, String author, String paragraph) {
        appendChange(new DescriptionContentAdded(title, description, author, paragraph)).apply();
    }

    public void descriptionContentPublished(String title) {
        appendChange(new DescriptionContentPublished(title)).apply();
    }

    public void mediaContentPublished(String title) {
        appendChange(new MediaContentPublished(title)).apply();
    }

    public void projectFinished() {
        appendChange(new ProjectFinished());
    }

    public void projectStateChanged(String newState) {
        appendChange(new ProjectStateChanged(newState));
    }

    public Boolean verifyProjectFinished() {
        return this.state.value().isActive();
    }

    public void designTeam(String designTeamID) {
        this.designTeam = new DesignTeam(DesignTeamID.of(designTeamID));
    }

    public void projectContent(String designTeamID) {
        this.projectContent = new ProjectContent(ProjectContentID.of(designTeamID));
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

    protected void publishDescription(String title) {
        this.publishDescription(title);
    }

    protected void publishMedia(String title) {
        publishMedia(title);
    }
}
