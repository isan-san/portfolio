package com.Fashion.portfolio.domain.portfolio_agregate;

import com.Fashion.portfolio.domain.common_project.values.DescriptionContent;
import com.Fashion.portfolio.domain.common_project.values.MediaContent;
import com.Fashion.portfolio.domain.portfolio_agregate.values.PortfolioVersion;
import com.Fashion.portfolio.domain.portfolio_agregate.values.PortfolioVersionHandlerID;
import com.Fashion.portfolio.generic.Entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class PortfolioVersionHandler extends Entity<PortfolioVersionHandlerID> {

    private ArrayList<PortfolioVersion> versions;
    private PortfolioVersion lastVersion;

    public PortfolioVersionHandler(PortfolioVersionHandlerID id) {
        super(id);
        this.lastVersion = new PortfolioVersion();
        versions.add(lastVersion);
    }

    public PortfolioVersion publishVersion(ArrayList<DescriptionContent> descriptionContents,
                                           ArrayList<MediaContent> mediaContents) {
        lastVersion=lastVersion.releasePortFolio(descriptionContents, mediaContents);
        versions.add(lastVersion);
        return lastVersion;
    }

    public ArrayList<PortfolioVersion> versions(){
        return versions;
    }

    public PortfolioVersion lastVersion(){
        return lastVersion;
    }

}
