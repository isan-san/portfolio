package com.Fashion.portfolio.business.portfolio_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.domain.portfolio_agregate.commands.AddFeaturedCollection;
import com.Fashion.portfolio.domain.portfolio_agregate.events.FeaturedCollectionAdded;
import com.Fashion.portfolio.domain.portfolio_agregate.events.FeaturedCollectionRemoved;
import com.Fashion.portfolio.domain.portfolio_agregate.events.FeaturedCollectionUnpublished;
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
class FeaturedCollectionUnpublishedEventUseCaseTest {

    @Mock
    private EventRepository repository;
    private FeaturedCollectionUnpublishedEventUseCase featuredCollectionUnpublishedEventUseCase;

    @BeforeEach
    void setUp() {
        featuredCollectionUnpublishedEventUseCase = new FeaturedCollectionUnpublishedEventUseCase(repository);
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

        FeaturedCollectionUnpublished trigerEvent = new FeaturedCollectionUnpublished("collectionID");
        trigerEvent.setAggregateRootId(rootID);

        FeaturedCollectionRemoved event = new FeaturedCollectionRemoved("collectionID");
        event.setAggregateRootId(rootID);

        featuredCollectionUnpublishedEventUseCase.apply(trigerEvent);
    }

}