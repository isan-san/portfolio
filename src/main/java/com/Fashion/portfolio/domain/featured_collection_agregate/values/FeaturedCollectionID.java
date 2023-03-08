package com.Fashion.portfolio.domain.featured_collection_agregate.values;

import com.Fashion.portfolio.domain.portfolio_agregate.values.PortfolioID;
import com.Fashion.portfolio.generic.Identity;

public class FeaturedCollectionID extends Identity {

    private FeaturedCollectionID(String ID) {
        super(ID);
    }

    public FeaturedCollectionID() {
    }

    public static FeaturedCollectionID of(String ID) {
        return new FeaturedCollectionID(ID);
    }

}
