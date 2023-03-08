package com.Fashion.portfolio.domain.own_collection_agregate.values;

import com.Fashion.portfolio.domain.portfolio_agregate.values.PortfolioID;
import com.Fashion.portfolio.generic.Identity;

public class OwnCollectionID extends Identity {

    private OwnCollectionID(String ID) {
        super(ID);
    }

    public OwnCollectionID() {
    }

    public static OwnCollectionID of(String ID) {
        return new OwnCollectionID(ID);
    }

}
