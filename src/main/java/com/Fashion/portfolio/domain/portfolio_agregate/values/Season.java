package com.Fashion.portfolio.domain.portfolio_agregate.values;

import com.Fashion.portfolio.generic.ValueObject;

import java.time.LocalDate;

public class Season implements ValueObject<Season.Props> {

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final Boolean isActive;

    public Season(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = true;
    }

    private Season(LocalDate startDate, LocalDate endDate, Boolean isActive) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }

    public Season endSeason(){
        return new Season(this.startDate, this.endDate, false);
    }

    @Override
    public Props value() {
        return new Props() {
            @Override
            public LocalDate startDate() {
                return startDate;
            }

            @Override
            public LocalDate endDate() {
                return endDate;
            }

            @Override
            public Boolean isActive() {
                return isActive;
            }
        };
    }

    public interface Props{

        LocalDate startDate();
        LocalDate endDate();
        Boolean isActive();

    }

}
