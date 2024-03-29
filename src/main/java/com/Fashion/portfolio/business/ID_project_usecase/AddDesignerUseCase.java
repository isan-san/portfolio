package com.Fashion.portfolio.business.ID_project_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.business.common.UseCaseCommand;
import com.Fashion.portfolio.domain.ID_project_agregate.IDProjectAggregate;
import com.Fashion.portfolio.domain.common_project.commands.AddDesigner;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class AddDesignerUseCase implements UseCaseCommand<AddDesigner> {

    private final EventRepository eventRepository;

    public AddDesignerUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<DomainEvent> apply(AddDesigner command) {
        List<DomainEvent> events = eventRepository.findByAggregateRootId(command.getProjectID());
        IDProjectAggregate project = IDProjectAggregate.from(command.getProjectID(), events);
        if (project.verifyDesigner(command.getName())) {
            project.designerAdded(command.getName(), command.getRole(), command.getDescription());
            return project.getUncommittedChanges().stream().map(eventRepository::saveEvent).collect(Collectors.toList());
        } else {
            return null;
        }
    }
}