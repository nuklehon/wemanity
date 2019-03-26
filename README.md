# wemanity

### Testing

Before modifying the code, we have to be sure our change won't break the business logic. To be sure, we'll use the fixture util to extract the business logic.

After a brief reading, the business is about items which live through time and their sellIn and quality properties are updated. Our goal here is to extract the behaviour for items which are "kind of special". 

There are several special items:
- Aged Brie
- Sulfuras, Hand of Ragnaros
- Backstage passes to a TAFKAL80ETC concert

Only these seems to have specific "update rules". We should have test cases for them + one for the default behavior.

#### Result

We cover 100% of the existing class GildedRose and we extract a bunch of test cases. See *test/resources/item-properties*.
>> Don't know yet what to do with Conjured items.

### Refactoring of the existing class

Now that we have all our tests, we can modify the class without being afraid of breaking something.

#### After refactoring, some rules show up

Try to implement them in concrete classes and adapt test to run with the new logic.