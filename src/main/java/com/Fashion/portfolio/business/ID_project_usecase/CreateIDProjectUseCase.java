package com.Fashion.portfolio.business.ID_project_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.business.common.UseCaseCommand;
import com.Fashion.portfolio.domain.ID_project_agregate.IDProjectAggregate;
import com.Fashion.portfolio.domain.ID_project_agregate.commands.CreateIDProject;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;
import java.util.stream.Collectors;

public class CreateIDProjectUseCase implements UseCaseCommand<CreateIDProject> {

    private final EventRepository eventRepository;

    public CreateIDProjectUseCase(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<DomainEvent> apply(CreateIDProject command) {
        IDProjectAggregate project= new IDProjectAggregate(command.getProjectDescription(), command.getParagraph(), command.getDesignTeamID(), command.getProjectContentID());
        return project.getUncommittedChanges().stream().map(eventRepository::saveEvent).collect(Collectors.toList());
    }
}
