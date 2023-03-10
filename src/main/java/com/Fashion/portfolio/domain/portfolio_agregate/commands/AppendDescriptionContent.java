package com.Fashion.portfolio.domain.portfolio_agregate.commands;

import com.Fashion.portfolio.generic.Command;

public class AppendDescriptionContent extends Command {

    private final String title;
    private final String projectID;
    private final String portfolioID;


    public AppendDescriptionContent(String title, String projectID, String portfolioID) {
        this.title = title;
        this.projectID = projectID;
        this.portfolioID = portfolioID;
    }

    public String getTitle() {
        return title;
    }

    public String getProjectID() {
        return projectID;
    }

    public String getPortfolioID() {
        return portfolioID;
    }
}
