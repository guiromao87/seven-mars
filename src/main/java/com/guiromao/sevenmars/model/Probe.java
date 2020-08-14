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

    public Direction getDirection() { return direction; }

    public void forward() {
        if(direction.equals(Direction.N))
            this.position.plusY();

        if(direction.equals(Direction.S))
            this.position.minusY();

        if(direction.equals(Direction.E))
            this.position.plusX();

        if(direction.equals(Direction.W))
            this.position.minusX();
    }

    public void right() {
        this.direction = direction.getNextRight(direction.ordinal());
    }

    public void left() {
        this.direction = direction.getNextLeft(direction.ordinal());
    }

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
