package fr.iut.orsay.pts2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.iut.orsay.pts2.gameManager.GameStateManager;
import fr.iut.orsay.pts2.map.Map;

public class GameLauncher extends ApplicationAdapter
    {
        private GameStateManager gsm;
        private SpriteBatch batch;
        
        @Override public void create()
            {
                this.gsm = new GameStateManager();
                this.batch = new SpriteBatch();
                this.gsm.push(new Map(this.gsm));
            }
        
        @Override public void render()
            {
                this.gsm.update(Gdx.graphics.getDeltaTime());
                this.gsm.render(this.batch);
            }
        
        @Override public void dispose()
            {
                this.batch.dispose();
            }
    }
