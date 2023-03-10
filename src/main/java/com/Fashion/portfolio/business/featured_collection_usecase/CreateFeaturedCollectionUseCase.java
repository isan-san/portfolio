package com.Fashion.portfolio.business.featured_collection_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.business.common.UseCaseCommand;
import com.Fashion.portfolio.domain.featured_collection_agregate.FeaturedCollectionAggregate;
import com.Fashion.portfolio.domain.featured_collection_agregate.commands.CreateFeaturedCollection;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class CreateFeaturedCollectionUseCase implements UseCaseCommand<CreateFeaturedCollection> {

    private final EventRepository eventRepository;

    public CreateFeaturedCollectionUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateFeaturedCollection command) {
        FeaturedCollectionAggregate collection= new FeaturedCollectionAggregate(command.getProjectDescription(), command.getParagraph(), command.getName(), command.getRole(), command.getPartnerDescription(), command.getEditor(), command.getDesignTeamID(), command.getProjectContentID());
        return collection.getUncommittedChanges().stream().map(eventRepository::saveEvent).collect(Collectors.toList());
    }
}
