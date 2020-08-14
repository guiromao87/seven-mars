package com.guiromao.sevenmars.model;

public class Plateau {
    private Probe probe;

    public void register(Probe probe) {
        this.probe = probe;
    }

    public Probe getProbe() { return probe; }
}
