package fr.iut.orsay.pts2.map;

import com.badlogic.gdx.Gdx;

import fr.iut.orsay.pts2.CONSTANT;

public class Element implements Cloneable {

    private ElementType elementType;

    private int locationW;
    private int locationH;
    private int percent;


    /*Constructor*/
    Element(ElementType elementType) {
        this.elementType = elementType;
    }

    /*Getters and setters*/

    public static Element[] setPossibleElement() {
        Element[] possibleElement = new Element[5];
        possibleElement[0] = new Element(new ElementType(0, Gdx.files.internal("texture/terre.png")));
        possibleElement[0].setPercent(CONSTANT.PERCENTGROUND);//Ground
        possibleElement[1] = new Element(new ElementType(1, Gdx.files.internal("texture/eau.png"), Gdx.files.internal("texture/eau2.png")));
        possibleElement[1].setPercent(CONSTANT.PERCENTWATER);//water
        possibleElement[2] = new Element(new ElementType(2, Gdx.files.internal("texture/foret.png")));
        possibleElement[2].setPercent(CONSTANT.PERCENTFOREST);//forest
        possibleElement[3] = new Element(new ElementType(3, Gdx.files.internal("texture/sable.png")));
        possibleElement[3].setPercent(CONSTANT.PERCENTSAND);//sand
        possibleElement[4] = new Element(new ElementType(4, Gdx.files.internal("texture/montagne.png")));
        possibleElement[4].setPercent(CONSTANT.PERCENTMOUNTAIN);//Mountains
        return possibleElement;
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

    public int getPercent() {
        return this.percent;
    }

    private Element setPercent(int percent) {
        this.percent = percent;
        return this;
    }

    /*functions*/
    public Element clone() {
        Element e = null;
        try {
            e = ((Element) super.clone());
        } catch (CloneNotSupportedException cnse) {
            cnse.printStackTrace(System.err);
        }
        return e;
    }

    public ElementType getElementType() {
        return elementType;
    }

}
