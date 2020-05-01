package fr.iut.orsay.pts2.map;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

import fr.iut.orsay.pts2.CONSTANT;

public class MapRender {
    SpriteBatch batch;
    OrthographicCamera cam;
    ArrayList<Texture> texture;
    private GenerateMap map;
    private int[][] positionTexture;
    private int counter;
    private int secondCounter;

    public MapRender() {
    }

    public void create() {
        batch = new SpriteBatch();
        this.map = new GenerateMap();
        texture = new ArrayList<>();
        this.cam = new OrthographicCamera();
        this.cam.setToOrtho(false, 800, 400);
        positionTexture = new int[this.map.getTotalAdded()][2];
        for (Element[] el : map.getMapContent()) {
            for (Element e : el) {
                int randomNumber = CONSTANT.RND.nextInt(e.getElementType().getTexturePath().size());
                texture.add(new Texture(e.getElementType().getTexturePath().get(randomNumber)));
                positionTexture[counter][0] = e.getLocationW();
                positionTexture[counter][1] = e.getLocationH();
                counter++;
            }
        }

    }

    public void render() {
        batch.setProjectionMatrix(this.cam.combined);//TODO:textures clignotent + taille + bavures+supperposition
        batch.begin();
        for (Texture t : texture) {
            batch.draw(t, positionTexture[secondCounter][0], positionTexture[secondCounter][1], 100, 100);
            secondCounter++;
        }
        batch.end();
    }

    public void dispose() {
        batch.dispose();
    }


}
