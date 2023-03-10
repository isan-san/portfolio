package com.Fashion.portfolio.domain.portfolio_agregate.commands;

import com.Fashion.portfolio.generic.Command;

public class PublishPortfolioVersion extends Command {

        private final String portfolioID;

    public PublishPortfolioVersion(String portfolioID) {
        this.portfolioID = portfolioID;
    }

    public String getPortfolioID() {
        return portfolioID;
    }
}
