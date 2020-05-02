package fr.iut.orsay.pts2.gameManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import fr.iut.orsay.pts2.map.MapMatrix;

public class GameScreen extends ScreenAdapter
    {
        //TODO: aucun affichage, test du game screen à faire + debug
        
        private static final int MAP_WIDTH = 16;
        private static final int MAP_HEIGHT = 12;
        private static final float PROMPT_FADE_IN = 2f;
        private static final float PROMPT_FADE_OUT = 4f;
    
        private SpriteBatch batch;
        private MapMatrix mapMatrix;
        private OrthographicCamera camera;
        private Viewport viewport;
        private ScreenViewport screenViewport;
        private OrthogonalTiledMapRenderer renderer;
        private float elapsedTime = 0;
        
        @Override public void show()
            {
                super.show();
                batch = new SpriteBatch();
                
                // Setup camera
                camera = new OrthographicCamera();
                viewport = new FitViewport(MAP_WIDTH, MAP_HEIGHT, camera);
                
                // Setup GUI camera
                OrthographicCamera guiCam = new OrthographicCamera();
                screenViewport = new ScreenViewport(guiCam);
                guiCam.setToOrtho(false);
                
                // Setup map renderer
                this.mapMatrix = new MapMatrix();
                final float unitScale = 1f / Math.max(16, 16);
                renderer = new OrthogonalTiledMapRenderer(mapMatrix.getMap(), unitScale);
            }
        
        @Override public void resize(int width, int height)
            {
                super.resize(width, height);
                viewport.update(width, height);
                screenViewport.update(width, height);
            }
        
        @Override public void render(float delta)
            {
                batch.begin();
                super.render(delta);
                Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
                Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
                
                // Render map
                viewport.apply(true);
                renderer.setView(camera);
                renderer.render();
                
                elapsedTime += delta;
    
                batch.end();
            }
        
        @Override public void dispose()
            {
                super.dispose();
                mapMatrix.getMap().dispose();
                batch.dispose();
            }
    }
