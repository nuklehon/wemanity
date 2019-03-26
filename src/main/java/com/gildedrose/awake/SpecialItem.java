package com.gildedrose.awake;

import java.util.Optional;
import java.util.stream.Stream;

public enum SpecialItem {

    SULFURAS ("Sulfuras, Hand of Ragnaros"),
    AGED_BRIE ("Aged Brie"),
    TAFKAL80ETC_BACKSTAGE ("Backstage passes to a TAFKAL80ETC concert")
    ;

    private String name;

    SpecialItem(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Optional<SpecialItem> fromName(final String name) {
        return Stream.of(SpecialItem.values()).filter(item -> name.equals(item.getName())).findAny();
    }

}