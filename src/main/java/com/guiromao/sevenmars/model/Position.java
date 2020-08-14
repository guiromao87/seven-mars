package com.guiromao.sevenmars.model;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public void plusX() { this.x++; }

    public void minusX() { this.x--; }

    public void plusY() {
        this.y++;
    }

    public void minusY() { this.y--; }
}
