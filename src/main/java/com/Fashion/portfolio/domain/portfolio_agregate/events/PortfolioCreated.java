package com.Fashion.portfolio.domain.portfolio_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

import java.time.LocalDate;

public class PortfolioCreated extends DomainEvent {

    private final LocalDate seasonStartDate;
    private final LocalDate seasonEndDate;

    public PortfolioCreated(LocalDate seasonStartDate, LocalDate seasonEndDate) {
        super("franco.isan.PortfolioCreated");
        this.seasonStartDate = seasonStartDate;
        this.seasonEndDate = seasonEndDate;
    }

    public LocalDate getSeasonStartDate() {
        return seasonStartDate;
    }

    public LocalDate getSeasonEndDate() {
        return seasonEndDate;
    }
}
