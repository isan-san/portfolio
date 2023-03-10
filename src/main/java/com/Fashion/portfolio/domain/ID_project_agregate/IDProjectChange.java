package com.Fashion.portfolio.domain.ID_project_agregate;

import com.Fashion.portfolio.domain.ID_project_agregate.events.IDProjectCreated;
import com.Fashion.portfolio.domain.ID_project_agregate.events.ProjectFinished;
import com.Fashion.portfolio.domain.ID_project_agregate.events.ProjectStateChanged;
import com.Fashion.portfolio.domain.ID_project_agregate.values.IDProjectState;
import com.Fashion.portfolio.domain.common_project.events.*;
import com.Fashion.portfolio.generic.EventChange;

public class IDProjectChange extends EventChange {

    public IDProjectChange(IDProjectAggregate project) {
        apply((IDProjectCreated event) -> {
            project.designTeam(event.getDesignTeamID());
            project.projectContent(event.getProjectContentID());
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
        apply((DescriptionContentPublished event) -> {
            project.publishDescription(event.getContentTitle());
        });
        apply((MediaContentPublished event) -> {
            project.publishMedia(event.getContentTitle());
        });
        apply((ProjectStateChanged event) -> {
            project.state.changeState(event.getNewState());
        });
        apply((ProjectFinished event) -> {
            project.state.finish();
        });

    }

}
