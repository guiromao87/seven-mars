package com.guiromao.sevenmars.service;

import com.guiromao.sevenmars.model.Movement;
import com.guiromao.sevenmars.model.Plateau;
import com.guiromao.sevenmars.model.Probe;
import com.guiromao.sevenmars.validation.PlateauLimitMoveValidation;
import com.guiromao.sevenmars.validation.PlateauOutsideLimitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProbeService {

    @Autowired
    private Plateau plateau;

    @Autowired
    private PlateauLimitMoveValidation limitValidation;

    public Probe move(Probe probe, List<Movement> movements) {
        movements.stream().forEach(movement ->  {
            if(movement == Movement.M) {
                if (limitValidation.isOutInsideOfLimitToMove(probe, plateau.getLimit()))
                    throw new PlateauOutsideLimitException("The probe crossed the limit of the plateau");
                plateau.isLocalEmptyFor(probe);
            }

            probe.move(movement);
        });
        
        return probe;
    }
}
