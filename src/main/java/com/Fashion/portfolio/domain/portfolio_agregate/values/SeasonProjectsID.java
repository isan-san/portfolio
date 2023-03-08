package com.Fashion.portfolio.domain.portfolio_agregate.values;

import com.Fashion.portfolio.generic.Identity;

public class SeasonProjectsID extends Identity {

    private SeasonProjectsID(String ID) {
        super(ID);
    }

    public SeasonProjectsID() {
    }

    public static SeasonProjectsID of(String ID) {
        return new SeasonProjectsID(ID);
    }

}
