package com.guiromao.sevenmars.model;

import java.util.Optional;

public class Plateau {
    private Limit limit;
    private Probe probe;

    public void register(Limit limit) {
        this.limit = limit;
    }

    public void register(Probe probe) {
        this.probe = probe;
    }

    public Optional<Probe> getProbe() { return Optional.ofNullable(this.probe); }

    public Limit getLimit() { return limit; }
}
