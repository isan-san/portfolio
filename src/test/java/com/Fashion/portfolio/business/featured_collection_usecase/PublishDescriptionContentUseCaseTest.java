package com.Fashion.portfolio.business.featured_collection_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.domain.common_project.commands.AddMediaContent;
import com.Fashion.portfolio.domain.common_project.commands.PublishDescriptionContent;
import com.Fashion.portfolio.domain.common_project.events.DescriptionContentPublished;
import com.Fashion.portfolio.domain.common_project.events.MediaContentAdded;
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
class PublishDescriptionContentUseCaseTest {

    @Mock
    private EventRepository repository;
    private PublishDescriptionContentUseCase publishDescriptionContentUseCase;

    @BeforeEach
    void setUp() {
        publishDescriptionContentUseCase = new PublishDescriptionContentUseCase(repository);
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
                    return ProjectEvents.withVariousMethods(rootID).stream().filter(
                                    event -> event.aggregateRootId().equals(InvocationOnMock.getArgument(0)))
                            .collect(Collectors.toList());
                });

        PublishDescriptionContent command = new PublishDescriptionContent("To publish", rootID);

        DescriptionContentPublished event = new DescriptionContentPublished("To publish");
        event.setAggregateRootId(rootID);

        publishDescriptionContentUseCase.apply(command);

    }


}