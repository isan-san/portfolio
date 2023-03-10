package com.Fashion.portfolio.business.ID_project_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.business.common.UseCaseCommand;
import com.Fashion.portfolio.domain.ID_project_agregate.IDProjectAggregate;
import com.Fashion.portfolio.domain.common_project.commands.RemoveDesigner;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class RemoveDesignerUseCase implements UseCaseCommand<RemoveDesigner> {

    private final EventRepository eventRepository;

    public RemoveDesignerUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<DomainEvent> apply(RemoveDesigner command) {
        List<DomainEvent> events = eventRepository.findByAggregateRootId(command.getProjectID());
        IDProjectAggregate collection = IDProjectAggregate.from(command.getProjectID(), events);
        if (!collection.verifyDesigner(command.getDesignerName())) {
            collection.designerRemoved(command.getDesignerName());
            return collection.getUncommittedChanges().stream().map(eventRepository::saveEvent).collect(Collectors.toList());
        } else {
            return null;
        }
    }
}