package com.Fashion.portfolio.domain.portfolio_agregate;

import com.Fashion.portfolio.domain.common_project.values.ProjectContentID;
import com.Fashion.portfolio.domain.own_collection_agregate.events.OwnCollectionCreated;
import com.Fashion.portfolio.domain.portfolio_agregate.events.PortfolioCreated;
import com.Fashion.portfolio.domain.portfolio_agregate.values.PortfolioContentID;
import com.Fashion.portfolio.domain.portfolio_agregate.values.PortfolioVersionHandlerID;
import com.Fashion.portfolio.domain.portfolio_agregate.values.Season;
import com.Fashion.portfolio.domain.portfolio_agregate.values.SeasonProjectsID;
import com.Fashion.portfolio.generic.EventChange;

public class PortfolioChange extends EventChange {

    public PortfolioChange(PortfolioAggregate portfolio){
        apply((PortfolioCreated event) -> {
            portfolio.versions = new PortfolioVersionHandler(new PortfolioVersionHandlerID());
            portfolio.content = new PortfolioContent(new PortfolioContentID());
            portfolio.seasonProjects = new SeasonProjects(new SeasonProjectsID());
            portfolio.season = new Season(event.getSeasonStartDate(),event.getSeasonEndDate());
        });
    }

}
