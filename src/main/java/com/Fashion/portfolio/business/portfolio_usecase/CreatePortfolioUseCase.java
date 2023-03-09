package com.Fashion.portfolio.business.portfolio_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.business.common.UseCaseCommand;
import com.Fashion.portfolio.domain.own_collection_agregate.OwnCollectionAggregate;
import com.Fashion.portfolio.domain.own_collection_agregate.commands.CreateOwnCollection;
import com.Fashion.portfolio.domain.portfolio_agregate.PortfolioAggregate;
import com.Fashion.portfolio.domain.portfolio_agregate.commands.CreatePortfolio;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class CreatePortfolioUseCase implements UseCaseCommand<CreatePortfolio> {

    private final EventRepository eventRepository;

    public CreatePortfolioUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<DomainEvent> apply(CreatePortfolio command) {
        PortfolioAggregate portfolio= new PortfolioAggregate(command.getSeasonStartDate(), command.getSeasonEndDate());
        return portfolio.getUncommittedChanges().stream().map(eventRepository::saveEvent).collect(Collectors.toList());
    }
}
