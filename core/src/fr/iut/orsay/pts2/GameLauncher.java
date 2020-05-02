package fr.iut.orsay.pts2;

import com.badlogic.gdx.Game;

import fr.iut.orsay.pts2.map.GameScreen;

public class GameLauncher extends Game
    {
        private GameScreen gameScreen;
    
        @Override public void create()
            {
                gameScreen = new GameScreen();
                setScreen(gameScreen);
            }
    
        @Override public void dispose()
            {
                super.dispose();
                gameScreen.dispose();
            }
    }
