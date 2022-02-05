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
        String name = "foo";
        Item[] items = new Item[] { new Item(name, 10, 20),
                                    new Item(name, -2, 20),
                                    new Item(name, 10, 0)};
        Item[] updatedItems = new Item[] {  new Item(name, 9, 19),
                                            new Item(name, -3, 18),
                                            new Item(name, 9, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        for (int i=0; i < app.items.length; i++){
            assertEquals(updatedItems[i].quality, app.items[i].quality);
            assertEquals(updatedItems[i].sellIn, app.items[i].sellIn);
        }
    }



    @Test
    void updateAgedBrie(){
        String name = "Aged Brie";
        Item[] items = new Item[] { new Item(name, 10, 10),
                                    new Item(name, -4, 10) };
        Item[] updatedItems = new Item[] {  new Item(name, 9, 11),
                                            new Item(name, -5, 12) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        for (int i=0; i < app.items.length; i++){
            assertEquals(updatedItems[i].quality, app.items[i].quality);
            assertEquals(updatedItems[i].sellIn, app.items[i].sellIn);
        }
    }

    @Test
    void updateSulfuras(){
        String name = "Sulfuras, Hand of Ragnaros";
        Item[] items = new Item[] { new Item(name, 10, 80)};
        Item[] updatedItems = new Item[] { new Item(name, 10, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        for (int i=0; i < app.items.length; i++){
            assertEquals(updatedItems[i].quality, app.items[i].quality);
            assertEquals(updatedItems[i].sellIn, app.items[i].sellIn);
        }
    }

    @Test
    void updateBackstage(){
        String name = "Backstage passes to a TAFKAL80ETC concert";
        Item[] items = new Item[] { new Item(name, 15, 20),
                                    new Item(name, 10, 20),
                                    new Item(name, 5, 20),
                                    new Item(name, 0, 20)};
        Item[] updatedItems = new Item[] {  new Item(name, 14, 21),
                                            new Item(name, 9, 22),
                                            new Item(name, 4, 23),
                                            new Item(name, -1, 0)};

        GildedRose app = new GildedRose(items);
        app.updateQuality();
        for (int i=0; i < app.items.length; i++){
            assertEquals(updatedItems[i].quality, app.items[i].quality);
            assertEquals(updatedItems[i].sellIn, app.items[i].sellIn);
        }
    }

    @Test
    void updateConjured(){

    }


}
