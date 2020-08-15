package com.guiromao.sevenmars.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTest {

    @Test
    public void shouldReturnEast() {
        Direction initial = Direction.N;
        Direction newDirection = initial.getNextRight(initial.ordinal());

        assertEquals(Direction.E, newDirection);
    }

    @Test
    public void shouldReturnWest() {
        Direction initial = Direction.N;
        Direction newDirection = initial.getNextLeft(initial.ordinal());

        assertEquals(Direction.W, newDirection);
    }
}
