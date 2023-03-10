package com.Fashion.portfolio.business.portfolio_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.business.common.UseCaseCommand;
import com.Fashion.portfolio.domain.featured_collection_agregate.FeaturedCollectionAggregate;
import com.Fashion.portfolio.domain.portfolio_agregate.PortfolioAggregate;
import com.Fashion.portfolio.domain.portfolio_agregate.commands.AddOwnCollection;
import com.Fashion.portfolio.domain.portfolio_agregate.commands.AppendDescriptionContent;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class AppendDescriptionContentFromFeaturedProjectUseCase implements UseCaseCommand<AppendDescriptionContent> {

    private final EventRepository eventRepository;

    public AppendDescriptionContentFromFeaturedProjectUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<DomainEvent> apply(AppendDescriptionContent command) {
        List<DomainEvent> portfolioEvents = eventRepository.findByAggregateRootId(command.getPortfolioID());
        List<DomainEvent> projectEvents = eventRepository.findByAggregateRootId(command.getProjectID());
        PortfolioAggregate portfolio = PortfolioAggregate.from(command.getPortfolioID(), portfolioEvents);
        FeaturedCollectionAggregate project = FeaturedCollectionAggregate.from(command.getProjectID(), projectEvents);
        portfolio.descriptionContentAppended(project.findDescriptionContent(command.getTitle()));
        return portfolio.getUncommittedChanges().stream().map(eventRepository::saveEvent).collect(Collectors.toList());
    }

}