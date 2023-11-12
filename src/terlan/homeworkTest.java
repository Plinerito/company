package terlan;

import static org.junit.jupiter.api.Assertions.*;
import static terlan.InterviewTask.*;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class homeworkTest {

		private static final int N_NUMBERS = 1000;
		int [] bigArray = new int[N_NUMBERS];
		@Test
		@DisplayName("performance O[N] is Sum2")
		void isSum2PerformanceTest() {
			isSum2(bigArray,1);
		}
		@Test
		void isSum2N2PerformanceTest() {
			
			isSum2N2(bigArray, 1);
		}
		@Test
		@DisplayName("performance O[N^2] is Sum2")
		void isSum2Test() {
		int [] ar1 = {1000, 300, -200, 20, 40, -10};
		assertTrue(isSum2(ar1, 800));  // 1000 + (-200) = 800
		assertTrue(isSum2(ar1, 990)); // 1000 + (-10) = 990
		assertFalse(isSum2(ar1, 50)); // two numbers with the given sum
	}

	
	@Test
	void getMaxPositiveWithNegativeValueTest() {
		int [] ar1 = {-1, 100, 200, -50, 1, -100, 50};
		int [] ar2 = {-1, -100, 200, -500, 10, -100, 50, 200};
		assertEquals(100, getMaxPositiveWithNegativeValue(ar1));
		assertEquals(-1,  getMaxPositiveWithNegativeValue(ar2));
	}
	
	

	@Test
	void getMapOccurrencesTest() {
		String[] strings = {
			"lpm", "ab", "a", "lpm", "a", "aa", "lpm"
		};
		HashMap<String, Long> mapOccurrences = 
   getMapOccurrences(strings);
		assertEquals(3, mapOccurrences.get("lpm"));
		assertEquals(2, mapOccurrences.get("a"));
		assertEquals(1, mapOccurrences.get("ab"));
		assertEquals(1, mapOccurrences.get("aa"));
	}
	@Test
	void isAnagramTest() {
		String string = "yellow";
     	assertTrue(isAnagram(string, "wolely"));
	    assertTrue(isAnagram(string, "elolwy"));
		assertTrue(isAnagram(string, "lowely"));
		assertTrue(isAnagram(string, "ollwey"));
		assertFalse(isAnagram(string, "wolelw")); //not y
		assertFalse(isAnagram(string, string));//the same order
		assertFalse(isAnagram(string, "wglely"));//g is not from the string
		assertFalse(isAnagram(string, "wolye"));//must be two 'l'   

	}

	}


