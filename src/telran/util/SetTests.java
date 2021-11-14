package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetTests<T> {
	Integer[] initialNumbers = { 10, 20, 40, 60 };
	Set<Integer> set;

	@BeforeEach
	void setUp() throws Exception {
		set = new TreeSet<>();
		fillSet();
	}

	private void fillSet() {
		for (Integer num : initialNumbers) {
			set.add(num);
		}
	}

	@Test
	void addTest() {
		assertEquals(initialNumbers.length, set.size());
		for (Integer num : initialNumbers) {
			assertTrue(set.contains(num));
			}
		assertTrue(set.add(80));
		assertFalse(set.add(80));
	}
	
	@Test
	void containsTest() {
		assertTrue(set.contains(60));
		assertFalse(set.contains(80));
	}
	
	@Test
	//TODO
	//Done!!
	void iteratorTreeSetTest() {
		Integer[] exp = { 10, 20, 40, 60 };
		assertArrayEquals(exp, getArrayFromSet((Set<T>) set));
		int ind = 0;
		set.add(-80);
		set.add(55);
		set.add(100);
		set.add(-100);
		Iterator<Integer> iterator = set.iterator();
		Integer[] exp2 = { -100, -80, 10, 20, 40, 55, 60, 100 };
		while (iterator.hasNext()) {
			assertEquals(exp2[ind++], iterator.next());
		}
		
	}

	@SuppressWarnings("unchecked")
	private T[] getArrayFromSet(Set<T> set) {
		int size = set.size();
		int ind = 0;
		T[] res = (T[]) new Object[size];
		for (T obj : set) {
			res[ind++] = obj;
		}
		return res;
	}

}
