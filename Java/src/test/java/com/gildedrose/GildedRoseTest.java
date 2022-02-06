package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    public static int QUALITY_UPPER_LIMIT = 50;
    public static int QUALITY_LOWER_LIMIT = 0;


    /**
     * Evaluates whether the quality and sellIn value of a base item decrease when the sellIn value is positive.
     */
    @Test
    void updateBaseItem() {
        String name = "foo";
        Item[] items = new Item[] { new Item(name, 10, 20)};
        Item[] updatedItems = new Item[] {  new Item(name, 9, 19)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(updatedItems[0].quality, app.items[0].quality);
        assertEquals(updatedItems[0].sellIn, app.items[0].sellIn);
    }

    /**
     * Evaluates whether the quality of a base item drops twice as fast when the sellIn value is negative or 0.
     */
    @Test
    void updateExpiredBaseItem(){
        String name = "foo";
        Item[] items = new Item[] { new Item(name, -2, 20)};
        Item[] updatedItems = new Item[] {new Item(name, -3, 18)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(updatedItems[0].quality, app.items[0].quality);
        assertEquals(updatedItems[0].sellIn, app.items[0].sellIn);
    }

    /**
     * Evaluates whether the quality of a base item doesn't drop below 0.
     */
    @Test
    void assertLowerLimitBaseItem(){
        String name = "foo";
        Item[] items = new Item[] {new Item(name, 10, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality >= QUALITY_LOWER_LIMIT);
        assertEquals(9, app.items[0].sellIn);
    }


    /**
     * Evaluates whether the quality of Aged Brie increases when the sellIn value is positive.
     */
    @Test
    void updateAgedBrie(){
        String name = "Aged Brie";
        Item[] items = new Item[] { new Item(name, 10, 10) };
        Item[] updatedItems = new Item[] {  new Item(name, 9, 11) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(updatedItems[0].quality, app.items[0].quality);
        assertEquals(updatedItems[0].sellIn, app.items[0].sellIn);
    }

    /**
     * Evaluates whether the quality of Aged Brie increases twice as fast when the sellIn value is negative.
     */
    @Test
    void updateExpiredAgedBrie(){
        String name = "Aged Brie";
        Item[] items = new Item[] {new Item(name, -4, 10) };
        Item[] updatedItems = new Item[] {new Item(name, -5, 12) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(updatedItems[0].quality, app.items[0].quality);
        assertEquals(updatedItems[0].sellIn, app.items[0].sellIn);
    }

    /**
     * Evaluates whether the quality of Aged Brie doesn't increase above 50.
     */
    @Test
    void assertUpperLimitAgedBrie(){
        String name = "Aged Brie";
        Item[] items = new Item[] { new Item(name, -5, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality <= QUALITY_UPPER_LIMIT);
        assertEquals(-6, app.items[0].sellIn);
    }


    /**
     * Evaluates whether both the quality and sellIn values of Sulfuras do not change.
     */
    @Test
    void updateSulfuras(){
        String name = "Sulfuras, Hand of Ragnaros";
        Item[] items = new Item[] { new Item(name, 10, 80)};
        Item[] updatedItems = new Item[] { new Item(name, 10, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(updatedItems[0].quality, app.items[0].quality);
        assertEquals(updatedItems[0].sellIn, app.items[0].sellIn);
    }

    /**
     * Evaluates whether the quality of Sulfuras decreases with 1 if the sellIn lies above 10.
     */
    @Test
    void updateBackstage(){
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, 15, 20)};
        Item[] updatedItems = new Item[] {  new Item(name, 14, 21)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(updatedItems[0].quality, app.items[0].quality);
        assertEquals(updatedItems[0].sellIn, app.items[0].sellIn);
    }

    /**
     * Evaluates whether the quality of Sulfuras decreases with 2 if the sellIn lies above 5.
     */
    @Test
    void updateBackstage10(){
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] {new Item(name, 10, 20)};
        Item[] updatedItems = new Item[] {new Item(name, 9, 22),};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(updatedItems[0].quality, app.items[0].quality);
        assertEquals(updatedItems[0].sellIn, app.items[0].sellIn);
    }

    /**
     * Evaluates whether the quality of Sulfuras decreases with 2 if the sellIn lies above 0.
     */
    @Test
    void updateBackstage5(){
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] {new Item(name, 5, 20)};
        Item[] updatedItems = new Item[] { new Item(name, 4, 23)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(updatedItems[0].quality, app.items[0].quality);
        assertEquals(updatedItems[0].sellIn, app.items[0].sellIn);
    }

    /**
     * Evaluates whether the quality of a Backstage pass drops to 0 when the sellin is lower or equal to 0.
     */
    @Test
    void updateExpiredBackstage(){
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, 0, 20)};
        Item[] updatedItems = new Item[] { new Item(name, -1, 0)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(updatedItems[0].quality, app.items[0].quality);
        assertEquals(updatedItems[0].sellIn, app.items[0].sellIn);
    }

    /**
     * Evaluates whether the quality of a Backstage pass doesn't increase above 50.
     */
    @Test
    void assertUpperLimitBackstage(){
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] {
            new Item(name, 5, 48)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality <= QUALITY_UPPER_LIMIT);
        assertEquals(4, app.items[0].sellIn);
    }

    /**
     * Evaluates whether the quality and sellIn value of a conjured item decreases with 2 when the sellIn value is positive.
     */
    @Test
    void updateConjured(){
        String name = "Conjured";
        Item[] items = new Item[] { new Item(name, 10, 20)};
        Item[] updatedItems = new Item[] {  new Item(name, 9, 18)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(updatedItems[0].quality, app.items[0].quality);
        assertEquals(updatedItems[0].sellIn, app.items[0].sellIn);
    }

    /**
     * Evaluates whether the quality and sellIn value of a conjured item decreases with 4 when the sellIn value is negative or 0.
     */
    @Test
    void updateExpiredConjured(){
        String name = "Conjured";
        Item[] items = new Item[] { new Item(name, -2, 20)};
        Item[] updatedItems = new Item[] { new Item(name, -3, 16)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(updatedItems[0].quality, app.items[0].quality);
        assertEquals(updatedItems[0].sellIn, app.items[0].sellIn);
    }

    /**
     * Evaluates whether the quality of a conjured item doesn't drop below 0.
     */
    @Test
    void assertLowerLimitConjured(){
        String name = "Conjured";
        Item[] items = new Item[] { new Item(name, 10, 1)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality >= QUALITY_LOWER_LIMIT);
        assertEquals(9, app.items[0].sellIn);
    }




}
