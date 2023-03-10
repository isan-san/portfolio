package com.Fashion.portfolio.business.featured_collection_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.business.common.UseCaseCommand;
import com.Fashion.portfolio.business.common.UseCaseEvent;
import com.Fashion.portfolio.domain.featured_collection_agregate.FeaturedCollectionAggregate;
import com.Fashion.portfolio.domain.featured_collection_agregate.commands.PartnerApprovement;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.PartnerUnapproved;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class PartnerUnapprovedEventUseCase implements UseCaseEvent<PartnerUnapproved> {

    private final EventRepository eventRepository;

    public PartnerUnapprovedEventUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<DomainEvent> apply(PartnerUnapproved command) {
        List<DomainEvent> events = eventRepository.findByAggregateRootId(command.aggregateRootId());
        FeaturedCollectionAggregate collection = FeaturedCollectionAggregate.from(command.aggregateRootId(), events);
        collection.partnerUnapproved();
        return collection.getUncommittedChanges().stream().map(eventRepository::saveEvent).collect(Collectors.toList());
    }
}