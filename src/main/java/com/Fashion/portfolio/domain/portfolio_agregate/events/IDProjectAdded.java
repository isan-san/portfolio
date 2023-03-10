package com.Fashion.portfolio.domain.portfolio_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class IDProjectAdded extends DomainEvent {

    private final String projectID;

    public IDProjectAdded( String collectionID) {
        super("franco.isan.IDProjectAdded");
        this.projectID = collectionID;
    }

    public String getProjectID() {
        return projectID;
    }
}