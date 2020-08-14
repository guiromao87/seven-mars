package com.guiromao.sevenmars.service;

import com.guiromao.sevenmars.model.Plateau;
import com.guiromao.sevenmars.model.Probe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlateauService {

    @Autowired
    private Plateau plateau;

    public void register(Probe probe) {
        plateau.register(probe);
    }
}
