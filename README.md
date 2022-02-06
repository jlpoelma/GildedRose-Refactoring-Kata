# Gilded Rose Refactoring Kata

My solution to the Gilded Rose Kata can be found in the Java folder.
I first wrote different unit tests in order to capture the different requirements and the edge cases. 
The GildedRoseTest class tests the following cases:
*   Whether the quality and sellIn value of a base item decrease when the sellIn value is positive.
*   Whether the quality of a base item doesn't drop below 0.
*   Whether the quality of a base item drops twice as fast when the sellIn value is negative or 0.
*   Whether the quality of Aged Brie increases when the sellIn value is positive. 
*   Whether the quality of Aged Brie increases twice as fast when the sellIn value is negative.
*   Whether the quality of Aged Brie doesn't increase above 50.
*   Whether both the quality and sellIn values of Sulfuras do not ever change.
*   Whether a Backstage pass quality increases with value 1 if the sellin is larger than 10, with value 2 when the sellin is larger than 5 and with value 3 when the sellin is larger than 0.
*   Whether the quality of a Backstage pass drops to 0 when the sellin is lower or equal to 0.
*   Whether a Conjured item satisfies all the requirements for a base item but decreases in quality twice as fast

I first cleaned up the nested if-statements by extracting the item name strings to variables and by shortening some notations. Afterwards, I replaced the nested if-statements by a switch-case statements which matches on the item names to make the function more readable.

Subsequently, I wanted to create a seperate updateQuality function for each type of item, as the requirements stated that the original Item class should not be modified, I instead created an ItemUpdater Enum which contains two methods:
*   updateQuality(Item item): updates the quality of the given item
*   updateSellIn(Item item): updates the sellIn of the given item
The ItemUpdater Enum contains implementations for each of these functions for each type of item.
A new item (such as Conjured items) can be easily included by adding a new Enum field and by overriding the two corresponding methods.