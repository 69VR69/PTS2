package fr.iut.orsay.pts2.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

import fr.iut.orsay.pts2.MAP_CONFIG;
import fr.iut.orsay.pts2.gameManager.GameState;
import fr.iut.orsay.pts2.gameManager.GameStateManager;

public class Map extends GameState
    {
        private SpriteBatch batch;
        private ArrayList<Texture> texture;
        private int[][] positionTexture;
        private int counter;
        private int secondCounter;
        
        public Map(GameStateManager gsm)
            {
                super(gsm);
                batch = new SpriteBatch();
                GenerateMap map = new GenerateMap();
                texture = new ArrayList<>();
                positionTexture = new int[map.getTotalAdded()][2];
                for (Element[] el : map.getMapContent())
                    {
                        for (Element e : el)
                            {
                                int randomNumber = MAP_CONFIG.RND.nextInt(e.getElementType().getTexturePath().size());
                                texture.add(new Texture(e.getElementType().getTexturePath().get(randomNumber)));
                                positionTexture[counter][0] = e.getLocationW();
                                positionTexture[counter][1] = e.getLocationH();
                                counter++;
                            }
                    }
            }
        
        @Override protected void handleInput()
            {
            
            }
        
        @Override public void update(float dt)
            {
            
            }
        
        @Override public void render(SpriteBatch batch)
            {
                Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                batch.setProjectionMatrix(this.cam.combined);//TODO:textures clignotent + taille + bavures+supperposition
                batch.begin();
                for (Texture t : texture)
                    {
                        batch.draw(t, positionTexture[secondCounter][0], positionTexture[secondCounter][1], 100, 100);
                        secondCounter++;
                    }
                batch.end();
            }
        
        public void dispose()
            {
                batch.dispose();
                for (Texture t : texture)
                    t.dispose();
            }
        
    }
