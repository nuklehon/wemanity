package com.gildedrose.awake;

import com.gildedrose.Item;

public class AgedBrie extends Item implements UpdatableItem {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {

        if (getQuality() < 50) {
            increaseQuality();
        }

        decreaseSellIn();

        if (getSellIn() < 0 && getQuality() < 50) {
            increaseQuality();
        }
    }

}
