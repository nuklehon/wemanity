package com.gildedrose;

import com.gildedrose.awake.SpecialItem;

import java.util.stream.Stream;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        Stream.of(items)
                .forEach(item -> {

                    if (!item.name.equals(SpecialItem.AGED_BRIE.getName())
                            && !item.name.equals(SpecialItem.TAFKAL80ETC_BACKSTAGE.getName())) {
                        if (item.quality > 0) {
                            if (!item.name.equals(SpecialItem.SULFURAS.getName())) {
                                item.quality--;
                            }
                        }
                    } else {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;

                            if (item.name.equals(SpecialItem.TAFKAL80ETC_BACKSTAGE.getName())) {
                                if (item.sellIn < 11) {
                                    if (item.quality < 50) {
                                        item.quality++;
                                    }
                                }

                                if (item.sellIn < 6) {
                                    if (item.quality < 50) {
                                        item.quality++;
                                    }
                                }
                            }
                        }
                    }

                    if (!item.name.equals(SpecialItem.SULFURAS.getName())) {
                        item.sellIn--;
                    }

                    if (item.sellIn < 0) {
                        if (!item.name.equals(SpecialItem.AGED_BRIE.getName())) {
                            if (!item.name.equals(SpecialItem.TAFKAL80ETC_BACKSTAGE.getName())) {
                                if (item.quality > 0) {
                                    if (!item.name.equals(SpecialItem.SULFURAS.getName())) {
                                        item.quality--;
                                    }
                                }
                            } else {
                                item.quality = 0;
                            }
                        } else {
                            if (item.quality < 50) {
                                item.quality++;
                            }
                        }
                    }

                });

    }
}