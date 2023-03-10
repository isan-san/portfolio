package com.Fashion.portfolio.domain.portfolio_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class PortfolioVersionPublished extends DomainEvent {

    public PortfolioVersionPublished() {
        super("franco.isan.PortfolioVersionPublished");
    }

}
