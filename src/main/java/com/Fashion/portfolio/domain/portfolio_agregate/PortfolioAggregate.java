package com.Fashion.portfolio.domain.portfolio_agregate;

import com.Fashion.portfolio.domain.common_project.values.DescriptionContent;
import com.Fashion.portfolio.domain.common_project.values.MediaContent;
import com.Fashion.portfolio.domain.portfolio_agregate.events.*;
import com.Fashion.portfolio.domain.portfolio_agregate.values.PortfolioID;
import com.Fashion.portfolio.domain.portfolio_agregate.values.Season;
import com.Fashion.portfolio.generic.AggregateRoot;
import com.Fashion.portfolio.generic.DomainEvent;

import java.time.LocalDate;
import java.util.List;

public class PortfolioAggregate extends AggregateRoot<PortfolioID> {

    protected PortfolioVersionHandler versions;
    protected PortfolioContent content;
    protected SeasonProjects seasonProjects;
    protected Season season;


    public PortfolioAggregate(LocalDate seasonStartDate, LocalDate seasonEndDate) {
        super(new PortfolioID());
        subscribe(new PortfolioChange(this));
        appendChange(new PortfolioCreated(seasonStartDate, seasonEndDate)).apply();
    }

    private PortfolioAggregate(String ID) {
        super(PortfolioID.of(ID));
        subscribe(new PortfolioChange(this));
    }

    public static PortfolioAggregate from(String ID, List<DomainEvent> events) {
        PortfolioAggregate portfolio = new PortfolioAggregate(ID);
        events.forEach(portfolio::applyEvent);
        return portfolio;
    }

    public void publishPortfolioVersion(){
        appendChange(new PortfolioVersionPublished()).apply();
    }

    public void descriptionContentAppended(DescriptionContent content){
        appendChange(new DescriptionContentAppended(content)).apply();
    }

    public void mediaContentAppended(MediaContent content){
        appendChange(new MediaContentAppended(content)).apply();
    }


    public void addFeaturedCollection(String projectID) {
        appendChange(new FeaturedCollectionAdded(projectID)).apply();
    }

    public void discardSeasonProject(String projectID) {
        appendChange(new FeaturedCollectionRemoved(projectID)).apply();
    }
    public void releasePortfolioVersion() {
        this.versions.publishVersion(this.content.descriptionContents(), this.content.mediaContents());
    }

    public void addOwnCollection(String projectID) {
        appendChange(new OwnCollectionAdded(projectID));
    }

    public void addIDProject(String projectID) {
        appendChange(new IDProjectAdded(projectID));
    }

    protected void appendMediaContent(MediaContent newContent) {
        content.addContent(newContent);
    }

    protected void appendDescriptionContent(DescriptionContent newContent) {
        content.addContent(newContent);
    }

}
