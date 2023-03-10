package com.Fashion.portfolio.domain.featured_collection_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class PartnerApproved extends DomainEvent {

    public PartnerApproved() {
        super("franco.isan.PartnerApproved");
    }
}
