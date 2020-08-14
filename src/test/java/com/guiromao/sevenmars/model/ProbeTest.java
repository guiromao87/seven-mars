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
}
