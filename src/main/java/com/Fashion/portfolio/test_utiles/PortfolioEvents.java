package com.Fashion.portfolio.test_utiles;

import com.Fashion.portfolio.domain.common_project.events.DescriptionContentAdded;
import com.Fashion.portfolio.domain.common_project.events.DescriptionContentPublished;
import com.Fashion.portfolio.domain.common_project.events.DesignerAdded;
import com.Fashion.portfolio.domain.common_project.events.MediaContentAdded;
import com.Fashion.portfolio.domain.featured_collection_agregate.events.FeaturedCollectionCreated;
import com.Fashion.portfolio.domain.portfolio_agregate.events.FeaturedCollectionAdded;
import com.Fashion.portfolio.domain.portfolio_agregate.events.PortfolioCreated;
import com.Fashion.portfolio.generic.DomainEvent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PortfolioEvents {

    public static List<DomainEvent> createPortfolio(String rootID){
        PortfolioCreated event = new PortfolioCreated(LocalDate.of(2023,1,1), LocalDate.of(2023,6,1));
        event.setAggregateRootId(rootID);
        return List.of(event);
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
        created.setAggregateRootId("collectionID");
        returningList.add(created);

        DomainEvent designerAdded = new DesignerAdded("Lugel", "Test role", "My brother");
        designerAdded.setAggregateRootId("collectionID");
        returningList.add(designerAdded);

        DomainEvent descriptionContentAdded = new DescriptionContentAdded("Title", "Test to create new Content", "Isan Franco", "Test paragraph");
        descriptionContentAdded.setAggregateRootId("collectionID");
        returningList.add(descriptionContentAdded);


        DomainEvent mediaContentAdded = new MediaContentAdded("Third content", "Test to create new Content", "Other Isan", "Test URL");
        mediaContentAdded.setAggregateRootId("collectionID");
        returningList.add(mediaContentAdded);

        DomainEvent mediaContentAdded2 = new MediaContentAdded("Fourth content", "Test to create new Content", "Other Isan", "Test URL");
        mediaContentAdded2.setAggregateRootId("collectionID");
        returningList.add(mediaContentAdded2);

        DomainEvent descriptionContentAdded2 = new DescriptionContentAdded("To publish", "Test to create new Content", "Isan Franco", "Test paragraph");
        descriptionContentAdded2.setAggregateRootId("collectionID");
        returningList.add(descriptionContentAdded2);

        DomainEvent mediaContentAdded3 = new MediaContentAdded("To publish", "Test to create new Content", "Isan Franco", "Test URL");
        mediaContentAdded3.setAggregateRootId("collectionID");
        returningList.add(mediaContentAdded3);

        DomainEvent publishContent = new DescriptionContentPublished("Second content");
        publishContent.setAggregateRootId("collectionID");
        returningList.add(publishContent);

        DomainEvent portfolioCreated = new PortfolioCreated(LocalDate.of(2023,1,1), LocalDate.of(2023,6,1));
        portfolioCreated.setAggregateRootId(rootID);
        returningList.add(portfolioCreated);

        DomainEvent addProject = new FeaturedCollectionAdded("collectionID");
        addProject.setAggregateRootId(rootID);
        returningList.add(addProject);



        return returningList;
    }

}
