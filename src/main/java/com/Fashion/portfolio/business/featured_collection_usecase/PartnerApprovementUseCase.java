package com.Fashion.portfolio.business.featured_collection_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.business.common.UseCaseCommand;
import com.Fashion.portfolio.domain.common_project.commands.AddDesigner;
import com.Fashion.portfolio.domain.featured_collection_agregate.FeaturedCollectionAggregate;
import com.Fashion.portfolio.domain.featured_collection_agregate.commands.PartnerApprovement;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class PartnerApprovementUseCase implements UseCaseCommand<PartnerApprovement> {

    private final EventRepository eventRepository;

    public PartnerApprovementUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<DomainEvent> apply(PartnerApprovement command) {
        List<DomainEvent> events = eventRepository.findByAggregateRootId(command.getProjectID());
        FeaturedCollectionAggregate collection = FeaturedCollectionAggregate.from(command.getProjectID(), events);
        if (collection.verifyApprovment()) {
            collection.partnerApproved();
            return collection.getUncommittedChanges().stream().map(eventRepository::saveEvent).collect(Collectors.toList());
        } else {
            return null;
        }
    }
}