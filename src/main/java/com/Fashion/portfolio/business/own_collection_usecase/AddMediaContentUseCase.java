package com.Fashion.portfolio.business.own_collection_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.business.common.UseCaseCommand;
import com.Fashion.portfolio.domain.common_project.commands.AddMediaContent;
import com.Fashion.portfolio.domain.own_collection_agregate.OwnCollectionAggregate;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class AddMediaContentUseCase implements UseCaseCommand<AddMediaContent> {

    private final EventRepository eventRepository;

    public AddMediaContentUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<DomainEvent> apply(AddMediaContent command) {
        List<DomainEvent> events = eventRepository.findByAggregateRootId(command.getProjectID());
        OwnCollectionAggregate collection = OwnCollectionAggregate.from(command.getProjectID(), events);
        if (collection.verifyContent(command.getTitle())) {
            collection.mediaContentAdded(command.getTitle(), command.getAuthor(), command.getDescription(), command.getURL());
            return collection.getUncommittedChanges().stream().map(eventRepository::saveEvent).collect(Collectors.toList());
        } else {
            return null;
        }
    }
}