package com.guiromao.sevenmars.validation;

import com.guiromao.sevenmars.model.Plateau;
import com.guiromao.sevenmars.model.Probe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlateauLimitValidation {

    @Autowired
    private Plateau plateau;

    public boolean isOutInsideOfLimit(Probe probe) {
        if(probe.getPosition().getX() > plateau.getLimit().getX()
            || probe.getPosition().getY() > plateau.getLimit().getY())
            return true;

        return false;
    }
}
