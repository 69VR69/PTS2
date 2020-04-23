package fr.iut.orsay.pts2.Managers;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

import fr.iut.orsay.pts2.States.GameState;

public class GameStateManager {

    private Stack<GameState> gameState;

    public GameStateManager()
    {
        this.gameState = new Stack<GameState>();

    }

    public void push(GameState gamestate)
    {
        this.gameState.push(gamestate);
    }

    public void set(GameState gamestate)
    {
        this.gameState.pop().dispose();
        this.gameState.push(gamestate);
    }

    public void update(float dt)
    {
        this.gameState.peek().update(dt);

    }

    public void render(SpriteBatch sb)
    {
        this.gameState.peek().render(sb);

    }
}

