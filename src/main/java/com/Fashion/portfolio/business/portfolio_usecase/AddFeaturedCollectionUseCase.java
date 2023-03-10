package com.Fashion.portfolio.business.portfolio_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.business.common.UseCaseCommand;
import com.Fashion.portfolio.domain.common_project.commands.RemoveDesigner;
import com.Fashion.portfolio.domain.own_collection_agregate.OwnCollectionAggregate;
import com.Fashion.portfolio.domain.portfolio_agregate.PortfolioAggregate;
import com.Fashion.portfolio.domain.portfolio_agregate.commands.AddFeaturedCollection;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class AddFeaturedCollectionUseCase implements UseCaseCommand<AddFeaturedCollection> {

    private final EventRepository eventRepository;

    public AddFeaturedCollectionUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<DomainEvent> apply(AddFeaturedCollection command) {
        List<DomainEvent> events = eventRepository.findByAggregateRootId(command.getPortfolioID());
        PortfolioAggregate portfolio = PortfolioAggregate.from(command.getPortfolioID(), events);
        portfolio.addFeaturedCollection(command.getCollectionID());
        return portfolio.getUncommittedChanges().stream().map(eventRepository::saveEvent).collect(Collectors.toList());
    }

}
