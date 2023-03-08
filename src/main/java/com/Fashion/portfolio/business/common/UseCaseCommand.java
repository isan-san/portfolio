package com.Fashion.portfolio.business.common;


import com.Fashion.portfolio.generic.Command;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;

public interface UseCaseCommand <T extends Command>{

    List<DomainEvent> apply(T command);

}
