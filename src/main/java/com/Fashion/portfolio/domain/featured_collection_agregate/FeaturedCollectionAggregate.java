package com.Fashion.portfolio.domain.featured_collection_agregate;

import com.Fashion.portfolio.domain.common_project.DesignTeam;
import com.Fashion.portfolio.domain.common_project.Project;
import com.Fashion.portfolio.domain.common_project.ProjectContent;
import com.Fashion.portfolio.domain.common_project.events.*;
import com.Fashion.portfolio.domain.common_project.values.DescriptionContent;
import com.Fashion.portfolio.domain.common_project.values.DesignTeamID;
import com.Fashion.portfolio.domain.common_project.values.MediaContent;
import com.Fashion.portfolio.domain.common_project.values.ProjectContentID;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.*;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.FeaturedCollectionID;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.FeaturedPartner;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.PublishingInformation;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.List;

public class FeaturedCollectionAggregate extends Project<FeaturedCollectionID> {

    protected FeaturedPartner partner;
    protected PublishingInformation publishingInformation;

    public FeaturedCollectionAggregate(String projectDescription, String paragraph,
                                       String name, String role, String partnerDescription, String editor, String designTeamID, String projectContentID) {
        super(new FeaturedCollectionID());
        subscribe(new FeaturedCollectionChange(this));
        appendChange(new FeaturedCollectionCreated(projectDescription, paragraph, name, role, partnerDescription, editor, designTeamID, projectContentID)).apply();
    }

    private FeaturedCollectionAggregate(String ID) {
        super(FeaturedCollectionID.of(ID));
        subscribe(new FeaturedCollectionChange(this));
    }


    public static FeaturedCollectionAggregate from(String ID, List<DomainEvent> events) {
        FeaturedCollectionAggregate project = new FeaturedCollectionAggregate(ID);
        events.forEach(project::applyEvent);
        return project;
    }

    protected void firstProjectContent(String projectObjectiveDescription, String projectObjectiveParagraph) {
        firstContent(projectObjectiveDescription, projectObjectiveParagraph);
    }

    public void designerAdded(String name, String role, String description) {
        appendChange(new DesignerAdded(name, role, description)).apply();
    }

    public void designerRemoved(String name) {
        appendChange(new DesignerRemoved(name)).apply();
    }

    public void mediaContentAdded(String title, String description, String author, String URL){
        appendChange(new MediaContentAdded(title, description, author, URL)).apply();
    }

    public void descriptionContentAdded(String title, String description, String author, String paragraph){
        appendChange(new DescriptionContentAdded(title, description, author, paragraph)).apply();
    }

    public void descriptionContentPublished(String title){
        appendChange(new DescriptionContentPublished(title)).apply();
    }


    public void partnerApproved(){
        appendChange(new PartnerApproved()).apply();
    }

    public void partnerUnapproved(){
        appendChange(new ProjectUnpublished()).apply();
    }

    public void mediaContentPublished(String title) {
        appendChange(new MediaContentPublished(title)).apply();
    }

    public void projectPublished(){
        appendChange(new ProjectPublished()).apply();
    }

    public void designTeam(String designTeamID){
        this.designTeam = new DesignTeam(DesignTeamID.of(designTeamID));
    }

    public void projectContent(String designTeamID){
        this.projectContent = new ProjectContent(ProjectContentID.of(designTeamID));
    }

    public Boolean verifyApprovment(){
        return this.publishingInformation.value().partnerAproval();
    }

    public Boolean verifyPublished(){
        return this.publishingInformation.value().isPublished();
    }

    protected Boolean removeDesignerFromTeam(String name) {
        return removeDesigner(name);
    }

    protected void addDesignerToTeam(String name, String role, String description) {
        addDesigner(name, role, description);
    }

    protected void addMediaContent(String title, String description, String author, String URL) {
        addProjectMediaContent(title, description, author, URL);
    }

    protected void addDescriptionContent(String title, String description, String author, String paragraph) {
        addProjectDescriptionContent(title, description, author, paragraph);
    }

    protected void publishDescriptionContent(String title){
        publishDescription(title);
    }

    protected void publishMediaContent(String title){
        publishMedia(title);
    }

    public DescriptionContent findDescriptionContent (String title){
        return this.projectContent.findDescriptionContent(title);
    }

    public MediaContent findMediaContent (String title){
        return this.projectContent.findMediaContent(title);
    }

}
