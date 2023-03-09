package com.Fashion.portfolio.domain.common_project.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class DesignerAdded extends DomainEvent {

    private final String designerName;
    private final String designerRole;
    private final String designerDescription;

    public DesignerAdded(String name, String role, String description) {
        super("franco.isan.DesignerAdded");
        this.designerName = name;
        this.designerRole = role;
        this.designerDescription = description;
    }

    public String getDesignerName() {
        return designerName;
    }

    public String getDesignerRole() {
        return designerRole;
    }

    public String getDesignerDescription() {
        return designerDescription;
    }
}
