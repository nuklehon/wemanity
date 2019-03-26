package com.gildedrose.awake;

import com.gildedrose.Item;

public class Backstage extends Item implements UpdatableItem {

    public Backstage(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {

        if (getQuality() < 50) {
            increaseQuality();

            if (getSellIn() < 11) {
                if (getQuality() < 50) {
                    increaseQuality();
                }
            }

            if (getSellIn() < 6) {
                if (getQuality() < 50) {
                    increaseQuality();
                }
            }
        }

        decreaseSellIn();

        if (getSellIn() < 0) {
            setQuality(0);
        }

    }

}
