package com.guiromao.sevenmars.model;

import com.guiromao.sevenmars.validation.PlateauLimitBusyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlateauTest {

    @Test
    public void shouldRegisterTwoProbesInDifferentPositions() {
        Probe probe1 = new Probe(new Position(0,0), Direction.N, "probe1");
        Probe probe2 = new Probe(new Position(1,0), Direction.N, "probe2");

        Plateau plateau = new Plateau();
        plateau.register(probe1);
        plateau.register(probe2);

        assertEquals(2, plateau.getProbes().size());
    }

    @Test
    public void shouldRegisterTwoProbesInSamePosition() {
        Probe probe1 = new Probe(new Position(0,0), Direction.N, "probe1");
        Probe probe2 = new Probe(new Position(0,0), Direction.N, "probe2");

        Plateau plateau = new Plateau();
        plateau.register(probe1);

        Exception exception = assertThrows(PlateauLimitBusyException.class, () -> plateau.register(probe2));

        assertTrue(exception.getMessage().contains("You already have a Probe at this point"));
    }
}
