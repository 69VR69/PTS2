package fr.iut.orsay.pts2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.iut.orsay.pts2.map.MapRender;

public class GameLauncher extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    MapRender mr;

    @Override
    public void create() {
        batch = new SpriteBatch();

        mr = new MapRender();
        mr.create();
        mr.render();
        mr.dispose();
    }

    @Override
    public void render() {

    }

    @Override
    public void dispose() {

    }
}
