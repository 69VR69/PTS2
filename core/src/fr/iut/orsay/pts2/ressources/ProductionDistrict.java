package fr.iut.orsay.pts2.ressources;

public abstract class ProductionDistrict extends building {
    protected int maxStock;
    protected int stock;
    protected int rate;

    public int getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(int maxStock) {
        this.maxStock = maxStock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
