package com.Fashion.portfolio.domain.portfolio_agregate;

import com.Fashion.portfolio.domain.ID_project_agregate.values.IDProjectID;
import com.Fashion.portfolio.domain.common_project.values.DescriptionContent;
import com.Fashion.portfolio.domain.common_project.values.MediaContent;
import com.Fashion.portfolio.domain.featured_collection_agregate.values.FeaturedCollectionID;
import com.Fashion.portfolio.domain.own_collection_agregate.values.OwnCollectionID;
import com.Fashion.portfolio.domain.portfolio_agregate.values.SeasonProjectsID;
import com.Fashion.portfolio.generic.Entity;

import java.util.ArrayList;

public class SeasonProjects extends Entity<SeasonProjectsID> {

    private ArrayList<IDProjectID> idProjects;
    private ArrayList<FeaturedCollectionID> featuredCollections;
    private ArrayList<OwnCollectionID> ownCollections;

    public SeasonProjects(SeasonProjectsID id) {
        super(id);
        this.idProjects = new ArrayList<>();
        this.featuredCollections = new ArrayList<>();
        this.ownCollections = new ArrayList<>();
    }

    public IDProjectID addProject(IDProjectID ID) {
        if (idProjects.stream().noneMatch(project -> project.equals(ID))) {
            idProjects.add(ID);
            return ID;
        } else {
            return null;
        }
    }
    public FeaturedCollectionID addProject(FeaturedCollectionID ID) {
        if (featuredCollections.stream().noneMatch(project -> project.equals(ID))) {
            featuredCollections.add(ID);
            return ID;
        } else {
            return null;
        }
    }
    public OwnCollectionID addProject(OwnCollectionID ID) {
        if (ownCollections.stream().noneMatch(project -> project.equals(ID))) {
            ownCollections.add(ID);
            return ID;
        } else {
            return null;
        }
    }


    public Boolean removeProject(IDProjectID ID) {
        return idProjects.removeIf((project -> project.equals(ID)));
    }

    public Boolean removeProject(FeaturedCollectionID ID) {
        return featuredCollections.removeIf((project -> project.equals(ID)));
    }

    public Boolean removeProject(OwnCollectionID ID) {
        return ownCollections.removeIf((project -> project.equals(ID)));
    }




}
