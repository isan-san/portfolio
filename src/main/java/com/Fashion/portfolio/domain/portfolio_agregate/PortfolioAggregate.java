package com.Fashion.portfolio.domain.portfolio_agregate;

import com.Fashion.portfolio.domain.common_project.events.DescriptionContentAdded;
import com.Fashion.portfolio.domain.common_project.events.MediaContentAdded;
import com.Fashion.portfolio.domain.common_project.values.DescriptionContent;
import com.Fashion.portfolio.domain.common_project.values.MediaContent;
import com.Fashion.portfolio.domain.portfolio_agregate.events.FeaturedCollectionAdded;
import com.Fashion.portfolio.domain.portfolio_agregate.events.IDProjectAdded;
import com.Fashion.portfolio.domain.portfolio_agregate.events.OwnCollectionAdded;
import com.Fashion.portfolio.domain.portfolio_agregate.events.PortfolioCreated;
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
        appendChange(new PortfolioCreated(seasonStartDate, seasonEndDate));
    }

    private PortfolioAggregate(String ID) {
        super(PortfolioID.of(ID));
    }

    public static PortfolioAggregate from(String ID, List<DomainEvent> events) {
        PortfolioAggregate portfolio = new PortfolioAggregate(ID);
        events.forEach(portfolio::applyEvent);
        return portfolio;
    }

    public void mediaContentAdded(String title, String description, String author, String URL) {
        appendChange(new MediaContentAdded(title, description, author, URL));
    }

    public void descriptionContentAdded(String title, String description, String author, String paragraph) {
        appendChange(new DescriptionContentAdded(title, description, author, paragraph));
    }

    public void addFeaturedCollection(String projectID) {
        appendChange(new FeaturedCollectionAdded(projectID));
    }

    public void addOwnCollection(String projectID) {
        appendChange(new OwnCollectionAdded(projectID));
    }

    public void addIDProject(String projectID) {
        appendChange(new IDProjectAdded(projectID));
    }

    protected void addMediaContent(String title, String description, String author, String URL) {
        content.addContent(new MediaContent(title, description, author, URL));
    }

    protected void addDescriptionContent(String title, String description, String author, String paragraph) {
        content.addContent(new DescriptionContent(title, description, author, paragraph));
    }

}
