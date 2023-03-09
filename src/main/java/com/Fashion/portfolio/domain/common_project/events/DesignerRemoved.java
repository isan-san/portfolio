package com.Fashion.portfolio.domain.common_project.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class DesignerRemoved extends DomainEvent {

    private final String designerName;

    public DesignerRemoved(String designerName) {
        super("franco.isan.DesignerRemoved");
        this.designerName = designerName;
    }

    public String getDesignerName() {
        return designerName;
    }
}
