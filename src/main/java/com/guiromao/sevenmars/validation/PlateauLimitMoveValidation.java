package com.guiromao.sevenmars.validation;

import com.guiromao.sevenmars.model.Direction;
import com.guiromao.sevenmars.model.Limit;
import com.guiromao.sevenmars.model.Probe;
import org.springframework.stereotype.Component;

@Component
public class PlateauLimitMoveValidation {

    public boolean isOutInsideOfLimitToMove(Probe probe, Limit limit) {

        if (isSomeNegativePosition(probe))
            return true;

        if(isPassLimitOfPlateau(probe, limit))
            return true;

        if (isAtBeginningOfThePlateauAndDirectionIsWestOrSouth(probe))
            return true;

        if(isAtLimitOfThePlateauAndDirectionIsEastOrNorth(probe, limit))
            return true;

        if(isOnXAxisAndDirectionIsSouth(probe))
            return true;

        if(isOnYAxisAndDirectionIsWest(probe))
            return true;

        if(isOnXAxisAndDirectToEast(probe, limit))
            return true;

        if(isOnYAxisAndDirectToNorth(probe, limit))
            return true;

        return false;
    }


    private boolean isSomeNegativePosition(Probe probe) {
        return probe.getPosition().getX() < 0 || probe.getPosition().getY() < 0;
    }

    private boolean isPassLimitOfPlateau(Probe probe, Limit limit) {
        return probe.getPosition().getX() > limit.getX() || probe.getPosition().getY() > limit.getY();
    }


    private boolean isAtBeginningOfThePlateauAndDirectionIsWestOrSouth(Probe probe) {
        return (probe.getPosition().getX() == 0 && probe.getPosition().getY() == 0)
                && (probe.getDirection() == Direction.W || probe.getDirection() == Direction.S);
    }

    private boolean isAtLimitOfThePlateauAndDirectionIsEastOrNorth(Probe probe, Limit limit) {
        return (probe.getPosition().getX() == limit.getX() && probe.getPosition().getY() == limit.getY())
            && (probe.getDirection() == Direction.E || probe.getDirection() == Direction.N);
    }

    private boolean isOnYAxisAndDirectionIsWest(Probe probe) {
        return probe.getPosition().getX() == 0 && probe.getPosition().getY() > 0 && probe.getDirection() == Direction.W;
    }

    private boolean isOnXAxisAndDirectionIsSouth(Probe probe) {
        return probe.getPosition().getY() == 0 && probe.getPosition().getX() > 0 && probe.getDirection() == Direction.S;
    }

    private boolean isOnXAxisAndDirectToEast(Probe probe, Limit limit) {
        return probe.getPosition().getX() == limit.getX() && probe.getDirection() == Direction.E;
    }

    private boolean isOnYAxisAndDirectToNorth(Probe probe, Limit limit) {
        return probe.getPosition().getY() ==  limit.getY() && probe.getDirection() == Direction.N;
    }
}
