package com.gildedrose;

public enum ItemUpdater {

    BASE{
        @Override
        public void updateQuality(Item item) {
            int updatedQuality = item.quality;
            if(item.sellIn > 0){
                updatedQuality -= Constants.BASE_UPDATE_VALUE;
            } else {
                updatedQuality -= 2*Constants.BASE_UPDATE_VALUE;
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
                updatedQuality += Constants.BASE_UPDATE_VALUE;
            } else {
                updatedQuality += 2*Constants.BASE_UPDATE_VALUE;
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
                updatedQuality += Constants.BASE_UPDATE_VALUE;
            } else if (item.sellIn > 5) {
                updatedQuality += 2*Constants.BASE_UPDATE_VALUE;
            } else if (item.sellIn > 0) {
                updatedQuality += 3*Constants.BASE_UPDATE_VALUE;
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
                updatedQuality -= 2*Constants.BASE_UPDATE_VALUE;
            } else {
                updatedQuality -= 4*Constants.BASE_UPDATE_VALUE;
            }
            if (updatedQuality >= Constants.QUALITY_LOWER_LIMIT){
                item.quality = updatedQuality;
            }
        }
    };
    public abstract void updateQuality(Item item);
    public void updateSellIn(Item item){
        item.sellIn -= Constants.BASE_UPDATE_VALUE;
    }

    private static class Constants {
        public static int QUALITY_UPPER_LIMIT = 50;
        public static int QUALITY_LOWER_LIMIT = 0;
        public static int BASE_UPDATE_VALUE = 1;
    }
}
