package com.guiromao.sevenmars.service;

import com.guiromao.sevenmars.model.Moviment;
import com.guiromao.sevenmars.model.Plateau;
import com.guiromao.sevenmars.model.Probe;
import com.guiromao.sevenmars.validation.OutsidePlateauLimitException;
import com.guiromao.sevenmars.validation.PlateauLimitMoveValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProbeService {

    @Autowired
    private Plateau plateau;

    @Autowired
    private PlateauLimitMoveValidation limitValidation;

    public Probe move(Probe probe, List<Moviment> moviments) {
        moviments.stream().forEach(movement ->  {
            if(movement == Moviment.M) {
                if (limitValidation.isOutInsideOfLimitToMove(probe, plateau.getLimit()))
                    throw new OutsidePlateauLimitException("The probe crossed the limit of the plateau");
                plateau.isLocalEmptyFor(probe);
            }
            movement.move(probe);
        });
        
        return probe;
    }
}
