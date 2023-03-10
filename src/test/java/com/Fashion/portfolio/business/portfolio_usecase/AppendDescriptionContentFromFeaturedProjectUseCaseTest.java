package com.Fashion.portfolio.business.portfolio_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.domain.portfolio_agregate.commands.AddFeaturedCollection;
import com.Fashion.portfolio.domain.portfolio_agregate.commands.AppendDescriptionContent;
import com.Fashion.portfolio.domain.portfolio_agregate.events.DescriptionContentAppended;
import com.Fashion.portfolio.domain.portfolio_agregate.events.FeaturedCollectionAdded;
import com.Fashion.portfolio.generic.DomainEvent;
import com.Fashion.portfolio.test_utiles.PortfolioEvents;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
class AppendDescriptionContentFromFeaturedProjectUseCaseTest {

    @Mock
    private EventRepository repository;
    private AppendDescriptionContentFromFeaturedProjectUseCase appendDescriptionContentFromFeaturedProjectUseCase;

    @BeforeEach
    void setUp() {
        appendDescriptionContentFromFeaturedProjectUseCase = new AppendDescriptionContentFromFeaturedProjectUseCase(repository);
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
                    return PortfolioEvents.withVariousMethods(rootID).stream().filter(
                                    event -> event.aggregateRootId().equals(InvocationOnMock.getArgument(0)))
                            .collect(Collectors.toList());
                });

        AppendDescriptionContent command = new AppendDescriptionContent("Title", "collectionID", rootID);

        //DescriptionContentAppended event = new DescriptionContentAppended("Title", "collectionID");
        //event.setAggregateRootId(rootID);

        appendDescriptionContentFromFeaturedProjectUseCase.apply(command);

    }

}