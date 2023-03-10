package com.Fashion.portfolio.business.featured_collection_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.business.common.UseCaseCommand;
import com.Fashion.portfolio.domain.common_project.commands.AddMediaContent;
import com.Fashion.portfolio.domain.common_project.commands.PublishDescriptionContent;
import com.Fashion.portfolio.domain.common_project.commands.PublishMediaContent;
import com.Fashion.portfolio.domain.featured_collection_agregate.FeaturedCollectionAggregate;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class PublishMediaContentUseCase implements UseCaseCommand<PublishMediaContent> {

    private final EventRepository eventRepository;

    public PublishMediaContentUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<DomainEvent> apply(PublishMediaContent command) {
        List<DomainEvent> events = eventRepository.findByAggregateRootId(command.getProjectID());
        FeaturedCollectionAggregate collection = FeaturedCollectionAggregate.from(command.getProjectID(), events);
        if (!collection.verifyContent(command.getContentTitle())) {
            collection.mediaContentPublished(command.getContentTitle());
            return collection.getUncommittedChanges().stream().map(eventRepository::saveEvent).collect(Collectors.toList());
        } else {
            return null;
        }
    }
}