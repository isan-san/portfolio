package com.Fashion.portfolio.business.portfolio_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.business.featured_collection_usecase.PublishProjectUseCase;
import com.Fashion.portfolio.domain.featured_collection_agregate.commands.PublishProject;
import com.Fashion.portfolio.domain.own_collection_agregate.events.ProjectPublished;
import com.Fashion.portfolio.domain.portfolio_agregate.commands.CreatePortfolio;
import com.Fashion.portfolio.domain.portfolio_agregate.events.PortfolioCreated;
import com.Fashion.portfolio.generic.DomainEvent;
import com.Fashion.portfolio.test_utiles.ProjectEvents;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
class CreatePortfolioUseCaseTest {

    @Mock
    private EventRepository repository;
    private CreatePortfolioUseCase createPortfolioUseCase;

    @BeforeEach
    void setUp() {
        createPortfolioUseCase = new CreatePortfolioUseCase(repository);
    }

    @Test
    void successfulScenario() {

        String rootID = "rootID";

        Mockito.when(repository.saveEvent(ArgumentMatchers.any(DomainEvent.class))).
                thenAnswer(InvocationOnMock -> {
                    return InvocationOnMock.getArgument(0);
                });

        //Mockito.when(repository.findByAggregateRootId(ArgumentMatchers.any()))
        //        .thenAnswer(InvocationOnMock -> {
        //            return ProjectEvents.featuredCollectionApproved(rootID).stream().filter(
        //                            event -> event.aggregateRootId().equals(InvocationOnMock.getArgument(0)))
        //                    .collect(Collectors.toList());
        //        });

        CreatePortfolio command = new CreatePortfolio(LocalDate.of(2023,1,1), LocalDate.of(2023,6,1));

        PortfolioCreated event = new PortfolioCreated(LocalDate.of(2023,1,1), LocalDate.of(2023,6,1));
        event.setAggregateRootId(rootID);

        createPortfolioUseCase.apply(command);

    }

}