package fr.iut.orsay.pts2.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen extends ScreenAdapter
    {
        
        private static final int MAP_WIDTH = 16;
        private static final int MAP_HEIGHT = 12;
        private static final float PROMPT_FADE_IN = 2f;
        private static final float PROMPT_FADE_OUT = 4f;
        
        private TiledMap map;
        private OrthographicCamera camera;
        private OrthographicCamera guiCam;
        private Viewport viewport;
        private ScreenViewport screenViewport;
        private OrthogonalTiledMapRenderer renderer;
        private AutoTiler autoTiler;
        
        private SpriteBatch batch;
        private float elapsedTime = 0;
        
        @Override public void show()
            {
                super.show();
                
                // Setup camera
                camera = new OrthographicCamera();
                viewport = new FitViewport(MAP_WIDTH, MAP_HEIGHT, camera);
                
                // Setup GUI camera
                guiCam = new OrthographicCamera();
                screenViewport = new ScreenViewport(guiCam);
                guiCam.setToOrtho(false);
                
                // Setup map renderer
                final float unitScale = 1f / Math.max(autoTiler.getTileWidth(), autoTiler.getTileHeight());
                renderer = new OrthogonalTiledMapRenderer(map, unitScale);
            }
        
        @Override public void resize(int width, int height)
            {
                super.resize(width, height);
                viewport.update(width, height);
                screenViewport.update(width, height);
            }
        
        @Override public void render(float delta)
            {
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
                map.dispose();
                batch.dispose();
            }
    }
