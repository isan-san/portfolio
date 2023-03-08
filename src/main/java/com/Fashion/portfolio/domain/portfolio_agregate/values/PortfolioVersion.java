package com.Fashion.portfolio.domain.portfolio_agregate.values;

import com.Fashion.portfolio.domain.common_project.values.DescriptionContent;
import com.Fashion.portfolio.domain.common_project.values.MediaContent;
import com.Fashion.portfolio.generic.ValueObject;

import java.time.LocalDate;
import java.util.ArrayList;

public class PortfolioVersion implements ValueObject<PortfolioVersion.Props> {

    private final Integer version;
    private final LocalDate releaseDate;
    private final ArrayList<DescriptionContent> descriptionContents;
    private final ArrayList<MediaContent> mediaContents;

    private PortfolioVersion(Integer version, ArrayList<DescriptionContent> descriptionContents, ArrayList<MediaContent> mediaContents) {
        this.version = version;
        this.releaseDate = LocalDate.now();
        this.descriptionContents = descriptionContents;
        this.mediaContents = mediaContents;
    }

    public PortfolioVersion(){
        this.version = 0;
        this.releaseDate = LocalDate.now();
        this.descriptionContents = null;
        this.mediaContents = null;
    }

    public PortfolioVersion releasePortFolio(ArrayList<DescriptionContent> descriptionContents, ArrayList<MediaContent> mediaContents) {
        return new PortfolioVersion(this.version+1, descriptionContents, mediaContents);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public Integer version() {
                return version;
            }

            @Override
            public LocalDate releaseDate() {
                return releaseDate;
            }

            @Override
            public ArrayList<DescriptionContent> descriptionContents() {
                return descriptionContents;
            }

            @Override
            public ArrayList<MediaContent> mediaContents() {
                return mediaContents;
            }
        };
    }

    public interface Props {

        Integer version();
        LocalDate releaseDate();
        ArrayList<DescriptionContent> descriptionContents();
        ArrayList<MediaContent> mediaContents();
    }

}
