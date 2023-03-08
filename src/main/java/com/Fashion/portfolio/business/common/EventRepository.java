package com.Fashion.portfolio.business.common;


import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;

public interface EventRepository {

    DomainEvent saveEvent(DomainEvent event);

    List<DomainEvent> findByAggregateRootId(String aggregateRootId);

    List<DomainEvent> listAll();

}
