package com.gildedrose;

import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PropertyMatcherTest {

    @Test
    public void agedBrie() throws Exception {
        final List<Result> expected = loadResult("aged_brie");
        final Item item = new Item("Aged Brie", 2, 0);
        Assert.assertEquals(expected, legacyResult(item));
    }

    @Test
    public void backstage1() throws Exception {
        final List<Result> expected = loadResult("backstage1");
        final Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        Assert.assertEquals(expected, legacyResult(item));
    }

    @Test
    public void backstage2() throws Exception {
        final List<Result> expected = loadResult("backstage2");
        final Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
        Assert.assertEquals(expected, legacyResult(item));
    }

    @Test
    public void back3() throws Exception {
        final List<Result> expected = loadResult("backstage3");
        final Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49);
        Assert.assertEquals(expected, legacyResult(item));
    }

    @Test
    public void sulfuras1() throws Exception {
        final List<Result> expected = loadResult("sulfuras1");
        final Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        Assert.assertEquals(expected, legacyResult(item));
    }

    @Test
    public void sulfuras2() throws Exception {
        final List<Result> expected = loadResult("sulfuras2");
        final Item item = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        Assert.assertEquals(expected, legacyResult(item));
    }

    @Test
    public void defaultDextVest() throws Exception {
        final List<Result> expected = loadResult("default-dexterity-vest");
        final Item item = new Item("+5 Dexterity Vest", 10, 20);
        Assert.assertEquals(expected, legacyResult(item));
    }

    @Test
    public void defaultElixir() throws Exception {
        final List<Result> expected = loadResult("default-elixir");
        final Item item = new Item("Elixir of the Mongoose", 5, 7);
        Assert.assertEquals(expected, legacyResult(item));
    }

    // -- TOOLS

    private static final File RESOURCE_FOLDER = Paths.get("target/test-classes", "item-properties").toFile();

    /**
     * Read the file content.
     * @param fileName - String
     * @return String
     * @throws IOException
     */
    private String load(final String fileName) throws IOException {
        return Files.toString(
                new File(RESOURCE_FOLDER, fileName),
                Charset.defaultCharset());
    }

    /**
     * Read the property file and build a Result list.
     * @param fileName - String
     * @return List<Result>
     * @throws Exception
     */
    private List<Result> loadResult(final String fileName) throws Exception {
        final String content = load(fileName);
        return Stream
                .of(content.split("\n"))
                .map(line -> {
                    final String[] values = line.split(",");
                    return new Result(Integer.valueOf(values[0]), Integer.valueOf(values[1]));
                })
                .collect(Collectors.toList());
    }

    /**
     * Tools to retrieve result from legacy update
     * @param item - Item
     * @return List<Result>
     */
    private List<Result> legacyResult(final Item item) {
        final Item[] items = new Item[] {  item };
        final GildedRose app = new GildedRose(items);

        final int days = 10;
        List<Result> actual = new ArrayList<>(days);
        for (int i = 0; i < days; i++) {
            actual.add(new Result(app.items[0].getSellIn(),app.items[0].getQuality()));
            app.updateQuality();
        }
        return actual;

    }

    private class Result {

        Integer sellIn;
        Integer quality;

        public Result(final Integer sellIn, final Integer quality) {
            this.sellIn = sellIn;
            this.quality = quality;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {

            if(!(obj instanceof Result)) {
                return false;
            }

            final Result toCompare = (Result) obj;
            return toCompare.quality.equals(this.quality) && toCompare.sellIn.equals(sellIn);
        }

        @Override
        public String toString() {
            return "[" +
                    "sellIn=" + sellIn +
                    ", quality=" + quality +
                    ']';
        }
    }

}
