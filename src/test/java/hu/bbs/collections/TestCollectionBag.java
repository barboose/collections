package hu.bbs.collections;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author bvarga and created on 2017. 08. 29..
 */
public class TestCollectionBag {

	private static final String APPLE = "apple";
	private static final String PEAR = "pear";
	private static final String PLUM = "plum";

	@Test
	public void testAddEntry() {
		CollectionBag<String> collection = new CollectionBag<>();
		assertNotNull(collection);

		final boolean result = collection.add(APPLE);
		assertTrue(result);
		assertEquals(1, collection.count(APPLE));
		assertTrue(collection.contains(APPLE));
	}

	@Test
	public void testRemoveEntry() {
		CollectionBag<String> collection = new CollectionBag<>();
		assertNotNull(collection);

		final boolean addResult = collection.add(APPLE);
		assertTrue(addResult);
		assertEquals(1, collection.count(APPLE));
		assertTrue(collection.contains(APPLE));

		final boolean removeResult = collection.remove(APPLE);
		assertTrue(removeResult);
		assertEquals(0, collection.count(APPLE));
		assertFalse(collection.contains(APPLE));
	}

	@Test
	public void testCountBagMethod() {
		CollectionBag<String> collection = new CollectionBag<>();
		assertNotNull(collection);

		collection.add(APPLE);
		assertEquals(1, collection.count(APPLE));
		collection.add(PEAR);
		collection.add(PLUM);
		collection.add(APPLE);

		assertEquals(2, collection.count(APPLE));
		assertEquals(1, collection.count(PEAR));
	}

	@Test
	public void testCountComplexEntries() {
		CollectionBag<TestComplexVo> collection = new CollectionBag<>();
		assertNotNull(collection);

		TestComplexVo complexVo1 = new TestComplexVo(1L, APPLE, BigDecimal.ZERO);
		collection.add(complexVo1);
		assertEquals(1, collection.count(complexVo1));
		collection.add(complexVo1);
		assertEquals(2, collection.count(complexVo1));

		TestComplexVo complexVo2 = new TestComplexVo(2L, APPLE, BigDecimal.ZERO);
		collection.add(complexVo2);
		assertEquals(2, collection.count(complexVo1));
	}

	@Test
	public void testNullValuesInCollection() {
		CollectionBag<String> collection = new CollectionBag<>();
		collection.add(null);
		collection.add(null);
		assertEquals(2, collection.count(null));
	}

	@Test
	public void testReadableToString() {
		CollectionBag<String> collection = new CollectionBag<>();
		collection.add(APPLE);
		collection.add(PLUM);
		collection.add(APPLE);
		assertEquals("{plum=1, apple=2}", collection.toString());
	}

	@Test
	public void testCollectionBagSize() {
		CollectionBag<String> collection = new CollectionBag<>();
		collection.add(APPLE);
		collection.add(APPLE);
		collection.add(PLUM);
		assertEquals(2, collection.size());
	}

	@Test
	public void testClearCollectionBag() {
		CollectionBag<String> collection = new CollectionBag<>();
		collection.add(APPLE);
		collection.add(APPLE);
		collection.add(PLUM);
		assertEquals(2, collection.size());
		collection.clear();
		assertEquals(0, collection.size());
	}
}
