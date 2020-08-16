package com.guiromao.sevenmars.model;

import com.guiromao.sevenmars.validation.PlateauLimitBusyException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Plateau {
    private Limit limit;
    private Map<String, Probe> probes = new HashMap<>();

    public void register(Limit limit) {
        this.limit = limit;
    }

    public void register(Probe probe) {
        probes.forEach((name, currentProbe)-> {
            if(currentProbe.getPosition().equals(probe.getPosition()))
                throw new PlateauLimitBusyException("You already have a Probe at this point");
        });

        this.probes.put(probe.getName(), probe);
    }

    public Map<String, Probe> getProbes() { return Collections.unmodifiableMap(probes); }

    public Limit getLimit() { return limit; }

    public Optional<Probe> findBy(String name) { return Optional.ofNullable(this.probes.get(name)); }

    public void isLocalEmptyFor(Probe probe) {
        Position position = probe.nextPositions();

        probes.forEach((name, currentProbe)-> {
            if(!probe.getName().equals(name)) {
                if(samePosition(currentProbe, position))
                    throw new PlateauLimitBusyException("You already have a Probe at this point");
            }
        });
    }

    private boolean samePosition(Probe probeAtPlateau, Position position) {
        if(probeAtPlateau.getPosition().getX() == position.getX() && probeAtPlateau.getPosition().getY() == position.getY())
            return true;
        return false;
    }
}
