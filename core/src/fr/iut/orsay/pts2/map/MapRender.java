package fr.iut.orsay.pts2.map;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MapRender extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;

    @Override
    public void create(){
        batch = new SpriteBatch();
    }
    public void render(){
        Gdx.gl.glClearColor(1,0,0,0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.end();
    }
    public void dispose(){
        batch.dispose();
    }

}
