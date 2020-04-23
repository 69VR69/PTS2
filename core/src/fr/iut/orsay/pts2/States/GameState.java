package fr.iut.orsay.pts2.States;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.iut.orsay.pts2.Managers.GameStateManager;

public abstract class GameState {

    protected OrthographicCamera cam;
    protected GameStateManager gsm;

    public GameState(GameStateManager gsm)
    {
        this.cam = new OrthographicCamera();
        this.gsm = gsm;
    }

    protected abstract void handleInput();
    public abstract void update(float dt);

    public abstract void update(SpriteBatch batch, float input_x, float input_y);

    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
