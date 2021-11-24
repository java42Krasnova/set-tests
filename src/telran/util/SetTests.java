package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetTests {
private static final int N_RANDOM_NUMBERS = 10000;
Integer[] initialNumbers = {
	10, 20, 40, 60, 5, 25, 3, 2, 4, 1	
};
Set<Integer> set;
	@BeforeEach
	void setUp() throws Exception {
		//set = new HashSet<>(3);

		set = new TreeSet<>();
		fillSet();
	}

	private  void fillSet() {
		fillSetFromArray(set, initialNumbers);
		
		
	}
	@Test
	void removeRoot() {
		Integer expected[] = {
				1, 2, 3, 4, 5,  20, 25, 40, 60
		};
		set.remove(10);
		assertArrayEquals(expected, getArrayFromSet(set));
	}
	
	@Test
	void removeJunction() {
		Integer expected[] = {
				1, 2,  4, 5, 10, 20, 25, 40, 60
		};
		set.remove(3);
		assertArrayEquals(expected, getArrayFromSet(set));
	}
	@Test
	void removeLeaf() {
		Integer expected[] = {
				 2, 3, 4, 5, 10, 20, 25, 40, 60
		};
		set.remove(1);
		assertArrayEquals(expected, getArrayFromSet(set));
	}
	@Test
	void removeNonJunctionRight() {
		Integer expected[] = {
				1, 2, 3, 4, 5, 10,  25, 40, 60
		};
		set.remove(20);
		assertArrayEquals(expected, getArrayFromSet(set));
	}
	@Test
	void removeNonJunctionLeft() {
		Integer expected[] = {
				1, 2, 3, 4,  10, 20, 25, 40, 60
		};
		set.remove(5);
		assertArrayEquals(expected, getArrayFromSet(set));
	}
	@Test
	void removeIfTest() {
		Integer randomNumbers[] = getRandomNumbers();
		//Set<Integer> setNumbers = new HashSet<>();
		Set<Integer> setNumbers = new TreeSet<>();
		fillSetFromArray(setNumbers, randomNumbers);
		setNumbers.removeIf(n -> n % 2 == 0);
		for(Integer num: setNumbers) {
			assertFalse(num % 2 == 0);
		}
	}

	private <T> void fillSetFromArray(Set<T> res, T[] array) {
		
		for(T num: array) {
			res.add(num);
		}
		
	}
	
	private Integer[] getRandomNumbers() {
		Integer[] res = new Integer[N_RANDOM_NUMBERS];
		for (int i = 0; i < res.length; i++) {
			res[i] = (int) (Math.random() * Integer.MAX_VALUE);
		}
		return res;
		
	}

	@Test
	void addTest() {
		assertEquals(initialNumbers.length, set.size());
		for(Integer num: initialNumbers) {
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
	void iteratorNoRemoveTest() {
		Integer[] randomNumbers = getRandomNumbers();
		//Set<Integer> numbersSet = new HashSet<>();
		Set<Integer> numbersSet = new TreeSet<>();
		fillSetFromArray(numbersSet, randomNumbers);
		Arrays.sort(randomNumbers);
		assertArrayEquals(randomNumbers, getArrayFromSet(numbersSet));
	}
	@Test
	void treeSetInsensitiveOrderTest () {
		 String strings[] = {"Boris", "Asaf", "android", "band"};
		 String expected[] = {"android", "Asaf", "band", "Boris"};
		 TreeSet<String> treeSet = new TreeSet<>((s1, s2)-> s1.compareToIgnoreCase(s2));
		 fillSetFromArray(treeSet, strings);
		 assertArrayEquals(expected, getArrayFromSet(treeSet));
	}
	@SuppressWarnings("unchecked")
	private <T> T[] getArrayFromSet(Set<T> set) {
		T res[] = (T[]) new Object[set.size()];
		int ind = 0;
		for(T obj: set) {
			res[ind++] = obj;
		}
		if(!( set instanceof TreeSet)){
			Arrays.sort(res);
		}
		return res;
	}
	@Test
	void removeContainsBasedTest() {
		Integer expected[] = {
				1, 2, 3, 4,  10, 20, 25, 40, 60
		};
		set.remove(5);
		assertFalse(set.contains(5));
		for(int i=0; i< expected.length;i++) {
			assertTrue(set.contains(expected[i]));
		}
	}
	@Test
	void testNextException() {
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			it.next();
			}
		try {
			it.next();
			fail("There shoud be thrown exception");
		} catch (NoSuchElementException e) {
		
		} catch (Exception e) {
			fail("There shoud be thrown NoSuchElementException");
		}
	}
	
	@Test
	void testREmoveNoNext(){
		Iterator<Integer> it = set.iterator();
		it.next();
		it.next();
		it.remove();
		exceptionRemoveTest(it);
		it = set.iterator();
		exceptionRemoveTest(it);
	}

	private void exceptionRemoveTest(Iterator<Integer> it) {
		try {
			it.remove();
			fail("there should be thrown Exception");
		} catch (IllegalStateException e) {
			
		} catch (Exception e) {
			fail("there should be thrown illegalStateException ");
		}		
	}
}