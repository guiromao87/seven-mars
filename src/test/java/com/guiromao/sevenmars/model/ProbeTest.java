package com.guiromao.sevenmars.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProbeTest {

    @Test
    public void shouldTurnFromNorthToEastInTheSamePosition() {
        Probe probe = new Probe(new Position(0,0), Direction.N);
        probe.right();

        assertEquals(Direction.E, probe.getDirection());
    }

    @Test
    public void shouldTurnFromEastToSouthInTheSamePosition() {
        Probe probe = new Probe(new Position(0,0), Direction.E);
        probe.right();

        assertEquals(Direction.S, probe.getDirection());
    }

    @Test
    public void shouldTurnFromSouthToWestInTheSamePosition() {
        Probe probe = new Probe(new Position(0,0), Direction.S);
        probe.right();

        assertEquals(Direction.W, probe.getDirection());
    }

    @Test
    public void shouldTurnFromWestToNorthInTheSamePosition() {
        Probe probe = new Probe(new Position(0,0), Direction.W);
        probe.right();

        assertEquals(Direction.N, probe.getDirection());
    }

    @Test
    public void shouldTurnFromNorthToWestInTheSamePosition() {
        Probe probe = new Probe(new Position(0,0), Direction.N);
        probe.left();

        assertEquals(Direction.W, probe.getDirection());
    }

    @Test
    public void shouldTurnFromWestToSouthInTheSamePosition() {
        Probe probe = new Probe(new Position(0,0), Direction.W);
        probe.left();

        assertEquals(Direction.S, probe.getDirection());
    }

    @Test
    public void shouldTurnFromSouthToEastInTheSamePosition() {
        Probe probe = new Probe(new Position(0,0), Direction.S);
        probe.left();

        assertEquals(Direction.E, probe.getDirection());
    }

    @Test
    public void shouldTurnFromEastToNorthInTheSamePosition() {
        Probe probe = new Probe(new Position(0,0), Direction.E);
        probe.right();

        assertEquals(Direction.S, probe.getDirection());
    }

    @Test
    public void shouldTakeAFullRightTurnFromTheSouthInTheSamePosition() {
        Probe probe = new Probe(new Position(0,0), Direction.S);
        probe.right();
        probe.right();
        probe.right();
        probe.right();

        assertEquals(Direction.S, probe.getDirection());
    }

    @Test
    public void shouldTakeAFullLeftTurnFromTheWestInTheSamePosition() {
        Probe probe = new Probe(new Position(0,0), Direction.W);
        probe.left();
        probe.left();
        probe.left();
        probe.left();

        assertEquals(Direction.W, probe.getDirection());
    }

    @Test
    public void shouldTurnTwiceToTheRightAndThreeTimesToTheLeftFromTheSouthInTheSamePosition() {
        Probe probe = new Probe(new Position(0,0), Direction.S);
        probe.right();
        probe.right();
        probe.left();
        probe.left();
        probe.left();

        assertEquals(Direction.E, probe.getDirection());
    }

    @Test
    public void shouldMoveForwardOnePointTowardsTheNorth() {
        Probe probe = new Probe(new Position(1,2), Direction.N);
        probe.forward();

        assertEquals(1, probe.getPosition().getX());
        assertEquals(3, probe.getPosition().getY());
    }

    @Test
    public void shouldMoveForwardTwoPointsTowardsTheEast() {
        Probe probe = new Probe(new Position(1,3), Direction.E);
        probe.forward();
        probe.forward();

        assertEquals(3, probe.getPosition().getX());
        assertEquals(3, probe.getPosition().getY());
    }

    @Test
    public void shouldMoveForwardTwoPointsTowardsTheWest() {
        Probe probe = new Probe(new Position(2,5), Direction.W);
        probe.forward();
        probe.forward();

        assertEquals(0, probe.getPosition().getX());
        assertEquals(5, probe.getPosition().getY());
    }

    @Test
    public void shouldMoveForwardOnePointTowardsTheSouth() {
        Probe probe = new Probe(new Position(4,3), Direction.S);
        probe.forward();

        assertEquals(4, probe.getPosition().getX());
        assertEquals(2, probe.getPosition().getY());
    }
}