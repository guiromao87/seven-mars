package com.guiromao.sevenmars.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    public Map<String, Probe> getProbes() { return Collections.unmodifiableMap(probes); }

    public Limit getLimit() { return limit; }

    public Optional<Probe> findBy(String name) { return Optional.ofNullable(this.probes.get(name)); }
}
