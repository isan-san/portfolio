package com.Fashion.portfolio.domain.portfolio_agregate.commands;

public class AddFeaturedCollection {
    private final String collectionID;
    private final String portfolioID;

    public AddFeaturedCollection(String collectionID, String portfolioID) {
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
