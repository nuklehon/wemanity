package com.gildedrose;

import com.gildedrose.awake.ItemFactory;
import com.gildedrose.awake.UpdatableItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class GildedRose {
    List<UpdatableItem> updatableItems = new ArrayList<>();

    public GildedRose(Item[] items) {
        Stream  .of(items)
                .forEach(item -> updatableItems.add(ItemFactory.build(item.name, item.sellIn, item.quality)));
    }

    public void updateQuality() {
        updatableItems.forEach(UpdatableItem::update);
    }
}