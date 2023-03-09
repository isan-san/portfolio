package com.Fashion.portfolio.domain.common_project.commands;

import com.Fashion.portfolio.generic.Command;

public class RemoveDesigner extends Command {

    private final String designerName;
    private final String projectID;

    public RemoveDesigner(String designerName, String projectID) {
        this.designerName = designerName;
        this.projectID = projectID;
    }

    public String getDesignerName() {
        return designerName;
    }

    public String getProjectID() {
        return projectID;
    }
}
