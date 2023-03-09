package com.Fashion.portfolio.domain.common_project;

import com.Fashion.portfolio.domain.common_project.values.Content;
import com.Fashion.portfolio.domain.common_project.values.DescriptionContent;
import com.Fashion.portfolio.domain.common_project.values.MediaContent;
import com.Fashion.portfolio.domain.common_project.values.ProjectContentID;
import com.Fashion.portfolio.generic.Entity;

import java.util.ArrayList;

public class ProjectContent extends Entity<ProjectContentID> {

    private ArrayList<DescriptionContent> descriptionContents;

    private ArrayList<MediaContent> mediaContents;

    protected ProjectContent(ProjectContentID id) {
        super(id);
    }

    protected ArrayList<DescriptionContent> descriptionContents() {
        return descriptionContents;
    }

    protected ArrayList<MediaContent> mediaContents() {
        return mediaContents;
    }

    protected DescriptionContent addContent(DescriptionContent content){
        if (descriptionContents.stream().noneMatch(contents -> contents.value().title().equals((content).value().title()))) {
            descriptionContents.add(content);
            return content;
        } else {
            return null;
        }
    }
    protected MediaContent addContent(MediaContent content){
        if (mediaContents.stream().noneMatch(contents -> contents.value().title().equals((content).value().title()))) {
            mediaContents.add(content);
            return content;
        } else {
            return null;
        }
    }


}
