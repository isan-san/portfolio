package com.Fashion.portfolio.test_utiles;

import com.Fashion.portfolio.domain.common_project.events.DescriptionContentAdded;
import com.Fashion.portfolio.domain.common_project.events.DescriptionContentPublished;
import com.Fashion.portfolio.domain.common_project.events.DesignerAdded;
import com.Fashion.portfolio.domain.common_project.events.MediaContentAdded;
import com.Fashion.portfolio.domain.common_project.values.DesignTeamID;
import com.Fashion.portfolio.domain.common_project.values.ProjectContentID;
import com.Fashion.portfolio.domain.featured_collection_agregate.commands.PublishProject;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.FeaturedCollectionCreated;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.PartnerApproved;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.ProjectPublished;
import com.Fashion.portfolio.domain.portfolio_agregate.events.FeaturedCollectionAdded;
import com.Fashion.portfolio.generic.DomainEvent;

import java.util.ArrayList;
import java.util.List;

public class ProjectEvents {

    public static List<DomainEvent> featuredCollectionCrated(String rootID) {
        DomainEvent created = new FeaturedCollectionCreated(
                "A test collection",
                "This collection will be used in the future tests",
                "Isan",
                "Designer",
                "A IDP with development knowledge",
                "Isan",
                new DesignTeamID().value(),
                new ProjectContentID().value());
        created.setAggregateRootId(rootID);
        return List.of(created);
    }

    public static List<DomainEvent> featuredCollectionApproved(String rootID) {
        DomainEvent created = new FeaturedCollectionCreated(
                "A test collection",
                "This collection will be used in the future tests",
                "Isan",
                "Designer",
                "A IDP with development knowledge",
                "Isan",
                new DesignTeamID().value(),
                new ProjectContentID().value());
        created.setAggregateRootId(rootID);
        DomainEvent approve = new PartnerApproved();
        approve.setAggregateRootId(rootID);
        return List.of(created, approve);
    }

    public static List<DomainEvent> featuredCollectionApprovedAndPublished(String rootID) {
        DomainEvent created = new FeaturedCollectionCreated(
                "A test collection",
                "This collection will be used in the future tests",
                "Isan",
                "Designer",
                "A IDP with development knowledge",
                "Isan",
                new DesignTeamID().value(),
                new ProjectContentID().value());
        created.setAggregateRootId(rootID);

        DomainEvent approve = new PartnerApproved();
        approve.setAggregateRootId(rootID);

        DomainEvent publish = new ProjectPublished();
        publish.setAggregateRootId(rootID);

        return List.of(created, approve, publish);
    }

    public static List<DomainEvent> withVariousMethods(String rootID) {
        List<DomainEvent> returningList = new ArrayList<>();
        DomainEvent created = new FeaturedCollectionCreated(
                "A test collection",
                "This collection will be used in the future tests",
                "Isan",
                "Designer",
                "A IDP with development knowledge",
                "Isan",
                "Design Team ID",
                "Project content ID");
        created.setAggregateRootId(rootID);
        returningList.add(created);

        DomainEvent designerAdded = new DesignerAdded("Lugel", "Test role", "My brother");
        designerAdded.setAggregateRootId(rootID);
        returningList.add(designerAdded);

        DomainEvent descriptionContentAdded = new DescriptionContentAdded("Second content", "Test to create new Content", "Isan Franco", "Test paragraph");
        descriptionContentAdded.setAggregateRootId(rootID);
        returningList.add(descriptionContentAdded);


        DomainEvent mediaContentAdded = new MediaContentAdded("Third content", "Test to create new Content", "Other Isan", "Test URL");
        mediaContentAdded.setAggregateRootId(rootID);
        returningList.add(mediaContentAdded);

        DomainEvent mediaContentAdded2 = new MediaContentAdded("Fourth content", "Test to create new Content", "Other Isan", "Test URL");
        mediaContentAdded2.setAggregateRootId(rootID);
        returningList.add(mediaContentAdded2);

        DomainEvent descriptionContentAdded2 = new DescriptionContentAdded("To publish", "Test to create new Content", "Isan Franco", "Test paragraph");
        descriptionContentAdded2.setAggregateRootId(rootID);
        returningList.add(descriptionContentAdded2);

        DomainEvent mediaContentAdded3 = new MediaContentAdded("To publish", "Test to create new Content", "Isan Franco", "Test URL");
        mediaContentAdded3.setAggregateRootId(rootID);
        returningList.add(mediaContentAdded3);

        DomainEvent publishContent = new DescriptionContentPublished("Second content");
        publishContent.setAggregateRootId(rootID);
        returningList.add(publishContent);

        return returningList;
    }
}
