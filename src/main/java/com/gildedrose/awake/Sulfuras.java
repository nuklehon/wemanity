package com.gildedrose.awake;

import com.gildedrose.Item;

public class Sulfuras extends Item implements UpdatableItem {

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void update() {
        if (getQuality() < 50) {
            increaseQuality();
        }
    }

}
