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
        probes.forEach((k,v)-> {
            if(v.getPosition().equals(probe.getPosition()))
                throw new PlateauLimitBusyException("You already have a Probe at this point");
        });

        this.probes.put(probe.getName(), probe);
    }

    public Map<String, Probe> getProbes() { return Collections.unmodifiableMap(probes); }

    public Limit getLimit() { return limit; }

    public Optional<Probe> findBy(String name) { return Optional.ofNullable(this.probes.get(name)); }

    public void isLocalEmptyFor(Probe probe) {
        int atualY = probe.getPosition().getY();
        int atualX = probe.getPosition().getX();

        if(probe.getDirection().equals(Direction.N))
            atualY++;
        if(probe.getDirection().equals(Direction.S))
            atualY--;
        if(probe.getDirection().equals(Direction.W))
            atualX--;
        if(probe.getDirection().equals(Direction.E))
            atualX++;

        int finalAtualX = atualX;
        int finalAtualY = atualY;

        probes.forEach((k, probeAtPlateau)-> {
            if(!probe.getName().equals(k)) {
                if(samePosition(probeAtPlateau, finalAtualX, finalAtualY))
                    throw new PlateauLimitBusyException("You already have a Probe at this point");
            }
        });
    }

    private boolean samePosition(Probe probeAtPlateau, int x, int y) {
        if(probeAtPlateau.getPosition().getX() == x && probeAtPlateau.getPosition().getY() == y)
            return true;
        return false;
    }
}
