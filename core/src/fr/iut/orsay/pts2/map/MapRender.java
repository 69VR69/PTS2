package fr.iut.orsay.pts2.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

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


public class MapRender extends GameState implements InputProcessor
    {
        
        private HashMap<Object, ArrayList<Cost>> productionList;
        private Music music;
        private Timer timer;
        private Unit unit;
        private SpriteBatch batchUnit;
        private MatrixGenerator mapMatrix;
        private HUD hud;
        private HashMap<Element, Texture> map;
        private SpriteBatch hudBatch;
        private fr.iut.orsay.pts2.InputProcessor ip = new fr.iut.orsay.pts2.InputProcessor();
        
        
        public MapRender(GameStateManager gsm)
            {
                super(gsm);
                long start = System.currentTimeMillis();
                this.timer = new Timer();
                this.hud = new HUD(gsm);
                this.hudBatch = new SpriteBatch();
                this.batchUnit = new SpriteBatch();
                this.mapMatrix = new MatrixGenerator();
                this.map = new HashMap<>();
                this.setupMatrixTexture();
                System.err.println(System.currentTimeMillis() - start);
                this.productionList = new HashMap<>();
                ArrayList<Cost> cost = new ArrayList<>();
                cost.add(new Cost());
                productionList.put(new Archer("robin", 0, 0), cost);
                Gdx.input.setInputProcessor(ip);
                this.setupBackgroundMusic("sound/MenuMusic.mp3");
            }
        
        @Override protected void handleInput()
            {
                hud.handleInput();
            }
        
        @Override public void update(float dt)
            {
                music.setOnCompletionListener(new Music.OnCompletionListener()
                    {
                        @Override public void onCompletion(final Music music)
                            {
                                music.stop();
                                timer.scheduleTask(new Timer.Task()
                                    {
                                        @Override public void run()
                                            {
                                                music.play();
                                            }
                                    }, 20);
                            }
                    });
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
                for (Map.Entry<Object, ArrayList<Cost>> ee : this.productionList.entrySet())
                    {
                        Object o = ee.getKey();
                        if (o instanceof Unit)
                            if (((Unit) o).isOnBoard())
                                {
                                    unit = (Unit) o;
                                    unit.setBatchUnit(batchUnit);
                                    unit.move(unit.getPosX(), unit.getPosY());
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
                                                                    elementX++;
                                                                    startX += CONSTANT.textureWidth;
                                                                    endX += CONSTANT.textureWidth;
                                                                }
                                                            if (startY <= graphicsY && graphicsY > endY)
                                                                {
                                                                    elementY++;
                                                                    startY += CONSTANT.textureHeight;
                                                                    endY += CONSTANT.textureHeight;
                                                                }
                                                            if (screenX >= startX && screenX <= endX && graphicsY >= startY && graphicsY <= endY)
                                                                {
                                                                    targetElement = true;
                                                                }
                                                        }
                                                    unit.setxDestination(elementX);
                                                    unit.setyDestination(elementY);
                                                    unit.move();
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
                
                //Hud
                hud.render(hudBatch);
            }
        
        
        @Override public void resize(int width, int height)
            {
            
            }
        
        @Override public void dispose()
            {
                music.dispose();
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
        
        private void setupBackgroundMusic(String musicPath)
            {
                music = Gdx.audio.newMusic(Gdx.files.internal(musicPath));
                //https://github.com/libgdx/libgdx/wiki/Streaming-music
                music.setVolume(0.2f);
                music.play();
            }
    }
