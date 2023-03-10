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

    public ProjectContent(ProjectContentID id) {
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

    protected DescriptionContent publishDescription(String title){
        return descriptionContents.stream().filter(content -> content.value().title().equals(title)).findAny().map(content->{
            DescriptionContent newContent = content.publish();
            descriptionContents.remove(content);
            descriptionContents.add(newContent);
            return newContent;
        }).orElse(null);
    }
    protected MediaContent publishMedia(String title){
        return mediaContents.stream().filter(content -> content.value().title().equals(title)).findAny().map(content->{
            MediaContent newContent = content.publish();
            mediaContents.remove(content);
            mediaContents.add(newContent);
            return newContent;
        }).orElse(null);
    }

    public DescriptionContent findDescriptionContent(String title){
        return this.descriptionContents.stream().filter(content->content.value().title().equals(title)).findFirst().orElse(null);
    }
    public MediaContent findMediaContent(String title){
        return this.mediaContents.stream().filter(content->content.value().title().equals(title)).findFirst().orElse(null);
    }

}
