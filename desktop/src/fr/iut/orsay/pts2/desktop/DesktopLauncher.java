package fr.iut.orsay.pts2.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import fr.iut.orsay.pts2.GameLauncher;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Civilisation mobile version";
        config.width = 1024;
        config.height = 768;
        new LwjglApplication(new GameLauncher(), config);
    }
}
