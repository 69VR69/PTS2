package fr.iut.orsay.pts2.ressources;

public abstract class building extends ProductionDistrict {
        protected int price;
        protected int time;
        protected int level=1;
        private String name;
        private String description;

        public void upgrade(){
            this.setLevel(getLevel()+1);
            this.setMaxStock((int) (this.getMaxStock()*1.5));
            this.setTime((int) (getTime()*0.9));
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

}
