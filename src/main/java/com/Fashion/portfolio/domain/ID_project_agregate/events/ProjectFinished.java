package com.Fashion.portfolio.domain.ID_project_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class ProjectFinished extends DomainEvent {

    public ProjectFinished() {
        super("franco.isan.ProjectFinished");
    }
}
