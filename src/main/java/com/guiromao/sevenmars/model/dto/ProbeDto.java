package com.guiromao.sevenmars.model.dto;

import com.guiromao.sevenmars.model.Probe;

public class ProbeDto {

    private int x;
    private int y;
    private String direction;
    private String name;

    public ProbeDto(Probe probe) {
        this.x = probe.getPosition().getX();
        this.y = probe.getPosition().getY();
        this.direction = probe.getDirection().getDirectionName();
        this.name = probe.getName();
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public String getDirection() { return direction; }

    public String getName() { return name; }
}
