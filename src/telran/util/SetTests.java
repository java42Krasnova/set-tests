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
	//	Set<T> emptySet = new TreeSet<>();
//		Iterator itEmpty = emptySet.iterator();
//		while(itEmpty.hasNext())
//		{
//			System.out.println(itEmpty.next());
//		}
	Integer[] exp = { 10, 20, 40, 60 };
	assertArrayEquals(exp, getArrayFromSet((Set<T>) set));
	set.add(-80);
	set.add(55);
	set.add(60);
	set.add(-100);
	set.add(100);
	set.add(90);
	set.add(115);
		Iterator<Integer> iterator = set.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		System.out.println("++++++++++++++");
		Set<Integer> tmpSet = new TreeSet<>();
		tmpSet.add(100);
		tmpSet.add(4);
		tmpSet.add(-18);
		tmpSet.add(74);
		tmpSet.add(-34);
		tmpSet.add(204);
	Integer[] exp2= {-34, -18, 4, 74, 100, 204};
	assertArrayEquals(exp2, getArrayFromSet((Set<T>) tmpSet));
	Iterator<Integer> it = tmpSet.iterator();
	while(it.hasNext())
	{
		System.out.println(it.next());
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
