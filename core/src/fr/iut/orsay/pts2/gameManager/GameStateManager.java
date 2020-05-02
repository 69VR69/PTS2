package fr.iut.orsay.pts2.gameManager;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager
    {
        private Stack<GameState> gameStates;
        
        public GameStateManager()
            {
                this.gameStates = new Stack<>();
            }
        
        public void push(GameState gameState)
            {
                this.gameStates.push(gameState);
            }
        
        public void set(GameState gameState)
            {
                this.gameStates.pop().dispose();
                this.gameStates.push(gameState);
            }
        
        public void update(float dt)
            {
                this.gameStates.peek().update(dt);
            }
        
        public void render(SpriteBatch batch)
            {
                this.gameStates.peek().render(batch);
            }
    }
