package com.Fashion.portfolio.domain.common_project;

import com.Fashion.portfolio.domain.common_project.values.DescriptionContent;
import com.Fashion.portfolio.domain.common_project.values.DesignTeamID;
import com.Fashion.portfolio.domain.common_project.values.ProjectContentID;
import com.Fashion.portfolio.generic.AggregateRoot;
import com.Fashion.portfolio.generic.Identity;


public class Project<T extends Identity> extends AggregateRoot<T> {

    protected DesignTeam designTeam;
    protected ProjectContent projectContent;

    public Project(T ID, String description, String paragraph) {
        super(ID);
    }

    protected Project(T ID) {
        super(ID);
        this.designTeam = new DesignTeam(new DesignTeamID());
        this.projectContent = new ProjectContent(new ProjectContentID());
    }

    protected void firstContent(String description, String paragraph) {
        this.projectContent.addContent(new DescriptionContent(
                "Project objective",
                description,
                paragraph,
                "Design Team",
                true));
    }

    protected void addDesigner(String name, String role, String description) {
        this.designTeam.addDesigner(name, role, description);
    }

    protected Boolean removeDesigner(String name) {
        return this.designTeam.removeDesigner(name);
    }

    public Boolean verifyDesigner(String name) {
        return designTeam.designers().stream().noneMatch(designer -> designer.value().name().equals(name));
    }

}
