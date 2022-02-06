package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;

    private final Map<String, ItemUpdater> updaters;

    public GildedRose(Item[] items) {
        updaters = new HashMap<>();
        updaters.put("Aged Brie", ItemUpdater.AGED_BRIE);
        updaters.put("Backstage passes to a TAFKAL80ETC concert", ItemUpdater.BACKSTAGE);
        updaters.put("Sulfuras, Hand of Ragnaros", ItemUpdater.SULFURAS);
        updaters.put("Conjured", ItemUpdater.CONJURED);
        this.items = items;
    }


    public void updateQuality() {
        for (Item item : items) {
            ItemUpdater updater = updaters.getOrDefault(item.name, ItemUpdater.BASE);
            updater.updateQuality(item);
            updater.updateSellIn(item);
        }
    }
}
