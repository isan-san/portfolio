package com.Fashion.portfolio.domain.featured_collection_agregate.events;

import com.Fashion.portfolio.generic.DomainEvent;

public class FeaturedCollectionCreated extends DomainEvent {

    private String projectDescription;
    private String paragraph;
    private String name;
    private String role;
    private String partnerDescription;

    public FeaturedCollectionCreated(String projectDescription, String paragraph, String name, String role, String partnerDescription) {
        super("franco.isan.FeaturedProjectCreated");
        this.projectDescription = projectDescription;
        this.paragraph = paragraph;
        this.name = name;
        this.role = role;
        this.partnerDescription = partnerDescription;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPartnerDescription() {
        return partnerDescription;
    }

    public void setPartnerDescription(String partnerDescription) {
        this.partnerDescription = partnerDescription;
    }

}
