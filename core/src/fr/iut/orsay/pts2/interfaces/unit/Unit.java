package fr.iut.orsay.pts2.interfaces.unit;

import com.badlogic.gdx.Gdx;

import fr.iut.orsay.pts2.interfaces.Fighteable;
import fr.iut.orsay.pts2.interfaces.Moveable;
import fr.iut.orsay.pts2.interfaces.Upgradable;

public abstract class Unit implements Fighteable, Moveable, Upgradable {

    @Override
    public boolean canAttack() {
        return false;
    }

    @Override
    public void attack(Object o) {

    }

    @Override
    public int calculDamage(int damage, Object o) {
        return 0;
    }

    @Override
    public void upModification(int upValue, Object o) {

    }

    @Override
    public void downModification(int downValue, Object o) {

    }

    @Override
    public boolean move(int x, int y) {
        boolean hudMove = true; //TODO: replace by button "Move"
        //TODO: faire array des tous les buildings et troupes et parcourir les arrays pour comparer les positions
        if (hudMove && !this.occupied(Gdx.input.getX(), Gdx.input.getY()))
            {
                this.setPosX(posX);
                this.setPosY(posY);
            }
        return false;
    }

    @Override
    public void addForbiddenZone(Object... o) {

    }

    @Override
    public void removeForbiddenZone(Object... o) {

    }

    @Override
    public boolean addToBoard(int posX, int posY, int weight, float depressionRate) {
        return false;
    }

    @Override
    public boolean changePosition(int posX, int posY) {
        return false;
    }

    @Override
    public boolean swapPosition(Object o1, Object o2) {
        return false;
    }

    @Override
    public boolean removeFromBoard() {
        return false;
    }

    @Override
    public void upDepressionRate(float upRate) {

    }

    @Override
    public void downDepressionRate(float downRate) {

    }

    @Override
    public void upWeight(int upValue) {

    }

    @Override
    public void downWeight(int downValue) {

    }

    @Override
    public void upLevel(int nbLevel) {

    }

    @Override
    public void downLevel(int nbLevel) {

    }

    @Override
    public void addExperiencePoint(int point) {

    }

    @Override
    public void removeExperiencePoint(int point) {

    }
}
