package com.Fashion.portfolio.domain.common_project.values;

import com.Fashion.portfolio.generic.Identity;

public class ProjectID extends Identity {

    private ProjectID(String ID) {
        super(ID);
    }

    public ProjectID() {
    }

    public static ProjectID of(String ID) {
        return new ProjectID(ID);
    }

}
