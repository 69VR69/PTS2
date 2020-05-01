package fr.iut.orsay.pts2.map;

import java.lang.reflect.Array;
import java.util.ArrayList;

import fr.iut.orsay.pts2.CONSTANT;

public class Element implements Cloneable {
    private int type = 0;
    private ElementType elementType;

    private int locationW;
    private int locationH;
    private int percent ;


    /*Constructor*/
    Element(ElementType elementType) {
        this.elementType = elementType;
    }

    /*Getters and setters*/
    private Element setType(int type) {
        this.type = type;
        return this;
    }

    public int getType() {
        return this.type;
    }

    public void setLocation(int locationW, int locationH) {
        this.locationH = locationH;
        this.locationW = locationW;
    }

    public int getLocationW() {
        return this.locationW;
    }

    public int getLocationH() {
        return this.locationH;
    }

    private Element setPercent(int percent) {
        this.percent = percent;
        return this;
    }

    public int getPercent() {
        return this.percent;
    }


    /*functions*/
    public Element clone()  {
        Element e =null;
        try {
             e = ((Element) super.clone());
        }catch (CloneNotSupportedException cnse){
            cnse.printStackTrace(System.err);
        }
        return e;
    }

    public static Element[] setPossibleElement() {
        Element[] possibleElement = new Element[5];
        possibleElement[0] = new Element(new ElementType(0,"klanzflak","ak,fakfzl,aklf"));
        possibleElement[0].setPercent(CONSTANT.PERCENTGROUND);//Ground
        possibleElement[1] = new Element(new ElementType(1,"klanzflak","ak,fakfzl,aklf"));
        possibleElement[1].setPercent(CONSTANT.PERCENTWATER);//water
        possibleElement[2] = new Element(new ElementType(2,"klanzflak","ak,fakfzl,aklf"));
        possibleElement[2].setPercent(CONSTANT.PERCENTFOREST);//forest
        possibleElement[3] = new Element(new ElementType(3,"klanzflak","ak,fakfzl,aklf"));
        possibleElement[3].setPercent(CONSTANT.PERCENTSAND);//sand
        possibleElement[4] = new Element(new ElementType(4,"klanzflak","ak,fakfzl,aklf"));
        possibleElement[4].setPercent(CONSTANT.PERCENTMOUNTAIN);//Mountains
        return possibleElement;
    }

}
