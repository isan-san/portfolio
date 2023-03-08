package com.Fashion.portfolio.domain.portfolio_agregate;

import com.Fashion.portfolio.domain.portfolio_agregate.events.PortfolioCreated;
import com.Fashion.portfolio.domain.portfolio_agregate.values.PortfolioID;
import com.Fashion.portfolio.domain.portfolio_agregate.values.PortfolioVersion;
import com.Fashion.portfolio.domain.portfolio_agregate.values.Season;
import com.Fashion.portfolio.generic.AggregateRoot;

import java.time.LocalDate;

public class PortfolioAggregate extends AggregateRoot<PortfolioID> {

    private PortfolioVersion version;
    private PortfolioContent content;
    private SeasonProjects seasonProjects;
    private Season season;


    public PortfolioAggregate(LocalDate seasonStartDate, LocalDate seasonEndDate) {
        super(new PortfolioID());
        subscribe(new PortfolioChange(this));
        appendChange(new PortfolioCreated());

    }
}
