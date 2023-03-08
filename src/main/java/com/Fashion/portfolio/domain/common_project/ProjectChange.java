package com.Fashion.portfolio.domain.common_project;

import com.Fashion.portfolio.domain.common_project.events.ProjectCreated;
import com.Fashion.portfolio.domain.common_project.values.DescriptionContent;
import com.Fashion.portfolio.domain.common_project.values.DesignTeamID;
import com.Fashion.portfolio.domain.common_project.values.ProjectContentID;
import com.Fashion.portfolio.generic.EventChange;

import java.util.ArrayList;

public class ProjectChange extends EventChange {

    public ProjectChange(Project project) {

        apply((ProjectCreated event) -> {
            project.projectContent = new ProjectContent(new ProjectContentID());
            project.projectContent.addContent(new DescriptionContent(
                    "Project objective",
                    event.getDescription(),
                    event.getParagraph(),
                    "Design Team",
                    true));
            project.designTeam = new DesignTeam(new DesignTeamID());
        });

    }

}
