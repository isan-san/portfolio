package com.Fashion.portfolio.business.ID_project_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.business.common.UseCaseCommand;
import com.Fashion.portfolio.domain.ID_project_agregate.IDProjectAggregate;
import com.Fashion.portfolio.domain.ID_project_agregate.commands.ChangeProjectState;
import com.Fashion.portfolio.domain.ID_project_agregate.commands.FinishProject;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class FinishProjectUseCase implements UseCaseCommand<FinishProject> {

    private final EventRepository eventRepository;

    public FinishProjectUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<DomainEvent> apply(FinishProject command) {
        List<DomainEvent> events = eventRepository.findByAggregateRootId(command.getProjectID());
        IDProjectAggregate collection = IDProjectAggregate.from(command.getProjectID(), events);
        if (collection.verifyProjectFinished()) {
            collection.projectFinished();
            return collection.getUncommittedChanges().stream().map(eventRepository::saveEvent).collect(Collectors.toList());
        } else {
            return null;
        }
    }
}