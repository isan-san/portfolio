package com.Fashion.portfolio.domain.common_project.values;

import com.Fashion.portfolio.generic.ValueObject;

public class Designer implements ValueObject<Designer.Props> {

    private final String name;
    private final String role;
    private final String description;

    public Designer(String name, String role, String description) {
        this.name = name;
        this.role = role;
        this.description = description;
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String name() {
                return name;
            }

            @Override
            public String role() {
                return role;
            }

            @Override
            public String description() {
                return description;
            }
        };
    }

    public Designer updateDescription(String description) {
        return new Designer(this.name, this.role, description);
    }

    public Designer updaterRole(String role) {
        return new Designer(this.name, role, this.description);
    }

    public interface Props {
        String name();
        String role();
        String description();
    }
}
