package com.Fashion.portfolio.business.common;


import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;

public interface UseCaseEvent<T extends DomainEvent>{

    List<DomainEvent> apply(T event);

}
