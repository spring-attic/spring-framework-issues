package org.jakubd.validation;

import javax.validation.constraints.NotNull;

public class TestBody {

    @NotNull
    private Integer x;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }
}
