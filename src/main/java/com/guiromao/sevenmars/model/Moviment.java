package com.guiromao.sevenmars.model;

public enum Moviment {
    L {
        @Override
        public void move(Probe probe) { probe.left(); }
    },

    R {
        @Override
        public void move(Probe probe) { probe.right(); }
    },

    M {
        @Override
        public void move(Probe probe) {
            probe.forward();
        }
    };

    public abstract void move(Probe probe);
}
