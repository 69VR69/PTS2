package fr.iut.orsay.pts2;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import fr.iut.orsay.pts2.Managers.GameStateManager;

public class GameLauncher extends ApplicationAdapter {

	private GameStateManager gsm;
	private SpriteBatch sb;

	@Override
	public void create () {
		this.gsm = new GameStateManager();
		this.sb = new SpriteBatch();

	}

	@Override
	public void render () {
		this.gsm.update(Gdx.graphics.getDeltaTime());
		this.gsm.render(this.sb);
	}
	
	@Override
	public void dispose () {
		this.sb.dispose();
	}
}
