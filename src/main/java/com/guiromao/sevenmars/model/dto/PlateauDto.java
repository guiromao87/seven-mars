package com.guiromao.sevenmars.model.dto;

import com.guiromao.sevenmars.model.Plateau;

public class PlateauDto {
    private int x;
    private int y;


    public PlateauDto(Plateau plateau) {
        this.x = plateau.getLimit().getX();
        this.y = plateau.getLimit().getY();
    }

    public int getX() { return x; }

    public int getY() { return y; }
}
