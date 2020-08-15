package com.guiromao.sevenmars.validation;

import com.guiromao.sevenmars.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlateauLimitMoveValidationTest {
    private Limit limit;
    private PlateauLimitMoveValidation limitValidation;

    @BeforeEach
    public void setUp() {
        limit = new Limit(5,5);
        limitValidation = new PlateauLimitMoveValidation();
    }



    @Test
    public void shouldBeInsideThePlateauStartingAt0And0andNorthAndMovingForwardOnce() {
        Probe probe = new Probe(new Position(0,0), Direction.N, "probe1");
        probe.forward();

        boolean isOutInsideOfLimit = limitValidation.isOutInsideOfLimitToMove(probe, limit);

        assertEquals(false, isOutInsideOfLimit);
        assertEquals(0, probe.getPosition().getX());
        assertEquals(1, probe.getPosition().getY());
    }

    @Test
    public void shouldBeInsideThePlateauStartingAt3And0andEastAndMovingForwardOnce() {
        Probe probe = new Probe(new Position(3,0), Direction.E, "probe1");
        probe.forward();

        boolean isOutInsideOfLimit = limitValidation.isOutInsideOfLimitToMove(probe, limit);

        assertEquals(false, isOutInsideOfLimit);
        assertEquals(4, probe.getPosition().getX());
        assertEquals(0, probe.getPosition().getY());
    }

    @Test
    public void shouldBeInsideThePlateauStartingAt3And0andNorthAndMovingForwardTwice() {
        Probe probe = new Probe(new Position(3,0), Direction.N, "probe1");
        probe.forward();
        probe.forward();

        boolean isOutInsideOfLimit = limitValidation.isOutInsideOfLimitToMove(probe, limit);

        assertEquals(false, isOutInsideOfLimit);
        assertEquals(3, probe.getPosition().getX());
        assertEquals(2, probe.getPosition().getY());
    }

    @Test
    public void shouldBeInsideThePlateauStartingAt0And4andSouthAndMovingForwardOnce() {
        Probe probe = new Probe(new Position(0,4), Direction.S, "probe1");
        probe.forward();

        boolean isOutInsideOfLimit = limitValidation.isOutInsideOfLimitToMove(probe, limit);

        assertEquals(false, isOutInsideOfLimit);
        assertEquals(0, probe.getPosition().getX());
        assertEquals(3, probe.getPosition().getY());
    }

    @Test
    public void shouldBeInsideThePlateauStartingAt1And2andNorthAndSequenceLMLMLMLMM() {
        Probe probe = new Probe(new Position(1,2), Direction.N, "probe1");
        probe.left();
        probe.forward();
        probe.left();
        probe.forward();
        probe.left();
        probe.forward();
        probe.left();
        probe.forward();
        probe.forward();

        boolean isOutInsideOfLimit = limitValidation.isOutInsideOfLimitToMove(probe, limit);

        assertEquals(false, isOutInsideOfLimit);
        assertEquals(1, probe.getPosition().getX());
        assertEquals(3, probe.getPosition().getY());
        assertEquals(Direction.N, probe.getDirection());
    }

    @Test
    public void shouldBeInsideThePlateauStartingAt3And3andEastAndSequenceMMRMMRMRRM() {
        Probe probe = new Probe(new Position(3,3), Direction.E, "probe1");
        probe.forward();
        probe.forward();
        probe.right();

        probe.forward();
        probe.forward();
        probe.right();

        probe.forward();
        probe.right();
        probe.right();
        probe.forward();

        boolean isOutInsideOfLimit = limitValidation.isOutInsideOfLimitToMove(probe, limit);

        assertEquals(false, isOutInsideOfLimit);
        assertEquals(5, probe.getPosition().getX());
        assertEquals(1, probe.getPosition().getY());
        assertEquals(Direction.E, probe.getDirection());
    }

    @Test
    public void shouldBeInsideThePlateauStartingAt5And5andSouthAndMovingForwardOnce() {
        Probe probe = new Probe(new Position(5,5), Direction.S, "probe1");
        probe.forward();

        boolean isOutInsideOfLimit = limitValidation.isOutInsideOfLimitToMove(probe, limit);

        assertEquals(false, isOutInsideOfLimit);
        assertEquals(5, probe.getPosition().getX());
        assertEquals(4, probe.getPosition().getY());
    }

    @Test
    public void shouldBeInsideThePlateauStartingAt5And5andWestAndMovingForwardOnce() {
        Probe probe = new Probe(new Position(5,5), Direction.W, "probe1");
        probe.forward();

        boolean isOutInsideOfLimit = limitValidation.isOutInsideOfLimitToMove(probe, limit);

        assertEquals(false, isOutInsideOfLimit);
        assertEquals(4, probe.getPosition().getX());
        assertEquals(5, probe.getPosition().getY());
    }

    @Test()
    public void shouldNotBeInsideThePlateauStartingAt0And0andEastAndMovingRightAndForwardOnce() {
        Probe probe = new Probe(new Position(0,0), Direction.E, "probe1");
        probe.right();
        probe.forward();

        boolean isOutInsideOfLimit = limitValidation.isOutInsideOfLimitToMove(probe, limit);

        assertEquals(true, isOutInsideOfLimit);
        assertEquals(0, probe.getPosition().getX());
        assertEquals(-1, probe.getPosition().getY());
    }

    @Test()
    public void shouldNotBeInsideThePlateauStartingAt0And0andWestAndMovingForwardOnce() {
        Probe probe = new Probe(new Position(0,0), Direction.W, "probe1");
        probe.forward();

        boolean isOutInsideOfLimit = limitValidation.isOutInsideOfLimitToMove(probe, limit);

        assertEquals(true, isOutInsideOfLimit);
        assertEquals(-1, probe.getPosition().getX());
        assertEquals(0, probe.getPosition().getY());
    }

    @Test
    public void shouldNotBeInsideThePlateauStartingAt5And5andNorthAndMovingForwardOnce() {
        Probe probe = new Probe(new Position(5,5), Direction.N, "probe1");
        probe.forward();

        boolean isOutInsideOfLimit = limitValidation.isOutInsideOfLimitToMove(probe, limit);

        assertEquals(true, isOutInsideOfLimit);
        assertEquals(5, probe.getPosition().getX());
        assertEquals(6, probe.getPosition().getY());
    }

    @Test
    public void shouldNotBeInsideThePlateauStartingAt5And5andEastAndMovingForwardOnce() {
        Probe probe = new Probe(new Position(5,5), Direction.E, "probe1");
        probe.forward();

        boolean isOutInsideOfLimit = limitValidation.isOutInsideOfLimitToMove(probe, limit);

        assertEquals(true, isOutInsideOfLimit);
        assertEquals(6, probe.getPosition().getX());
        assertEquals(5, probe.getPosition().getY());
    }
}
