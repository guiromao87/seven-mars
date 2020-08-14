package com.guiromao.sevenmars.model;

public enum Direction {
    N("North"),
    E("East"),
    S("South"),
    W("West");

    private final String directionName;

    Direction(String directionName) {
        this.directionName = directionName;
    }

    public String getDirectionName() { return directionName; }

    public Direction getNextRight(int originalDirection) {
        if(originalDirection == 3) {
            return Direction.values()[0];
        } else {
            return Direction.values()[originalDirection + 1];
        }
    }

    public Direction getNextLeft(int originalDirection) {
        if(originalDirection == 0) {
            return Direction.values()[3];
        } else {
            return Direction.values()[originalDirection - 1];
        }
    }
}
