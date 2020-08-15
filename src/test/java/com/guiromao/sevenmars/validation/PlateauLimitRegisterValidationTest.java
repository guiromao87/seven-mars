package com.guiromao.sevenmars.validation;

import com.guiromao.sevenmars.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlateauLimitRegisterValidationTest {

    private Limit limit;
    private PlateauLimitRegisterValidation limitValidation;

    @BeforeEach
    public void setUp() {
        limit = new Limit(5, 5);
        limitValidation = new PlateauLimitRegisterValidation();
    }

    @Test
    public void shouldBeRegisterInsideThePlateauStartingAt0And0(){
        Probe probe = new Probe(new Position(0,0), Direction.N);
        boolean isOutInsideOfLimit = limitValidation.isOutInsideOfLimitToRegister(probe, limit);

        assertEquals(false, isOutInsideOfLimit);
    }

    @Test
    public void shouldBeRegisterInsideThePlateauStartingAt3And2(){
        Probe probe = new Probe(new Position(3,2), Direction.N);
        boolean isOutInsideOfLimit = limitValidation.isOutInsideOfLimitToRegister(probe, limit);

        assertEquals(false, isOutInsideOfLimit);
    }

    @Test
    public void shouldBeRegisterInsideThePlateauStartingAt5And5(){
        Probe probe = new Probe(new Position(5,5), Direction.N);
        boolean isOutInsideOfLimit = limitValidation.isOutInsideOfLimitToRegister(probe, limit);

        assertEquals(false, isOutInsideOfLimit);
    }

    @Test
    public void shouldNotBeRegisterInsideThePlateauStartingAt5And6(){
        Probe probe = new Probe(new Position(5,6), Direction.N);
        boolean isOutInsideOfLimit = limitValidation.isOutInsideOfLimitToRegister(probe, limit);

        assertEquals(true, isOutInsideOfLimit);
    }

    @Test
    public void shouldNotBeRegisterInsideThePlateauStartingAt6And5(){
        Probe probe = new Probe(new Position(6,5), Direction.N);
        boolean isOutInsideOfLimit = limitValidation.isOutInsideOfLimitToRegister(probe, limit);

        assertEquals(true, isOutInsideOfLimit);
    }
}
