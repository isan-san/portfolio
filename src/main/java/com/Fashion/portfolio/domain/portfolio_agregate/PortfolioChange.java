package com.Fashion.portfolio.domain.portfolio_agregate;

import com.Fashion.portfolio.domain.own_collection_agregate.events.OwnCollectionCreated;
import com.Fashion.portfolio.generic.EventChange;

public class PortfolioChange extends EventChange {

    public PortfolioChange(PortfolioAggregate portfolio){
        apply((OwnCollectionCreated event) -> {
            portfolio;
        });
    }

}
