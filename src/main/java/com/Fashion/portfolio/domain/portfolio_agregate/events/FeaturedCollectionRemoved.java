package com.Fashion.portfolio.domain.portfolio_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class FeaturedCollectionRemoved extends DomainEvent {

    private final String collectionID;

    public FeaturedCollectionRemoved(String collectionID) {
        super("franco.isan.FeaturedCollectionUnpublished");
        this.collectionID = collectionID;
    }

    public String getCollectionID() {
        return collectionID;
    }
}
