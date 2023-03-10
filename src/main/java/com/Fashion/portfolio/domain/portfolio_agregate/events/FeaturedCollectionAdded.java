package com.Fashion.portfolio.domain.portfolio_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class FeaturedCollectionAdded extends DomainEvent {

    private final String collectionID;

    public FeaturedCollectionAdded(String collectionID) {
        super("franco.isan.FeaturedCollectionAdded");
        this.collectionID = collectionID;
    }

    public String getCollectionID() {
        return collectionID;
    }
}
