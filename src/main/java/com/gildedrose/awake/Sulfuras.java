package com.gildedrose.awake;

import com.gildedrose.Item;

public class Sulfuras extends Item implements UpdatableItem {

    public static final Integer QUALITY = 80;

    public Sulfuras(String name, int sellIn) {
        super(name, sellIn, QUALITY);
    }

    @Override
    public void update() {
        increaseQuality();
    }

}
