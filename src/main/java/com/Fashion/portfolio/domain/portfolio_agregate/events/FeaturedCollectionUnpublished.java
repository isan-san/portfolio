package com.Fashion.portfolio.domain.portfolio_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class FeaturedCollectionUnpublished extends DomainEvent {

    private final String collectionID;

    public FeaturedCollectionUnpublished(String collectionID) {
        super("franco.isan.FeaturedCollectionUnpublished");
        this.collectionID = collectionID;
    }

    public String getCollectionID() {
        return collectionID;
    }
}
