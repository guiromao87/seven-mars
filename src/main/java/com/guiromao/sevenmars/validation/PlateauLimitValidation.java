package com.guiromao.sevenmars.validation;

import com.guiromao.sevenmars.model.Direction;
import com.guiromao.sevenmars.model.Limit;
import com.guiromao.sevenmars.model.Probe;
import org.springframework.stereotype.Component;

@Component
public class PlateauLimitValidation {

    public boolean isOutInsideOfLimitToRegister(Probe probe, Limit limit) {
        if (probe.getPosition().getX() > limit.getX() || probe.getPosition().getY() > limit.getY())
            return true;

        return false;
    }

    public boolean isOutInsideOfLimitToMove(Probe probe, Limit limit) {

        if (probe.getPosition().getX() < 0 || probe.getPosition().getY() < 0) {
            return true;
        }

        if(probe.getPosition().getX() > limit.getX() || probe.getPosition().getY() > limit.getY()) {
            return true;
        }


        if(probe.getPosition().getX() == 0 && probe.getPosition().getY() == 0) {
            if(probe.getDirection() == Direction.N || probe.getDirection() == Direction.E) {
                return false;
            }
            return true;
        }

        if(probe.getPosition().getX() == limit.getX() && probe.getPosition().getY() == limit.getY()) {
            if(probe.getDirection() == Direction.W || probe.getDirection() == Direction.S) {
                return false;
            }
            return true;
        }

        if(probe.getPosition().getX() == 0 && probe.getPosition().getY() > 0) {
            if(probe.getDirection() == Direction.N || probe.getDirection() == Direction.E || probe.getDirection() == Direction.S) {
                return false;
            }
            return true;
        }

        if(probe.getPosition().getY() == 0 && probe.getPosition().getX() > 0) {
            if(probe.getDirection() == Direction.N || probe.getDirection() == Direction.W || probe.getDirection() == Direction.E) {
                return false;
            }
            return true;
        }

        return false;
    }
}
