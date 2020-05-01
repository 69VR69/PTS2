package fr.iut.orsay.pts2.map;

import java.util.ArrayList;
import java.util.Arrays;

public class ElementType {
      private ArrayList<String> texturePath;
      private int type;

      ElementType(int type,String... texturePath){
          this.texturePath = new ArrayList<String>();
          this.type = type;
          this.texturePath.addAll(Arrays.asList(texturePath));
      }
}
