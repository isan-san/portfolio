package com.Fashion.portfolio.domain.ID_project_agregate.values;

import com.Fashion.portfolio.generic.ValueObject;

public class IDProjectState implements ValueObject<IDProjectState.Props> {

    public IDProjectState() {
        this.state = "start";
        this.isActive = true;
    }

    private IDProjectState(String state, Boolean isActive) {
        this.state = state;
        this.isActive = isActive;
    }

    public IDProjectState changeState(String state) {
        return new IDProjectState(state, this.isActive);
    }

    public IDProjectState finish(){
        return new IDProjectState("finish", false);
    }

    private final String state;
    private final Boolean isActive;

    @Override
    public Props value() {
        return new Props() {
            @Override
            public String state() {
                return state;
            }

            @Override
            public Boolean isActive() {
                return isActive;
            }
        };
    }

    public interface Props{
        String state();
        Boolean isActive();
    }

}
