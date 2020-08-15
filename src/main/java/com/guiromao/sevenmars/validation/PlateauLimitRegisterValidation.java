package com.guiromao.sevenmars.validation;

import com.guiromao.sevenmars.model.Limit;
import com.guiromao.sevenmars.model.Probe;
import org.springframework.stereotype.Component;

@Component
public class PlateauLimitRegisterValidation {

    public boolean isOutInsideOfLimitToRegister(Probe probe, Limit limit) {
        if (probe.getPosition().getX() > limit.getX() || probe.getPosition().getY() > limit.getY())
            return true;

        return false;
    }
}
