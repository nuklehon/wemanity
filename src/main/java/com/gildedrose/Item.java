package com.gildedrose;

import com.gildedrose.awake.UpdatableItem;

public class Item {

    public static final Integer MAX_QUALITY = 50;
    public static final String CONJURED = "conjured";

    protected String name;
    protected Integer sellIn;
    protected Integer quality;

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
        if(this.quality > 0) {
            this.quality--;
        }
    }

    public void increaseQuality() {
        if(this.quality < Item.MAX_QUALITY) {
            this.quality++;
        }
    }

    public void decreaseSellIn() {
        this.sellIn--;
    }

    public boolean isConjured() {
        return name.toLowerCase().contains(CONJURED);
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
