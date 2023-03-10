package com.Fashion.portfolio.business.portfolio_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.business.common.UseCaseEvent;
import com.Fashion.portfolio.domain.portfolio_agregate.PortfolioAggregate;
import com.Fashion.portfolio.domain.portfolio_agregate.commands.AddOwnCollection;
import com.Fashion.portfolio.domain.portfolio_agregate.events.FeaturedCollectionUnpublished;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class FeaturedCollectionUnpublishedEventUseCase implements UseCaseEvent<FeaturedCollectionUnpublished> {

    private final EventRepository eventRepository;

    public FeaturedCollectionUnpublishedEventUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<DomainEvent> apply(FeaturedCollectionUnpublished event) {
        List<DomainEvent> portfolioEvents = eventRepository.findByAggregateRootId(event.aggregateRootId());
        PortfolioAggregate portfolio = PortfolioAggregate.from(event.aggregateRootId(), portfolioEvents);
        portfolio.discardSeasonProject(event.getCollectionID());
        return portfolio.getUncommittedChanges().stream().map(eventRepository::saveEvent).collect(Collectors.toList());
    }

}
