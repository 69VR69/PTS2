package fr.iut.orsay.pts2.gameManager;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameState
    {
        protected OrthographicCamera cam;
        protected GameStateManager gsm;
        
        protected GameState(GameStateManager gsm)
            {
                this.cam = new OrthographicCamera();
                this.gsm = gsm;
            }
        
        protected abstract void handleInput();
        
        public abstract void update(float dt);
        
        public abstract void render(SpriteBatch batch);
    
        public abstract void resize(int width, int height);
        
        public abstract void dispose();
    }
