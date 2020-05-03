package fr.iut.orsay.pts2.ressources;

public abstract class Ressource {
    protected static String name;

    public Ressource(String name) {
        this.name=name;
    }


    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
