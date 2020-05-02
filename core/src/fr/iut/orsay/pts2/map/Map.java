package fr.iut.orsay.pts2.map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.Array;

import fr.iut.orsay.pts2.MAP_CONFIG;

class Map
    {
        private TiledMap map;
    
        Map()
            {
                GenerateMap mapMatrix = new GenerateMap();
                Array<Texture> texture = new Array<>();
    
                for (Element[] el : mapMatrix.getMapContent())
                    for (Element e : el)
                        texture.add(new Texture(e.getElementType().getTexturePath().get(MAP_CONFIG.RND.nextInt(e.getElementType().getTexturePath().size()))));
                map = new TiledMap();
                TiledMapTileLayer mapLayer = new TiledMapTileLayer(mapMatrix.getWidth(), mapMatrix.getHeight(), 16, 16);
                map.getLayers().add(mapLayer);
                map.setOwnedResources(texture);
                
            }
    
        TiledMap getMap()
            {
                return map;
            }
    }
