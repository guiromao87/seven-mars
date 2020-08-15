package com.guiromao.sevenmars.service;

import com.guiromao.sevenmars.model.Limit;
import com.guiromao.sevenmars.model.Plateau;
import com.guiromao.sevenmars.model.Probe;
import com.guiromao.sevenmars.validation.OutsidePlateauLimitException;
import com.guiromao.sevenmars.validation.PlateauLimitValidation;
import com.guiromao.sevenmars.validation.UnregisteredPlateauLimitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlateauService {

    @Autowired
    private Plateau plateau;

    @Autowired
    private PlateauLimitValidation limitValidation;

    public Plateau register(Limit limit) {
        plateau.register(limit);
        return plateau;
    }

    public void register(Probe probe) {
        if(plateau.getLimit() == null)
            throw new UnregisteredPlateauLimitException("Plateau without a registered limit");

        if(limitValidation.isOutInsideOfLimit(probe))
            throw new OutsidePlateauLimitException("Proble crossed the limit of the plateau");

        plateau.register(probe);
    }

    public Optional<Probe> getProbe() { return plateau.getProbe(); }
}
