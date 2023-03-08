package com.Fashion.portfolio.domain.common_project;

import com.Fashion.portfolio.domain.common_project.events.ProjectCreated;
import com.Fashion.portfolio.domain.common_project.values.DescriptionContent;
import com.Fashion.portfolio.domain.common_project.values.DesignTeamID;
import com.Fashion.portfolio.domain.common_project.values.ProjectContentID;
import com.Fashion.portfolio.domain.common_project.values.ProjectID;
import com.Fashion.portfolio.generic.AggregateRoot;
import com.Fashion.portfolio.generic.Identity;

public class  Project<T extends Identity> extends AggregateRoot<T> {

    protected DesignTeam designTeam;
    protected ProjectContent projectContent;

    public Project(T ID, String description, String paragraph) {
        super (ID);
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
}
