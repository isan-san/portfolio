package com.Fashion.portfolio.domain.common_project;

import com.Fashion.portfolio.domain.common_project.values.DescriptionContent;
import com.Fashion.portfolio.domain.common_project.values.MediaContent;
import com.Fashion.portfolio.generic.AggregateRoot;
import com.Fashion.portfolio.generic.Identity;


public class Project<T extends Identity> extends AggregateRoot<T> {

    protected DesignTeam designTeam;
    protected ProjectContent projectContent;

    //public Project(T ID, String designTeamID, String projectContentID, String description, String paragraph) {
    //    super(ID);
    //    this.designTeam = new DesignTeam( DesignTeamID.of(designTeamID));
    //    this.projectContent = new ProjectContent( ProjectContentID.of(projectContentID));
    //   firstContent(description, paragraph);
    //}

    protected Project(T ID) {
        super(ID);
    }

    protected void firstContent(String description, String paragraph) {
        this.projectContent.addContent(new DescriptionContent(
                "Project objective",
                description,
                "Design team",
                paragraph,
                null));
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

    protected void addProjectMediaContent(String title, String description, String author, String URL) {
        this.projectContent.addContent(new MediaContent(title, description, author, URL));
    }

    protected void addProjectDescriptionContent(String title, String description, String author, String paragraph) {
        this.projectContent.addContent(new DescriptionContent(title, description, author, paragraph));
    }

    protected void publishDescription(String title){
        this.projectContent.publishDescription(title);
    }
    protected void publishMedia(String title){
        this.projectContent.publishMedia(title);
    }

    public Boolean verifyContent(String title) {
        return projectContent.descriptionContents().stream().noneMatch(designer -> designer.value().title().equals(title))||projectContent.mediaContents().stream().noneMatch(designer -> designer.value().title().equals(title));
    }




}
