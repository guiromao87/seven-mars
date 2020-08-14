package com.guiromao.sevenmars.model;

import java.util.Objects;

public class Probe {

    private Position position;
    private Direction direction;

    public Probe(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() { return position; }

    public String getDirection() { return direction.getDirectionName(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Probe probe = (Probe) o;
        return Objects.equals(position, probe.position) &&
                direction == probe.direction;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}
