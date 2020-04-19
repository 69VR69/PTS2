package fr.iut.orsay.pts2.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import fr.iut.orsay.pts2.GameLauncher;
import fr.iut.orsay.pts2.Util.Constants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Constants.WINDOW_WIDTH;
		config.height = Constants.WINDOW_HEIGHT;
		config.title = Constants.GAME_TITLE;
		new LwjglApplication(new GameLauncher(), config);
	}
}
