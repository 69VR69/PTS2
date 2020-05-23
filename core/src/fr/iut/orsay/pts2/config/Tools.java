package fr.iut.orsay.pts2.config;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;

import java.util.ArrayList;
import java.util.Arrays;

import fr.iut.orsay.pts2.Civilization;

public abstract class Tools
    {
        public static boolean getLuck(double coef)
            {
                if (coef < 0 || coef > 100)
                    try
                        {
                            throw new Exception("coef is out of bounds");
                        }
                    catch (Exception e)
                        {
                            e.printStackTrace();
                        }
    
                double cursor = 100 * CONSTANT.RND.nextDouble();
                return (cursor >= 0 && cursor <= coef);
            }
    
        public static Object chooseBetween(Object... object)
            {
                ArrayList<Object> values = new ArrayList<>(Arrays.asList(object));
                return values.get(CONSTANT.RND.nextInt(values.size()));
            }
    
        public static double getDistance(Civilization civ1, Civilization civ2)
            {
                return Math.sqrt((civ2.getPosX() - civ1.getPosX()) ^ 2 + (civ2.getPosY() - civ1.getPosY()) ^ 2);
            }
    
        public static Texture resize(FileHandle fileHandle, int resizeWidth, int resizeHeight)
            {
                Pixmap pixmap200 = new Pixmap(fileHandle);
                Pixmap pixmap100 = new Pixmap(resizeWidth, resizeHeight, pixmap200.getFormat());
                pixmap100.drawPixmap(pixmap200, 0, 0, pixmap200.getWidth(), pixmap200.getHeight(), 0, 0, pixmap100.getWidth(), pixmap100.getHeight());
                Texture texture = new Texture(pixmap100);
                pixmap200.dispose();
                pixmap100.dispose();
                return texture;
            }
    
        public static Texture resize(Texture texture, int resizeWidth, int resizeHeight)
            {
                TextureData textureData = texture.getTextureData();
                if (!textureData.isPrepared())
                    textureData.prepare();
                Pixmap pixmap200 = textureData.consumePixmap();
                Pixmap pixmap100 = new Pixmap(resizeWidth, resizeHeight, pixmap200.getFormat());
                pixmap100.drawPixmap(pixmap200, 0, 0, pixmap200.getWidth(), pixmap200.getHeight(), 0, 0, pixmap100.getWidth(), pixmap100.getHeight());
                Texture resizedTexture = new Texture(pixmap100);
                pixmap200.dispose();
                pixmap100.dispose();
                return resizedTexture;
            }
    }