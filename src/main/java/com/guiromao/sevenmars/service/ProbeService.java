package com.guiromao.sevenmars.service;

import com.guiromao.sevenmars.model.Moviment;
import com.guiromao.sevenmars.model.Plateau;
import com.guiromao.sevenmars.model.Probe;
import com.guiromao.sevenmars.validation.OutsidePlateauLimitException;
import com.guiromao.sevenmars.validation.PlateauLimitValidation;
import com.guiromao.sevenmars.validation.ProbeNotAtPlateauException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProbeService {

    @Autowired
    private Plateau plateau;

    @Autowired
    private PlateauLimitValidation limitValidation;

    public Probe move(List<Moviment> moviments) {
        Optional<Probe> optional = plateau.getProbe();

        if(!optional.isPresent())
            throw new ProbeNotAtPlateauException("No probe registered in the plateau");

        Probe probe = optional.get();

        moviments.stream().forEach(movement ->  {
            if(movement == Moviment.M)
                if (limitValidation.isOutInsideOfLimitToMove(probe, plateau.getLimit()))
                    throw new OutsidePlateauLimitException("The probe crossed the limit of the plateau");

            movement.move(probe);
        });

        return probe;
    }
}
