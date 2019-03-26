package com.gildedrose.awake;

import java.util.Optional;

public class ItemFactory {

    private ItemFactory() {
    }

    public static UpdatableItem build(final String name, final Integer sellIn, final Integer quality) {
        final Optional<SpecialItem> specialItem = SpecialItem.fromName(name);
        if (specialItem.isPresent()) {
            switch (specialItem.get()) {
                case AGED_BRIE:
                    return new AgedBrie(name, sellIn, quality);
                case SULFURAS:
                    return new Sulfuras(name, sellIn, quality);
                case TAFKAL80ETC_BACKSTAGE:
                    return new Backstage(name, sellIn, quality);
            }
        }

        return new DefaultItem(name, sellIn, quality);

    }

}
