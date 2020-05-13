package fr.iut.orsay.pts2.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

import fr.iut.orsay.pts2.config.CONSTANT;
import fr.iut.orsay.pts2.config.Tools;
import fr.iut.orsay.pts2.gameManager.GameState;
import fr.iut.orsay.pts2.gameManager.GameStateManager;

public class HUD extends GameState
    {
        private Button btnTest;
        private Texture productionMenu, topBar;
        private boolean productionMenuEnable = true, topBarEnable = true;
        
        public HUD(GameStateManager gsm)
            {
                super(gsm);
                //menu
                this.productionMenu = new Texture(Gdx.files.internal("menu.png"));
                productionMenu = Tools.resize(productionMenu, CONSTANT.screenwidth / 5, CONSTANT.screenHeight - 150);
                //topBar
                this.topBar = new Texture(Gdx.files.internal("topBar.png"));
                topBar = Tools.resize(topBar, CONSTANT.screenwidth, CONSTANT.screenHeight / 10);
                //btn
                this.btnTest = new Button();
            }
        
        @Override public void handleInput()
            {
            
            }
        
        @Override public void update(float dt)
            {
            
            }
        
        @Override public void render(SpriteBatch batch)
            {
                batch.begin();
                if (productionMenuEnable)
                    batch.draw(productionMenu, CONSTANT.screenwidth - productionMenu.getWidth(), CONSTANT.screenHeight - productionMenu.getHeight() - topBar.getHeight());
                if (topBarEnable)
                    batch.draw(topBar, 0, CONSTANT.screenHeight - topBar.getHeight());
                btnTest.draw(batch, 0);
                batch.end();
            }
        
        @Override public void dispose()
            {
                this.productionMenu.dispose();
            }
    }
