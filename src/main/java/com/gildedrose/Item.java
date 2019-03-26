package com.gildedrose;

public class Item {

    private String name;
    private Integer sellIn;
    private Integer quality;

    public Item(final String name, final int sellIn, final int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public Integer getSellIn() {
        return sellIn;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setSellIn(Integer sellIn) {
        this.sellIn = sellIn;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public void decreaseQuality() {
        this.quality--;
    }

    public void increaseQuality() {
        this.quality++;
    }

    public void decreaseSellIn() {
        this.sellIn--;
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
