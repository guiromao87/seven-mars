package com.guiromao.sevenmars.model.form;

import com.guiromao.sevenmars.model.Limit;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class NewLimitPlateauForm {
    @NotNull(message = "Required field")
    @Min(value = 1, message = "Position x must be greater than 0")
    private Integer x;

    @NotNull(message = "Required field")
    @Min(value = 1, message = "Position y must be greater than 0")
    private Integer y;

    public Integer getX() { return x; }

    public Integer getY() { return y; }

    public Limit toLimit() {
        return new Limit(this.x, this.y);
    }
}
