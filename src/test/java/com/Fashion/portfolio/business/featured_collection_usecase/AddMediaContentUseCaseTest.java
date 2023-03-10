package com.Fashion.portfolio.business.featured_collection_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.domain.common_project.commands.AddMediaContent;
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
class AddMediaContentUseCaseTest {

    @Mock
    private EventRepository repository;
    private AddMediaContentUseCase addDescriptionContentUseCase;

    @BeforeEach
    void setUp() {
        addDescriptionContentUseCase = new AddMediaContentUseCase(repository);
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

        AddMediaContent command = new AddMediaContent("A brand new content", "Test to create new Content", "Isan Franco","Test URL", rootID);

        MediaContentAdded event = new MediaContentAdded("A brand new content", "Test to create new Content", "Isan Franco","Test URL");
        event.setAggregateRootId(rootID);

        addDescriptionContentUseCase.apply(command);

    }


}