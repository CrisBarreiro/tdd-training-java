package com.gildedrose;

class GildedRose {
	Item[] items;

	private static final String AGED_BRIE = "Aged Brie";
	private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
        for (Item item : items) {

            update(item);
        }
	}

    private void update(Item item) {
        if (isSulfuras(item)) {
            return;
        }

        if (isBackstage(item) && item.sellIn == 0) {
            item.quality = 0;
            return;
        }

        if (isAgedBrie(item)) {
            updateAgedBrie(item);
        } else if (isBackstage(item)) {
            updateBackstage(item);
        } else {
            updateRegularItem(item);
        }

        decreaseSellIn(item);
    }

    private boolean isBackstage(Item item) {
        return item.name.equals(BACKSTAGE);
    }

    private void updateRegularItem(Item item) {
        decreaseQuality(item);

        if (isAboutToExpire(item)) {
            decreaseQuality(item);
        }
    }

    private void updateBackstage(Item item) {
        if (item.sellIn <= 5) {
            increaseQuality(3, item);
        } else if (item.sellIn <= 10){
            increaseQuality(2, item);
        } else {
            increaseQuality(item);
        }

        if (isAboutToExpire(item)) {
            decreaseQuality(item);
        }
    }

    private void updateAgedBrie(Item item) {
        if (isAboutToExpire(item)) {
            increaseQuality(2, item);
        } else {
            increaseQuality(item);
        }
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS);
    }

    private boolean isAboutToExpire(Item item) {
        return item.sellIn < 1;
    }

    private void decreaseSellIn(Item item) {
	    item.sellIn = item.sellIn - 1;
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item) {
        increaseQuality(1, item);
    }

    private void increaseQuality(int times, Item item) {
        if (item.quality < 50 && item.quality > 0) {
            item.quality = item.quality + times;
        }
    }
}
