package com.Fashion.portfolio.domain.common_project.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class DesignerAdded extends DomainEvent {

    private final String name;
    private final String role;
    private final String description;

    public DesignerAdded(String name, String role, String description) {
        super("franco.isan.DesignerAdded");
        this.name = name;
        this.role = role;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }
}
