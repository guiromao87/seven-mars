package com.guiromao.sevenmars.service;

import com.guiromao.sevenmars.model.Moviment;
import com.guiromao.sevenmars.model.Plateau;
import com.guiromao.sevenmars.model.Probe;
import com.guiromao.sevenmars.validation.ProbeNotAtPlateauException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProbeService {

    @Autowired
    private Plateau plateau;

    public void move(List<Moviment> moviments) {
        Optional<Probe> optional = plateau.getProbe();

        if(!optional.isPresent())
            throw new ProbeNotAtPlateauException("No probe registered in the plateau");

        Probe probe = optional.get();
        moviments.stream().forEach(moviment -> moviment.move(probe));
    }
}
