package fr.iut.orsay.pts2.hud;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import fr.iut.orsay.pts2.gameManager.GameState;
import fr.iut.orsay.pts2.gameManager.GameStateManager;

public class HUD extends GameState
    {
        private Stage stage;
        private boolean productionMenuEnable = true, topBarEnable = true;
        
        public HUD(GameStateManager gsm)
            {
                super(gsm);
                
            }
        
        @Override public void handleInput()
            {
            
            }
        
        @Override public void update(float dt)
            {
            
            }
        
        @Override public void render(SpriteBatch batch)
            {
            
            }
        
        @Override public void resize(int width, int height)
            {
            
            }
        
        @Override public void dispose()
            {
            }
    }
