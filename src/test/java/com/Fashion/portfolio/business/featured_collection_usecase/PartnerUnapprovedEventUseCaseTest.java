package com.Fashion.portfolio.business.featured_collection_usecase;

import com.Fashion.portfolio.business.common.EventRepository;
import com.Fashion.portfolio.domain.featured_collection_agregate.commands.PartnerApprovement;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.PartnerApproved;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.PartnerUnapproved;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.ProjectUnpublished;
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
class PartnerUnapprovedEventUseCaseTest {

    @Mock
    private EventRepository repository;
    private PartnerUnapprovedEventUseCase partnerUnapprovedEventUseCase;

    @BeforeEach
    void setUp() {
        partnerUnapprovedEventUseCase = new PartnerUnapprovedEventUseCase(repository);
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
                    return ProjectEvents.featuredCollectionApprovedAndPublished(rootID).stream().filter(
                                    event -> event.aggregateRootId().equals(InvocationOnMock.getArgument(0)))
                            .collect(Collectors.toList());
                });

        PartnerUnapproved triggerEvent = new PartnerUnapproved();
        triggerEvent.setAggregateRootId(rootID);

        ProjectUnpublished event = new ProjectUnpublished();
        event.setAggregateRootId(rootID);

        partnerUnapprovedEventUseCase.apply(triggerEvent);

    }


}