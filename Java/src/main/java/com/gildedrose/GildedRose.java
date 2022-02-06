package com.gildedrose;

class GildedRose {
    Item[] items;

    private final String AGED_BRIE = "Aged Brie";
    private final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(AGED_BRIE)
                && !item.name.equals(BACKSTAGE)) {
                if (item.quality > 0) {
                    if (!item.name.equals(SULFURAS)) {
                        item.quality -= 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality += 1;

                    if (item.name.equals(BACKSTAGE)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality += 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality += 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS)) {
                item.sellIn -= 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE)) {
                    if (!item.name.equals(BACKSTAGE)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(SULFURAS)) {
                                item.quality -= 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality += 1;
                    }
                }
            }
        }
    }
}
