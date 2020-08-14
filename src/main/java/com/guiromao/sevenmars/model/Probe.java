package com.guiromao.sevenmars.model;

public class Probe {

    private int x;
    private int y;
    private Direction direction;

    public Probe(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public String getDirection() { return direction.getDirectionName(); }
}
