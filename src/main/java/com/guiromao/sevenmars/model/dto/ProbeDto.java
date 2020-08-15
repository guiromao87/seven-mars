package com.guiromao.sevenmars.model.dto;

import com.guiromao.sevenmars.model.Probe;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProbeDto {

    private String name;
    private int x;
    private int y;
    private String direction;

    public ProbeDto(Probe probe) {
        this.name = probe.getName();
        this.x = probe.getPosition().getX();
        this.y = probe.getPosition().getY();
        this.direction = probe.getDirection().getDirectionName();
    }

    public String getName() { return name; }

    public int getX() { return x; }

    public int getY() { return y; }

    public String getDirection() { return direction; }

    public static List<ProbeDto> toProbesDto(Map<String, Probe> probes) {
        List<Probe> listOfProbes = probes.values().stream().collect(Collectors.toList());
        return listOfProbes.stream().map(ProbeDto::new).collect(Collectors.toList());
    }
}
