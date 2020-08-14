package com.guiromao.sevenmars.model.form;

import com.guiromao.sevenmars.model.Direction;
import com.guiromao.sevenmars.model.Probe;

public class NewProbeForm {
    private int x;
    private int y;
    private Direction direction;

    public int getX() { return x; }

    public int getY() { return y; }

    public String getDirection() { return direction.getDirectionName(); }

    public Probe toProbe() {
        return new Probe(x,y,direction);
    }
}
