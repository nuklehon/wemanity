package com.gildedrose.awake;

import com.gildedrose.Item;

public class AgedBrie extends Item implements UpdatableItem {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        increaseQuality();
        decreaseSellIn();

        if(this.sellIn < 0) {
            this.increaseQuality();
        }

    }

}
