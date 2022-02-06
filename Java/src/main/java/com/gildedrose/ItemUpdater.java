package com.gildedrose;

public enum ItemUpdater {

    BASE{
        @Override
        public void updateQuality(Item item) {
            int updatedQuality = item.quality;
            if(item.sellIn > 0){
                updatedQuality -= 1;
            } else {
                updatedQuality -= 2;
            }
            if (updatedQuality >= Constants.QUALITY_LOWER_LIMIT){
                item.quality = updatedQuality;
            }
        }
    },
    AGED_BRIE{
        @Override
        public void updateQuality(Item item) {
            int updatedQuality = item.quality;
            if(item.sellIn > 0){
                updatedQuality += 1;
            } else {
                updatedQuality += 2;
            }
            if (updatedQuality <= Constants.QUALITY_UPPER_LIMIT){
                item.quality = updatedQuality;
            }
        }
    },
    SULFURAS{
        @Override
        public void updateQuality(Item item) {
        }

        @Override
        public void updateSellIn(Item item) {
        }
    },
    BACKSTAGE{
        @Override
        public void updateQuality(Item item) {
            int updatedQuality = item.quality;
            if(item.sellIn > 10){
                updatedQuality += 1;
            } else if (item.sellIn > 5) {
                updatedQuality += 2;
            } else if (item.sellIn > 0) {
                updatedQuality += 3;
            } else {
                updatedQuality = 0;
            }
            if (updatedQuality <= Constants.QUALITY_UPPER_LIMIT){
                item.quality = updatedQuality;
            }
        }
    },
    CONJURED{
        @Override
        public void updateQuality(Item item) {
            int updatedQuality = item.quality;
            if(item.sellIn > 0){
                updatedQuality -= 2;
            } else {
                updatedQuality -= 4;
            }
            if (updatedQuality >= Constants.QUALITY_LOWER_LIMIT){
                item.quality = updatedQuality;
            }
        }
    };
    public abstract void updateQuality(Item item);
    public void updateSellIn(Item item){
        item.sellIn -= 1;
    }

    private static class Constants {
        public static int QUALITY_UPPER_LIMIT = 50;
        public static int QUALITY_LOWER_LIMIT = 0;
    }
}
