package com.Fashion.portfolio.domain.featured_collection_agregate.values;

import com.Fashion.portfolio.generic.ValueObject;

public class FeaturedPartner implements ValueObject<FeaturedPartner.Props> {

    private final String name;
    private final String role;
    private final String description;

    public FeaturedPartner(String name, String role, String description) {
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

    public interface Props {
        String name();
        String role();
        String description();

    }
}
