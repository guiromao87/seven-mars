package com.guiromao.sevenmars.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Test
    public void shouldIncreaseAPositionOnTheXAxis() {
        Position initial = new Position(3,2);
        initial.plusX();

        assertEquals(4, initial.getX());
        assertEquals(2, initial.getY());
    }

    @Test
    public void shouldIncreaseTwoPositionsOnTheYAxis() {
        Position initial = new Position(3,2);
        initial.plusY();
        initial.plusY();

        assertEquals(3, initial.getX());
        assertEquals(4, initial.getY());
    }

    @Test
    public void shouldDecreaseAPositionsOnTheXAxis() {
        Position initial = new Position(3,2);
        initial.minusX();

        assertEquals(2, initial.getX());
        assertEquals(2, initial.getY());
    }

    @Test
    public void shouldDecreaseAPositionsOnTheYAxis() {
        Position initial = new Position(3,2);
        initial.minusY();

        assertEquals(3, initial.getX());
        assertEquals(1, initial.getY());
    }
}
