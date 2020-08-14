package com.guiromao.sevenmars.model;

import java.util.Optional;

public class Plateau {
    private Probe probe;

    public void register(Probe probe) {
        this.probe = probe;
    }

    public Optional<Probe> getProbe() { return Optional.ofNullable(this.probe); }
}
