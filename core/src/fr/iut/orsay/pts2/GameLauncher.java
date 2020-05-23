package fr.iut.orsay.pts2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;

import fr.iut.orsay.pts2.gameManager.GameStateManager;
import fr.iut.orsay.pts2.map.MapRender;

public class GameLauncher extends Game
    {
        private GameStateManager gsm;
        private SpriteBatch batch;
        private com.badlogic.gdx.scenes.scene2d.ui.Label fps;
    
        public GameLauncher()
            {
            
            }
        
        @Override public void create()
            {
                this.gsm = new GameStateManager();
                this.batch = new SpriteBatch();

                fps = new Label("fps:", new Label.LabelStyle(new BitmapFont(), Color.LIME));
                fps.setAlignment(Align.topLeft);
                
                this.gsm.push(new MapRender(this.gsm));
            }
    
        @Override public void resize(int width, int height)
            {
                super.resize(width, height);
                this.gsm.resize(width, height);
            }
        
        @Override public void render()
            {
                Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    
                fps.setText("fps: " + Gdx.graphics.getFramesPerSecond());
                
                this.gsm.update(Gdx.graphics.getDeltaTime());
                this.gsm.render(this.batch);
            }
    
        @Override public void dispose()
            {
                this.batch.dispose();
            }
    }
