package com.guiromao.sevenmars.model.form;

import com.guiromao.sevenmars.model.Direction;
import com.guiromao.sevenmars.model.Position;
import com.guiromao.sevenmars.model.Probe;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class NewProbeForm {

    @NotNull(message = "Required field")
    @Min(value = 0, message = "Position x must be equal to or greater than 0")
    private Integer x;

    @NotNull(message = "Required field")
    @Min(value = 0, message = "Position y must be equal to or greater than 0")
    private Integer y;

    @NotNull(message = "Required field")
    private Direction direction;

    public int getX() { return x; }

    public int getY() { return y; }

    public String getDirection() { return direction.getDirectionName(); }

    public Probe toProbe() {
        Position position = new Position(this.x, this.y);
        return new Probe(position, direction);
    }
}
