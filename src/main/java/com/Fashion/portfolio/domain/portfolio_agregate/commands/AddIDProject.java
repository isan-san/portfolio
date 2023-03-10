package com.Fashion.portfolio.domain.portfolio_agregate.commands;

import com.Fashion.portfolio.generic.Command;

public class AddIDProject extends Command {

    private final String collectionID;
    private final String portfolioID;

    public AddIDProject(String collectionID, String portfolioID) {
        this.collectionID = collectionID;
        this.portfolioID = portfolioID;
    }

    public String getCollectionID() {
        return collectionID;
    }

    public String getPortfolioID() {
        return portfolioID;
    }
}
