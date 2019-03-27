package com.gildedrose.awake;

import com.gildedrose.Item;

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
                    return new Sulfuras(name, sellIn); //Always 80
                case TAFKAL80ETC_BACKSTAGE:
                    return new Backstage(name, sellIn, quality);
            }
        }

        if(name.toLowerCase().contains(Item.CONJURED)) {
            return new ConjuredItem(name, sellIn, quality);
        } else {
            return new DefaultItem(name, sellIn, quality);
        }


    }

}
