package fr.iut.orsay.pts2.Houses;

import java.util.ArrayList;

import fr.iut.orsay.pts2.unit.Placable;

public abstract class Building implements Placable {
        protected int price;
        protected int time;
        protected int level=1;
        private String name;
        private String description;
        private int posX,posY;
        protected static ArrayList<Building> buildings=new ArrayList<>();

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
