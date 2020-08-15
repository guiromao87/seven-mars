package com.guiromao.sevenmars.model;

import java.util.*;

public class Plateau {
    private Limit limit;
    private Probe probe;
    private Map<String, Probe> probes = new HashMap<>();

    public void register(Limit limit) {
        this.limit = limit;
    }

    public void register(Probe probe) {
        this.probes.put(probe.getName(), probe);
    }

    public Optional<Probe> getProbe() { return Optional.ofNullable(this.probe); }

    public Map<String, Probe> getProbes() { return Collections.unmodifiableMap(probes); }

    public Limit getLimit() { return limit; }
}
