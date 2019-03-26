# wemanity

### Testing

Before modifying the code, we have to be sure our change won't break the business logic. To be sure, we'll use the fixture util to extract the business logic.

After a brief reading, the business is about items which live through time and their sellIn and quality properties are updated. Our goal here is to extract the behaviour for items which are "kind of special". 

There are several special items:
- Aged Brie
- Sulfuras, Hand of Ragnaros
- Backstage passes to a TAFKAL80ETC concert

Only these seems to have specific "update rules". We should have test cases for them + one for the default behavior.