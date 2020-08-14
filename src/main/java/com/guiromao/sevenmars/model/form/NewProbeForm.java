package com.guiromao.sevenmars.model.form;

import com.guiromao.sevenmars.model.Direction;
import com.guiromao.sevenmars.model.Position;
import com.guiromao.sevenmars.model.Probe;

public class NewProbeForm {
    private int x;
    private int y;
    private Direction direction;

    public int getX() { return x; }

    public int getY() { return y; }

    public String getDirection() { return direction.getDirectionName(); }

    public Probe toProbe() {
        Position position = new Position(this.x, this.y);
        return new Probe(position, direction);
    }
}
