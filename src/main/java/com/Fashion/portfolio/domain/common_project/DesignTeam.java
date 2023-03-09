package com.Fashion.portfolio.domain.common_project;

import com.Fashion.portfolio.domain.common_project.values.DesignTeamID;
import com.Fashion.portfolio.domain.common_project.values.Designer;
import com.Fashion.portfolio.generic.Entity;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

public class DesignTeam extends Entity<DesignTeamID> {

    private ArrayList<Designer> designers;

    public DesignTeam(DesignTeamID ID) {
        super(ID);
    }

    public ArrayList<Designer> designers() {
        return this.designers;
    }

    protected Designer addDesigner(String name, String role, String description) {
        Designer newDesigner = new Designer(name, role, description);
        this.designers.add(newDesigner);
        return newDesigner;
    }

    protected Boolean removeDesigner(String name) {
        return this.designers.removeIf(designer -> designer.value().name().equals(name));
    }

    protected Designer updateDescription(String name, String description) {
        Optional<Designer> newDesigner = this.designers.stream().filter(designer -> designer.value().name().equals(name)).findFirst();
        return newDesigner.map(designer -> designer.updateDescription(description)).orElse(null);
    }

    protected Designer updateRole(String name, String role) {
        Optional<Designer> newDesigner = this.designers.stream().filter(designer -> designer.value().name().equals(name)).findFirst();
        return newDesigner.map(designer -> designer.updaterRole(role)).orElse(null);
    }

}
