package com.Fashion.portfolio.domain.portfolio_agregate.commands;

import com.Fashion.portfolio.generic.Command;
import com.Fashion.portfolio.generic.DomainEvent;

import java.time.LocalDate;

public class CreatePortfolio extends Command {

    private final LocalDate seasonStartDate;
    private final LocalDate seasonEndDate;

    public CreatePortfolio(LocalDate seasonStartDate, LocalDate seasonEndDate) {
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
