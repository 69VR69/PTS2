package fr.iut.orsay.pts2.map;

public class Test {
    GenerateMap map;

    private Test(){
        this.createMap();
    }
    private void createMap(){
        this.map = new GenerateMap();
        this.map.setUpPossibleElement();
        this.map.generateMatrix();
        this.map.setElementAtRandomPosition();
        this.map.getPosition();
        this.map.printMatrix();

    }

    public static void main(String[] args) {
        Test t = new Test();
    }
}
