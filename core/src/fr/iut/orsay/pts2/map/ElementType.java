package fr.iut.orsay.pts2.map;

import com.badlogic.gdx.files.FileHandle;

import java.util.ArrayList;
import java.util.Arrays;

public class ElementType
    {
        private ArrayList<FileHandle> texturePath;
        private int type;
        private int percent;
        
        public ElementType(int type, int percent, FileHandle... texturePath)
            {
                this.texturePath = new ArrayList<>();
                this.type = type;
                this.percent = percent;
                this.texturePath.addAll(Arrays.asList(texturePath));
            }
        
        ArrayList<FileHandle> getTexturePath()
            {
                return texturePath;
            }
    
        public int getType()
            {
                return type;
            }
    
        public int getPercent()
            {
                return percent;
            }
        
    }
