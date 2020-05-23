package fr.iut.orsay.pts2.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Map;

import fr.iut.orsay.pts2.config.CONSTANT;
import fr.iut.orsay.pts2.config.MAP_CONFIG;
import fr.iut.orsay.pts2.config.Tools;
import fr.iut.orsay.pts2.gameManager.GameState;
import fr.iut.orsay.pts2.gameManager.GameStateManager;
import fr.iut.orsay.pts2.hud.HUD;


public class MapRender extends GameState
    {
        private SpriteBatch batchUnit;
        private MatrixGenerator mapMatrix;
        private HUD hud;
        private HashMap<Element, Texture> map;
        private SpriteBatch hudBatch;
        
        public MapRender(GameStateManager gsm)
            {
                super(gsm);
                this.hud = new HUD(gsm);
                this.hudBatch = new SpriteBatch();
                this.batchUnit=new SpriteBatch();
                this.mapMatrix = new MatrixGenerator();
                this.map = new HashMap<>();
                this.setupMatrixTexture();
            }
    
        @Override protected void handleInput()
            {
                hud.handleInput();
            }
    
        @Override public void update(float dt)
            {
                hud.update(dt);
            }
    
        @Override public void render(SpriteBatch batch)
            {
                batch.begin();
                for (Map.Entry<Element, Texture> entry : map.entrySet())
                    {
                        Element e = entry.getKey();
                        Texture t = entry.getValue();
                        batch.draw(t, e.getLocationW() * t.getWidth(), e.getLocationH() * t.getHeight());
                    }
                batch.end();
                hud.render(hudBatch);
            }
    
        @Override public void resize(int width, int height)
            {
            
            }
    
        @Override public void dispose()
            {
                hud.dispose();
            }
    
        private void setupMatrixTexture()
            {
                for (Element[] el : mapMatrix.getMapContent())
                    for (Element e : el)
                        {
                            int textureIndex = MAP_CONFIG.RND.nextInt(e.getElementType().getTexturePath().size());
                            Texture t = Tools.resize(e.getElementType().getTexturePath().get(textureIndex), CONSTANT.textureWidth, CONSTANT.textureHeight);
                            map.put(e, t);
                        }
            }
        
        
    }
