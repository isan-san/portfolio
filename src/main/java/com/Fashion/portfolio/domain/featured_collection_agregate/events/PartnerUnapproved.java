package com.Fashion.portfolio.domain.featured_collection_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class PartnerUnapproved extends DomainEvent {

    public PartnerUnapproved() {
        super("franco.isan.PartnerApproved");
    }
}
