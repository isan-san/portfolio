package com.Fashion.portfolio.business.ID_project_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.business.common.UseCaseCommand;
import com.Fashion.portfolio.domain.ID_project_agregate.IDProjectAggregate;
import com.Fashion.portfolio.domain.common_project.commands.PublishDescriptionContent;
import com.Fashion.portfolio.domain.featured_collection_agregate.FeaturedCollectionAggregate;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class PublishDescriptionContentUseCase implements UseCaseCommand<PublishDescriptionContent> {

    private final EventRepository eventRepository;

    public PublishDescriptionContentUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<DomainEvent> apply(PublishDescriptionContent command) {
        List<DomainEvent> events = eventRepository.findByAggregateRootId(command.getProjectID());
        IDProjectAggregate collection = IDProjectAggregate.from(command.getProjectID(), events);
        if (collection.verifyContent(command.getContentTitle())) {
            collection.descriptionContentPublished(command.getContentTitle());
            return collection.getUncommittedChanges().stream().map(eventRepository::saveEvent).collect(Collectors.toList());
        } else {
            return null;
        }
    }
}