package com.gildedrose.awake;

import com.gildedrose.Item;

public class Backstage extends Item implements UpdatableItem {

    public Backstage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {

        increaseQuality();

        if (getSellIn() < 11) {
            increaseQuality();
        }

        if (getSellIn() < 6) {
            increaseQuality();
        }

        decreaseSellIn();

        if (getSellIn() < 0) {
            setQuality(0);
        }

    }

}
