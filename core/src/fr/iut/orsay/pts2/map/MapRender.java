package fr.iut.orsay.pts2.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fr.iut.orsay.pts2.InputProcessor;
import fr.iut.orsay.pts2.config.CONSTANT;
import fr.iut.orsay.pts2.config.MAP_CONFIG;
import fr.iut.orsay.pts2.config.Tools;
import fr.iut.orsay.pts2.gameManager.GameState;
import fr.iut.orsay.pts2.gameManager.GameStateManager;
import fr.iut.orsay.pts2.hud.HUD;
import fr.iut.orsay.pts2.interfaces.ressource.Cost;
import fr.iut.orsay.pts2.unit.Archer;
import fr.iut.orsay.pts2.unit.Unit;


public class MapRender extends GameState
    {
        private HashMap<Object, ArrayList<Cost>> productionList;
        private SpriteBatch batchUnit;
        private MatrixGenerator mapMatrix;
        private HUD hud;
        private HashMap<Element, Texture> map;
        private SpriteBatch hudBatch;
        private InputProcessor input;
        
        public MapRender(GameStateManager gsm)
            {
                super(gsm);
                input = new InputProcessor();
                this.hud = new HUD(gsm);
                this.hudBatch = new SpriteBatch();
                this.batchUnit = new SpriteBatch();
                this.mapMatrix = new MatrixGenerator();
                this.map = new HashMap<>();
                this.setupMatrixTexture();
                this.productionList = new HashMap<>();
                ArrayList<Cost> cost = new ArrayList<>();
                cost.add(new Cost());
                productionList.put(new Archer("robin", 2, 1), cost);
            }
    
        @Override protected void handleInput()
            {
                if () //input j'ai une variable
                    hud.handleInput();
            }
    
        @Override public void update(float dt)
            {
                for (Map.Entry<Object, ArrayList<Cost>> ee : this.productionList.entrySet())
                    {
                        Object o = ee.getKey();
                        if (o instanceof Unit)
                            if (((Unit) o).isMoving())
                                {
                                    ((Unit) o).move(0, 3);
                                }
                    }
                hud.update(dt);
            }
    
        @Override public void render(SpriteBatch batch)
            {
                //Map
                batch.begin();
                for (Map.Entry<Element, Texture> entry : map.entrySet())
                    {
                        Element e = entry.getKey();
                        Texture t = entry.getValue();
                        batch.draw(t, e.getLocationW() * t.getWidth(), e.getLocationH() * t.getHeight());
                    }
                batch.end();
    
                //Unit
                batchUnit.begin();
                for (Map.Entry<Object, ArrayList<Cost>> ee : this.productionList.entrySet())
                    {
                        Object o = ee.getKey();
                        //ArrayList<Cost> cost = ee.getValue();
                        if (o instanceof Unit)
                            if (((Unit) o).isOnBoard())
                                {
                                    float resizeRatio = 0.9f;
                                    Texture texture = Tools.resize(((Unit) o).texturize(), (int) (CONSTANT.textureWidth * resizeRatio), (int) (CONSTANT.textureHeight * resizeRatio));
                                    int deltaWidth = (int) (CONSTANT.textureWidth - CONSTANT.textureWidth * resizeRatio) / 2;
                                    int deltaHeight = (int) (CONSTANT.textureHeight - CONSTANT.textureHeight * resizeRatio) / 2;
                                    batchUnit.draw(texture, ((Unit) o).getPosX() * CONSTANT.textureWidth + deltaWidth, ((Unit) o).getPosY() * CONSTANT.textureHeight + deltaHeight);
                                }
                    }
                batchUnit.end();
    
                //Hud
                hud.render(hudBatch);
            }
    
        @Override public void resize(int width, int height)
            {
            
            }
    
        @Override public void dispose()
            {
                batchUnit.dispose();
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
