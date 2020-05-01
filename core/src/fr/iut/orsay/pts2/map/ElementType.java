package fr.iut.orsay.pts2.map;

import com.badlogic.gdx.files.FileHandle;

import java.util.ArrayList;
import java.util.Arrays;

public class ElementType {
    private ArrayList<FileHandle> texturePath;
    private int type;

    ElementType(int type, FileHandle... texturePath) {
        this.texturePath = new ArrayList<FileHandle>();
        this.type = type;
        this.texturePath.addAll(Arrays.asList(texturePath));
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ArrayList<FileHandle> getTexturePath() {
        return texturePath;
    }

}
