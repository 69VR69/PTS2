package fr.iut.orsay.pts2.deplacement;

import com.badlogic.gdx.Gdx;

import static com.badlogic.gdx.Gdx.graphics;

public class UpdateMove {
    private int x;//Ou se trouve l'unitée en X
    private int y;// OU se trouve l'unitée en Y
    private int xDestination; //ou l'on veux se déplacer en x
    private int yDestination; //ou l'on veut se déplacer en y
    private int speed; //vitesse de l'initée

    UpdateMove() {

    }
    /*Getters and setters*/

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /*Functions*/
    public void updateMove() {
        if (xDestination > x) {
            setX(getX() + (int) graphics.getDeltaTime() * speed);
        }
        if (xDestination < x) {
            setX(getX() - (int) graphics.getDeltaTime() * speed);
        }
        if (Math.abs(xDestination - x) < Gdx.graphics.getDeltaTime() * speed){
            if (xDestination > y) {
                setX(getY() + (int) graphics.getDeltaTime() * speed);
            }
            if (xDestination < y) {
                setX(getY() - (int) graphics.getDeltaTime() * speed);
            }
        }
    }
}
