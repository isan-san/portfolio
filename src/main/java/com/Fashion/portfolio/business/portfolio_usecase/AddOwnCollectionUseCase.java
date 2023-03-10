package com.Fashion.portfolio.business.portfolio_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.business.common.UseCaseCommand;
import com.Fashion.portfolio.domain.portfolio_agregate.PortfolioAggregate;
import com.Fashion.portfolio.domain.portfolio_agregate.commands.AddFeaturedCollection;
import com.Fashion.portfolio.domain.portfolio_agregate.commands.AddOwnCollection;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class AddOwnCollectionUseCase implements UseCaseCommand<AddOwnCollection> {

    private final EventRepository eventRepository;

    public AddOwnCollectionUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<DomainEvent> apply(AddOwnCollection command) {
        List<DomainEvent> events = eventRepository.findByAggregateRootId(command.getPortfolioID());
        PortfolioAggregate portfolio = PortfolioAggregate.from(command.getPortfolioID(), events);
        portfolio.addOwnCollection(command.getCollectionID());
        return portfolio.getUncommittedChanges().stream().map(eventRepository::saveEvent).collect(Collectors.toList());
    }

}