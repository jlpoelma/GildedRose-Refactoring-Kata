package com.gildedrose;

class GildedRose {
    Item[] items;

    private final String AGED_BRIE = "Aged Brie";
    private final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private final String CONJURED = "Conjured";

    public GildedRose(Item[] items) {
        this.items = items;
    }


    public void updateQuality() {
        for (Item item : items) {
            int updatedQuality = item.quality;
            switch (item.name){
                case AGED_BRIE:
                    if(item.sellIn > 0){
                        updatedQuality += 1;
                    } else {
                        updatedQuality += 2;
                    }
                    if (updatedQuality <= 50){
                        item.quality = updatedQuality;
                    }
                    item.sellIn -= 1;
                    break;
                case BACKSTAGE:
                    if(item.sellIn > 10){
                        updatedQuality += 1;
                    } else if (item.sellIn > 5) {
                        updatedQuality += 2;
                    } else if (item.sellIn > 0) {
                        updatedQuality += 3;
                    } else {
                        updatedQuality = 0;
                    }
                    if (updatedQuality <= 50){
                        item.quality = updatedQuality;
                    }
                    item.sellIn -= 1;
                    break;
                case SULFURAS:
                    break;
                case CONJURED:
                    if(item.sellIn > 0){
                        updatedQuality -= 2;
                    } else {
                        updatedQuality -= 4;
                    }
                    if (updatedQuality >= 0){
                        item.quality = updatedQuality;
                    }
                    item.sellIn -= 1;
                    break;
                default:
                    if(item.sellIn > 0){
                        updatedQuality -= 1;
                    } else {
                        updatedQuality -= 2;
                    }
                    if (updatedQuality >= 0){
                        item.quality = updatedQuality;
                    }
                    item.sellIn -= 1;
            }
        }
    }
}
