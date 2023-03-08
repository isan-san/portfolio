package com.Fashion.portfolio.domain.ID_project_agregate.values;

import com.Fashion.portfolio.domain.portfolio_agregate.values.PortfolioID;
import com.Fashion.portfolio.generic.Identity;

public class IDProjectID extends Identity {

    private IDProjectID(String ID) {
        super(ID);
    }

    public IDProjectID() {
    }

    public static IDProjectID of(String ID) {
        return new IDProjectID(ID);
    }

}
