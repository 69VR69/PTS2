package fr.iut.orsay.pts2.map;

public class Element implements Cloneable {
    private int type = 0;
    private int locationW;
    private int locationH;
    private int percent = 100;
    private boolean check = false;
    public int locationType;

    Element top, left, right, bottom;

    /*Constructor*/
    Element() {

    }

    /*Getters and setters*/
    private Element setType(int type) {
        this.type = type;
        return this;
    }

    public int getType() {
        return this.type;
    }

    public boolean getCheck() {
        return this.check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public void setCheckTrue() {
        this.check = true;
    }

    public void setCheckFalse() {
        this.check = false;
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
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static Element[] setPossibleElement() {
        Element[] possibleElement = new Element[5];
        possibleElement[0] = new Element();
        possibleElement[0].setType(0).setPercent(70);//Ground
        possibleElement[1] = new Element();
        possibleElement[1].setType(1).setPercent(20);//water
        possibleElement[2] = new Element();
        possibleElement[2].setType(2).setPercent(30);//forest
        possibleElement[3] = new Element();
        possibleElement[3].setType(3).setPercent(40);//sand
        possibleElement[4] = new Element();
        possibleElement[4].setType(4).setPercent(50);//Mountains
        return possibleElement;
    }

}
