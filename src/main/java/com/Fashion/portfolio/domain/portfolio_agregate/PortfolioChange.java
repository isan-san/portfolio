package com.Fashion.portfolio.domain.portfolio_agregate;

import com.Fashion.portfolio.domain.ID_project_agregate.values.IDProjectID;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.FeaturedCollectionID;
import com.Fashion.portfolio.domain.own_collection_agregate.values.OwnCollectionID;
import com.Fashion.portfolio.domain.portfolio_agregate.events.*;
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
        apply((FeaturedCollectionAdded event)->{
            portfolio.seasonProjects.addProject(FeaturedCollectionID.of(event.getCollectionID()));
        });
        apply((OwnCollectionAdded event)->{
            portfolio.seasonProjects.addProject(OwnCollectionID.of(event.getCollectionID()));
        });
        apply((IDProjectAdded event)->{
            portfolio.seasonProjects.addProject(IDProjectID.of(event.getProjectID()));
        });
        apply((PortfolioVersionPublished event)->{
            portfolio.releasePortfolioVersion();
            portfolio.content.flushContent();
        });
        apply((DescriptionContentAppended event)->{
            portfolio.appendDescriptionContent(event.getContent());
        });
        apply((MediaContentAppended event)->{
            portfolio.appendMediaContent(event.getContent());
        });
        apply((FeaturedCollectionRemoved event)->{
            portfolio.seasonProjects.removeProject(FeaturedCollectionID.of(event.getCollectionID()));
        });
    }

}
