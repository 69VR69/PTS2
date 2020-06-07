package fr.iut.orsay.pts2.States;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.iut.orsay.pts2.Screens.PressScreen;

public class Civ extends Game {
    public SpriteBatch batch;

    @Override
    public void create() {
    batch = new SpriteBatch();
    setScreen(new PressScreen(this));
    }
    @Override
    public void render () {
        super.render();
    }


}
