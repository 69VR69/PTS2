package fr.iut.orsay.pts2.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Map;

import fr.iut.orsay.pts2.config.MAP_CONFIG;
import fr.iut.orsay.pts2.gameManager.GameState;
import fr.iut.orsay.pts2.gameManager.GameStateManager;

public class MapRender extends GameState
    {
    
        private MatrixGenerator mapMatrix;
        private HashMap<Element, Texture> map;
        private int screenwidth = Gdx.graphics.getWidth();
        private int screenHeight = Gdx.graphics.getHeight();
        private int textureWidth = screenwidth / MAP_CONFIG.WIDTH, textureHeight = screenHeight / MAP_CONFIG.HEIGHT;
    
        public MapRender(GameStateManager gsm)
            {
                super(gsm);
                this.mapMatrix = new MatrixGenerator();
                map = new HashMap<>();
                
                for (Element[] el : mapMatrix.getMapContent())
                    for (Element e : el)
                        {
                            int textureIndex = MAP_CONFIG.RND.nextInt(e.getElementType().getTexturePath().size());
                            Texture t = this.resize(e.getElementType().getTexturePath().get(textureIndex));
                            map.put(e, t);
                        }
                System.out.println("screenSize: (" + this.screenwidth + "," + this.screenHeight + ")");
            }
    
        @Override protected void handleInput()
            {
            
            }
    
        @Override public void update(float dt)
            {
    
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
            }
    
        @Override public void dispose()
            {
            
            }
    
        private Texture resize(FileHandle fileHandle)
            {
                Pixmap pixmap200 = new Pixmap(fileHandle);
                Pixmap pixmap100 = new Pixmap(textureWidth, textureHeight, pixmap200.getFormat());
                pixmap100.drawPixmap(pixmap200, 0, 0, pixmap200.getWidth(), pixmap200.getHeight(), 0, 0, pixmap100.getWidth(), pixmap100.getHeight());
                Texture texture = new Texture(pixmap100);
                pixmap200.dispose();
                pixmap100.dispose();
                return texture;
            }
    }
