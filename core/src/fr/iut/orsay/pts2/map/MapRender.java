package fr.iut.orsay.pts2.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fr.iut.orsay.pts2.config.CONSTANT;
import fr.iut.orsay.pts2.config.MAP_CONFIG;
import fr.iut.orsay.pts2.config.Tools;
import fr.iut.orsay.pts2.gameManager.GameState;
import fr.iut.orsay.pts2.gameManager.GameStateManager;
import fr.iut.orsay.pts2.hud.HUD;
import fr.iut.orsay.pts2.interfaces.ressource.Cost;
import fr.iut.orsay.pts2.unit.Archer;
import fr.iut.orsay.pts2.unit.Unit;

//import fr.iut.orsay.pts2.InputProcessor;


public class MapRender extends GameState implements InputProcessor
    {
        
        private HashMap<Object, ArrayList<Cost>> productionList;
        //private Music music = Gdx.audio.newMusic(Gdx.files.internal(""));
        private Unit unit;
        private SpriteBatch batchUnit;
        private MatrixGenerator mapMatrix;
        private HUD hud;
        private HashMap<Element, Texture> map;
        private SpriteBatch hudBatch;
        fr.iut.orsay.pts2.InputProcessor ip = new fr.iut.orsay.pts2.InputProcessor();
        
        
        public MapRender(GameStateManager gsm)
            {
                super(gsm);
                
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
                Gdx.input.setInputProcessor(ip);
                
            }
        
        @Override protected void handleInput()
            {
                // if () //input j'ai une variable
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
        
        @Override public void render(final SpriteBatch batch)
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
                        Object e = ee.getKey();
                        //ArrayList<Cost> cost = ee.getValue();
                        if (o instanceof Unit)
                            {
                                if (((Unit) o).isOnBoard())
                                    {
                                        unit = (Unit) o;
                                        float resizeRatio = 0.9f;
                                        final Texture texture = Tools.resize(unit.texturize(), (int) (CONSTANT.textureWidth * resizeRatio), (int) (CONSTANT.textureHeight * resizeRatio));
                                        final int deltaWidth = (int) (CONSTANT.textureWidth - CONSTANT.textureWidth * resizeRatio) / 2;
                                        final int deltaHeight = (int) (CONSTANT.textureHeight - CONSTANT.textureHeight * resizeRatio) / 2;
                                        batchUnit.draw(texture, (unit.getPosX() * CONSTANT.textureWidth + deltaWidth), (unit.getPosY() * CONSTANT.textureHeight + deltaHeight));
                                        Gdx.input.setInputProcessor(new InputProcessor()
                                            {
                                                @Override public boolean keyDown(int keycode)
                                                    {
                                                        return false;
                                                    }
                                                
                                                @Override public boolean keyUp(int keycode)
                                                    {
                                                        return false;
                                                    }
                                                
                                                @Override public boolean keyTyped(char character)
                                                    {
                                                        return false;
                                                    }
                                                
                                                @Override public boolean touchDown(int screenX, int screenY, int pointer, int button)
                                                    {
                                                        float graphicsY = (CONSTANT.screenHeight - screenY);
                                                        int elementX = 0, elementY = 0;
                                                        int startX = 0, endX = CONSTANT.textureWidth;
                                                        int startY = 0, endY = CONSTANT.textureHeight;
                                                        boolean targetElement = false;
                                                        
                                                        while (!targetElement)
                                                            {
                                                                
                                                                
                                                                if (startX <= screenX && screenX > endX)
                                                                    {
                                                                        elementX += 1;
                                                                        startX += CONSTANT.textureWidth;
                                                                        endX += CONSTANT.textureWidth;
                                                                    }
                                                                if (startY <= graphicsY && graphicsY > endY)
                                                                    {
                                                                        elementY += 1;
                                                                        startY += CONSTANT.textureHeight;
                                                                        endY += CONSTANT.textureHeight;
                                                                    }
                                                                if (screenX >= startX && screenX <= endX && graphicsY >= startY && graphicsY <= endY)
                                                                    {
                                                                        targetElement = true;
                                                                    }
                                                            }
                                                        
                                                        unit.setPosX(elementX);
                                                        unit.setPosY(elementY);
                                                        unit.move(unit.getPosX(), unit.getPosY());
                                                        return true;
                                                    }
                                                
                                                @Override public boolean touchUp(int screenX, int screenY, int pointer, int button)
                                                    {
                                                        return false;
                                                    }
                                                
                                                @Override public boolean touchDragged(int screenX, int screenY, int pointer)
                                                    {
                                                        return false;
                                                    }
                                                
                                                @Override public boolean mouseMoved(int screenX, int screenY)
                                                    {
                                                        return false;
                                                    }
                                                
                                                @Override public boolean scrolled(int amount)
                                                    {
                                                        return false;
                                                    }
                                            });
                                    }
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
        
        
        @Override public boolean keyDown(int keycode)
            {
                return false;
            }
        
        @Override public boolean keyUp(int keycode)
            {
                return false;
            }
        
        @Override public boolean keyTyped(char character)
            {
                return false;
            }
        
        @Override public boolean touchDown(int screenX, int screenY, int pointer, int button)
            {
                
                return false;
            }
        
        
        @Override public boolean touchUp(int screenX, int screenY, int pointer, int button)
            {
                return false;
            }
        
        @Override public boolean touchDragged(int screenX, int screenY, int pointer)
            {
                return false;
            }
        
        @Override public boolean mouseMoved(int screenX, int screenY)
            {
                return false;
            }
        
        @Override public boolean scrolled(int amount)
            {
                return false;
            }
    }
