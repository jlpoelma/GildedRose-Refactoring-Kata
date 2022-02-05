package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }
    @Test
    void updateBaseItem() {
        Item[] items = new Item[] { new Item("foo", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void updateExpiredBaseItem() {
        Item[] items = new Item[] { new Item("foo", -2, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-3, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void assertNonNegative() {
        Item[] items = new Item[] { new Item("foo", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertTrue(app.items[0].quality >= 0);
    }

    @Test
    void updateAgedBrie(){
        Item[] items = new Item[] { new Item("Aged Brie", 10, 10), new Item("Aged Brie", -4, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
        assertEquals(-5, app.items[1].sellIn);
        assertEquals(12, app.items[1].quality);
    }

}
