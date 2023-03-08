package com.Fashion.portfolio.domain.common_project.values;

import com.Fashion.portfolio.generic.Identity;

public class DesignTeamID extends Identity {

    private DesignTeamID(String ID) {
        super(ID);
    }

    public DesignTeamID() {
    }

    public static DesignTeamID of(String ID) {
        return new DesignTeamID(ID);
    }

}
