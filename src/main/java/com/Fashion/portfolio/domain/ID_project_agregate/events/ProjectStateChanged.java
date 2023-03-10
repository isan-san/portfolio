package com.Fashion.portfolio.domain.ID_project_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class ProjectStateChanged extends DomainEvent {

    private final String newState;


    public ProjectStateChanged(String newState) {
        super("franco.isan.ProjectStateChanged");
        this.newState = newState;
    }

    public String getNewState() {
        return newState;
    }
}
