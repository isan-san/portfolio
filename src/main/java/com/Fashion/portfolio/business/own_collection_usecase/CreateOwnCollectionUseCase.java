package com.Fashion.portfolio.business.own_collection_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.business.common.UseCaseCommand;
import com.Fashion.portfolio.domain.own_collection_agregate.OwnCollectionAggregate;
import com.Fashion.portfolio.domain.own_collection_agregate.commands.CreateOwnCollection;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class CreateOwnCollectionUseCase implements UseCaseCommand<CreateOwnCollection> {

    private final EventRepository eventRepository;

    public CreateOwnCollectionUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateOwnCollection command) {
        OwnCollectionAggregate collection= new OwnCollectionAggregate(command.getProjectDescription(), command.getParagraph(), command.getEditor(), command.getDesignTeamID(), command.getProjectContentID());
        return collection.getUncommittedChanges().stream().map(eventRepository::saveEvent).collect(Collectors.toList());
    }
}
