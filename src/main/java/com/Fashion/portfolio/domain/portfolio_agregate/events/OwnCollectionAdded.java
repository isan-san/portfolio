package com.Fashion.portfolio.domain.portfolio_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class OwnCollectionAdded extends DomainEvent {

    private final String collectionID;

    public OwnCollectionAdded(String collectionID) {
        super("franco.isan.OwnCollectionAdded");
        this.collectionID = collectionID;
    }

    public String getCollectionID() {
        return collectionID;
    }
}