package com.Fashion.portfolio.domain.portfolio_agregate;

import com.Fashion.portfolio.domain.common_project.values.DescriptionContent;
import com.Fashion.portfolio.domain.common_project.values.MediaContent;
import com.Fashion.portfolio.domain.common_project.values.ProjectContentID;
import com.Fashion.portfolio.domain.portfolio_agregate.values.PortfolioContentID;
import com.Fashion.portfolio.domain.portfolio_agregate.values.PortfolioID;
import com.Fashion.portfolio.generic.Entity;
import com.Fashion.portfolio.generic.Identity;

import java.util.ArrayList;
import java.util.Optional;

public class PortfolioContent extends Entity<PortfolioContentID> {

    private ArrayList<DescriptionContent> descriptionContents;
    private ArrayList<MediaContent> mediaContents;


    public PortfolioContent(PortfolioContentID ID) {
        super(ID);
    }

    public void flushContent(){
        this.descriptionContents = new ArrayList<DescriptionContent>();
        this.mediaContents = new ArrayList<MediaContent>();
    }

    public ArrayList<DescriptionContent> descriptionContents() {
        return this.descriptionContents;
    }

    public ArrayList<MediaContent> mediaContents() {
        return this.mediaContents;
    }

    protected DescriptionContent addContent(DescriptionContent content) {
        if (descriptionContents.stream().noneMatch(contents -> contents.value().title().equals((content).value().title()))) {
            descriptionContents.add(content);
            return content;
        } else {
            return null;
        }
    }

    protected MediaContent addContent(MediaContent content) {
        if (mediaContents.stream().noneMatch(contents -> contents.value().title().equals((content).value().title()))) {
            mediaContents.add(content);
            return content;
        } else {
            return null;
        }
    }

    protected DescriptionContent findDescription(String title) {
        Optional<DescriptionContent> newContent = this.descriptionContents.stream().filter(contents -> contents.value().title().equals(title)).findFirst();
        return newContent.flatMap(content -> newContent).orElse(null);
    }

    protected MediaContent findMedia(String title) {
        Optional<MediaContent> newContent = this.mediaContents.stream().filter(contents -> contents.value().title().equals(title)).findFirst();
        return newContent.flatMap(content -> newContent).orElse(null);
    }
}
