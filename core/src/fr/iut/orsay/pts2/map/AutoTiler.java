package fr.iut.orsay.pts2.map;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

public class AutoTiler
    {
        private static final String TAG = "AutoTiler";
        private static final byte MATCH_ANY = 127;
        // Each tile-set row should contain two main terrain tiles and 14 transition tiles
        // (4 bit encoded tile indices: 0 - 15)
        private static final int TERRAINS_PER_ROW = 2;
        private static final int TILES_PER_TERRAIN = 16;
        private final int mapWidth;
        private final int mapHeight;
        private final Random random;
        private int tileWidth;
        private int tileHeight;
        private int maxTransitions;
        private Texture tilesTexture;
        private TiledMapTileSet tileSet;
        private TiledMap map;
        private TiledMapTileLayer mapLayer;
        
        public AutoTiler(final int mapWidth, final int mapHeight, final FileHandle tilesetConfigFile)
            {
                this.mapWidth = mapWidth;
                this.mapHeight = mapHeight;
                this.random = new Random();
                
                try
                    {
                        initMap();
                    }
                catch (Exception e)
                    {
                        // Cleanup on error
                        tilesTexture.dispose();
                        throw e;
                    }
            }
        
        public int getTileWidth()
            {
                return tileWidth;
            }
        
        public int getTileHeight()
            {
                return tileHeight;
            }
        
        
        /**
         * Create a new map with an empty layer
         */
        private void initMap()
            {
                // Split into tiles
                //tilesTexture;
                
                // Create an empty map
                map = new TiledMap();
                mapLayer = new TiledMapTileLayer(mapWidth, mapHeight, tileWidth, tileHeight);
                map.getLayers().add(mapLayer);
                final Array<Texture> textures = Array.with(tilesTexture);
                map.setOwnedResources(textures);
            }
    }
