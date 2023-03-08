package com.Fashion.portfolio.domain.portfolio_agregate.values;

import com.Fashion.portfolio.generic.Identity;

public class PortfolioVersionHandlerID extends Identity {

    private PortfolioVersionHandlerID(String ID) {
        super(ID);
    }

    public PortfolioVersionHandlerID() {
    }

    public static PortfolioVersionHandlerID of(String ID) {
        return new PortfolioVersionHandlerID(ID);
    }

}
