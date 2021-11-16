package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
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
		String strings[] = {"Boris",  "Asaf", "android", "band"};
		Set<String> strSet = new TreeSet<>((a,b)-> a.compareToIgnoreCase(b));
		for (String str : strings) {
			strSet.add(str);
		}
		String expected[] = {"android","Asaf", "band", "Boris"};
		Arrays.sort(expected,(a,b)-> a.compareToIgnoreCase(b));
		
		assertArrayEquals(expected, getArrayFromSet((Set<T>) strSet));
		Integer[] exp = { 10, 20, 40, 60 };
		Arrays.sort(exp);
		assertArrayEquals(exp, getArrayFromSet((Set<T>) set));
		Set<Integer> tmpSet = new TreeSet<>();
		tmpSet.add(100);
		tmpSet.add(4);
		tmpSet.add(-18);
		tmpSet.add(74);
		tmpSet.add(-34);
		tmpSet.add(204);

	Integer[] exp2= {-34, -18, 4, 74, 100, 204};
	assertArrayEquals(exp2, getArrayFromSet((Set<T>) tmpSet));
	}

	@SuppressWarnings("unchecked")
	private T[] getArrayFromSet(Set<T> set) {
		int ind = 0;
		T[] res = (T[]) new Object[set.size()];
		for (T obj : set) {
			res[ind++] = obj;
		}
		return res;
	}

}
