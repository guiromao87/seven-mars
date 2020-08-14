package com.guiromao.sevenmars.model;

public enum Direction {
    N("North"),
    S("South"),
    E("East"),
    W("West");

    private final String directionName;

    Direction(String directionName) {
        this.directionName = directionName;
    }

    public String getDirectionName() { return directionName; }
}
