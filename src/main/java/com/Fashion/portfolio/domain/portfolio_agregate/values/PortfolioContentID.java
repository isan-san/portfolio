package com.Fashion.portfolio.domain.portfolio_agregate.values;

import com.Fashion.portfolio.generic.Identity;

public class PortfolioContentID extends Identity {

    private PortfolioContentID(String ID) {
        super(ID);
    }

    public PortfolioContentID() {
    }

    public static PortfolioContentID of(String ID) {
        return new PortfolioContentID(ID);
    }

}
