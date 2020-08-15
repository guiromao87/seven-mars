package com.guiromao.sevenmars.service;

import com.guiromao.sevenmars.model.Limit;
import com.guiromao.sevenmars.model.Plateau;
import com.guiromao.sevenmars.model.Probe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlateauService {

    @Autowired
    private Plateau plateau;

    public Plateau register(Limit limit) {
        plateau.register(limit);
        return plateau;
    }

    public void register(Probe probe) { plateau.register(probe); }

    public Optional<Probe> getProbe() { return plateau.getProbe(); }
}
