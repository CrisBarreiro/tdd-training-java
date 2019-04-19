package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void qualityZero_updateQuality_isNotNegative() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertTrue(app.items[0].quality >= 0);
    }

    @Test
    public void item_updateQuality_degradesQualityOnce() {
        int quality = 2;
        Item[] items = new Item[] { new Item("foo", 4, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(quality - 1, app.items[0].quality);
    }

    @Test
    public void item_updateQuality_degradeSellInOnce() {
        int quality = 2;
        int sellIn = 4;
        Item[] items = new Item[] { new Item("foo", 4, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(sellIn - 1, app.items[0].sellIn);
    }

    @Test
    public void qualityGreaterThanZeroAndSellInZero_updateQuality_degradesQualityTwice() {
        int quality = 2;
        Item[] items = new Item[] { new Item("foo", 0, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(quality - 2, app.items[0].quality);
    }

    @Test
    public void agedBrie_updateQuality_increasesQuality() {
        int quality = 2;
        Item[] items = new Item[] { new Item("Aged Brie", 4, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(quality + 1, app.items[0].quality);
    }

    @Test
    public void agedBrie_updateQuality_atMost50() {
        int quality = 50;
        Item[] items = new Item[] { new Item("Aged Brie", 4, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertTrue(app.items[0].quality <= 50);
    }

    @Test
    public void updateQuality_atMost50() {
        int quality = 50;
        Item[] items = new Item[] { new Item("foo", 4, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertTrue(app.items[0].quality <= 50);
    }

    @Test
    public void sulfuras_updateQuality_sellInZero() {
        int sellIn = 2;
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", sellIn, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(sellIn, app.items[0].sellIn);
    }

    @Test
    public void sulfuras_updateQuality_notDecreasesInQuality() {
        int quality = 2;
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 5, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertFalse(app.items[0].quality < quality);
    }

    @Test
    public void backstageSellInGreaterThan10_updateQuality_sellInDecreasesQualityIncreasesOnce() {
        int quality = 2;
        int sellIn = 12;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(quality + 1, app.items[0].quality);
        assertEquals(sellIn - 1, app.items[0].sellIn);
    }

    @Test
    public void backstageSellInlowerThan10_updateQuality_sellInDecreasesQualityIncreasesTwice() {
        int quality = 2;
        int sellIn = 6;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(quality + 2, app.items[0].quality);
        assertEquals(sellIn - 1, app.items[0].sellIn);
    }

    @Test
    public void backstageSellIn10_updateQuality_sellInDecreasesQualityIncreasesTwice() {
        int quality = 2;
        int sellIn = 10;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(quality + 2, app.items[0].quality);
        assertEquals(sellIn - 1, app.items[0].sellIn);
    }

    @Test
    public void backstageSellInlowerThan5_updateQuality_sellInDecreasesQualityIncreasesByThree() {
        int quality = 2;
        int sellIn = 5;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(quality + 3, app.items[0].quality);
        assertEquals(sellIn - 1, app.items[0].sellIn);
    }

    @Test
    public void backstageSellIn5_updateQuality_sellInDecreasesQualityIncreasesByThree() {
        int quality = 2;
        int sellIn = 2;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(quality + 3, app.items[0].quality);
        assertEquals(sellIn - 1, app.items[0].sellIn);
    }

    @Test
    public void backstageAfterConcert_updateQuality_dropsToZero() {
        int quality = 10;
        int sellIn = 0;
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void agedBrieSellInLowerThanZero_updateQuality_increasesQualityByTwo() {
        int quality = 10;
        int sellIn = -1;
        Item[] items = new Item[] { new Item("Aged Brie", sellIn, quality) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(quality + 2, app.items[0].quality);
    }
}
