package com.gildedrose.awake;

import com.gildedrose.Item;

public class DefaultItem extends Item implements UpdatableItem {

    public DefaultItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        if(getQuality() > 0) {
            this.decreaseQuality();
        }
        this.decreaseSellIn();
        if (this.getSellIn() < 0 && this.getQuality() > 0) {
            this.decreaseQuality();
        }
    }

}
