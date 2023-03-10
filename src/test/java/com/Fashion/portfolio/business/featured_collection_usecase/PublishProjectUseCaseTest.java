package com.Fashion.portfolio.business.featured_collection_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.domain.featured_collection_agregate.commands.PartnerApprovement;
import com.Fashion.portfolio.domain.featured_collection_agregate.commands.PublishProject;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.PartnerApproved;
import com.Fashion.portfolio.domain.own_collection_agregate.events.ProjectPublished;
import com.Fashion.portfolio.generic.DomainEvent;
import com.Fashion.portfolio.test_utiles.ProjectEvents;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
class PublishProjectUseCaseTest {

    @Mock
    private EventRepository repository;
    private PublishProjectUseCase publishProjectUseCase;

    @BeforeEach
    void setUp() {
        publishProjectUseCase = new PublishProjectUseCase(repository);
    }

    @Test
    void successfulScenario() {

        String rootID = "rootID";

        Mockito.when(repository.saveEvent(ArgumentMatchers.any(DomainEvent.class))).
                thenAnswer(InvocationOnMock -> {
                    return InvocationOnMock.getArgument(0);
                });

        Mockito.when(repository.findByAggregateRootId(ArgumentMatchers.any()))
                .thenAnswer(InvocationOnMock -> {
                    return ProjectEvents.featuredCollectionApproved(rootID).stream().filter(
                                    event -> event.aggregateRootId().equals(InvocationOnMock.getArgument(0)))
                            .collect(Collectors.toList());
                });

        PublishProject command = new PublishProject(rootID);

        ProjectPublished event = new ProjectPublished();
        event.setAggregateRootId(rootID);

        publishProjectUseCase.apply(command);

    }


}