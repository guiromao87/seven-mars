package com.guiromao.sevenmars.model.dto;

import com.guiromao.sevenmars.model.Limit;

public class LimitPlateauDto {
    private int x;
    private int y;


    public LimitPlateauDto(Limit limit) {
        this.x = limit.getX();
        this.y = limit.getY();
    }

    public int getX() { return x; }

    public int getY() { return y; }
}
