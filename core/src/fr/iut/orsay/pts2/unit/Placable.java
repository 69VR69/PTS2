package fr.iut.orsay.pts2.unit;

public interface Placable {
    int posX=0, posY=0, weight=10;
    float depressionRate=0.2f;

    boolean move(int x, int y);

}
