package com.Fashion.portfolio.business.featured_collection_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.domain.common_project.values.DesignTeamID;
import com.Fashion.portfolio.domain.common_project.values.ProjectContentID;
import com.Fashion.portfolio.domain.featured_collection_agregate.FeaturedCollectionAggregate;
import com.Fashion.portfolio.domain.featured_collection_agregate.commands.CreateFeaturedCollection;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.FeaturedCollectionCreated;
import com.Fashion.portfolio.generic.DomainEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CreateFeaturedCollectionUseCaseTest {

    @Mock
    private EventRepository repository;
    private CreateFeaturedCollectionUseCase createFeaturedCollectionUseCase;

    @BeforeEach
    void setUp() {
        createFeaturedCollectionUseCase = new CreateFeaturedCollectionUseCase(repository);
    }

    @Test
    void successfulScenario() {

        String aggregateRootId;

        Mockito.when(repository.saveEvent(ArgumentMatchers.any(DomainEvent.class))).
                thenAnswer(InvocationOnMock -> {
                    return InvocationOnMock.getArgument(0);
                });


        CreateFeaturedCollection createProject = new CreateFeaturedCollection(
                "A test collection",
                "This collection will be used in the future tests",
                "Isan",
                "Designer",
                "A IDP with development knowledge",
                "Isan");

        FeaturedCollectionCreated projectCreated = new FeaturedCollectionCreated(
                "A test collection",
                "This collection will be used in the future tests",
                "Isan",
                "Designer",
                "A IDP with development knowledge",
                "Isan",
                new DesignTeamID().value(),
                new ProjectContentID().value());

        createFeaturedCollectionUseCase.apply(createProject);

    }

}