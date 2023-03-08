package com.Fashion.portfolio.domain.portfolio_agregate.values;

import com.Fashion.portfolio.domain.common_project.values.ProjectContentID;
import com.Fashion.portfolio.generic.Identity;

public class PortfolioID extends Identity {

    private PortfolioID(String ID) {
        super(ID);
    }

    public PortfolioID() {
    }

    public static PortfolioID of(String ID) {
        return new PortfolioID(ID);
    }

}
