package com.Fashion.portfolio.domain.common_project.values;

import com.Fashion.portfolio.generic.Identity;

public class ProjectContentID extends Identity {

    private ProjectContentID(String ID) {
        super(ID);
    }

    public ProjectContentID() {
    }

    public static ProjectContentID of(String ID) {
        return new ProjectContentID(ID);
    }

}
