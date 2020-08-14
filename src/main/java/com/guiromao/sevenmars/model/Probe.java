package com.guiromao.sevenmars.model;

public class Probe {

    private Position position;
    private Direction direction;

    public Probe(Position position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    public Position getPosition() { return position; }

    public String getDirection() { return direction.getDirectionName(); }
}
