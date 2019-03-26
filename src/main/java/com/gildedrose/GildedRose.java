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

                    // When i'm not special and my quality > 0 -> Rule
                    if (!SpecialItem.exist(item.getName()) && item.getQuality() > 0) {
                        item.decreaseQuality();
                    } else {
                        if (item.getQuality() < 50) {
                            item.increaseQuality();

                            //Backstage rule -> extract?
                            if (item.getName().equals(SpecialItem.TAFKAL80ETC_BACKSTAGE.getName())) {
                                if (item.getSellIn() < 11) {
                                    if (item.getQuality() < 50) {
                                        item.increaseQuality();
                                    }
                                }

                                if (item.getSellIn() < 6) {
                                    if (item.getQuality() < 50) {
                                        item.increaseQuality();
                                    }
                                }
                            }
                        }
                    }

                    // When i'm not sulfuras-> sellIn-- -> Rule (extract?)
                    if (!item.getName().equals(SpecialItem.SULFURAS.getName())) {
                        item.decreaseSellIn();
                    }

                    if (item.getSellIn() < 0) {

                        if (item.getName().equals(SpecialItem.AGED_BRIE.getName()) && item.getQuality() < 50) {
                            item.increaseQuality();
                        }

                        if (item.getName().equals(SpecialItem.TAFKAL80ETC_BACKSTAGE.getName())) {
                            item.setQuality(0);
                        }

                        // When i'm not special and my quality > 0 -> Rule (same?)
                        if (!SpecialItem.exist(item.getName()) && item.getQuality() > 0) {
                            item.decreaseQuality();
                        }
                    }

                });

    }
}