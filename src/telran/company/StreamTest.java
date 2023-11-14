package telran.company;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class StreamTest {

	@Test
	@Disabled
	void arrayStreamTest() {
		// computing sum of the even numbers
		int[] arr = {10,13,8,7,3,5,6} ;
		assertEquals(24,Arrays.stream(arr)
				.filter(n -> n % 2 == 0)
				.sum());
        assertEquals(13, Arrays.stream(arr)
        		.filter(n -> n % 2 != 0)
        		.max().getAsInt());     // create from optional in int. для решения неоднозначности пустого множества
        assertEquals(13, Arrays.stream(arr)
        		.filter(n -> n % 2 != 0)
        		.max().orElse(0));
        assertEquals(0, Arrays.stream(arr)
        		.filter(n -> n % 2 != 0)
        		.max().orElse(0));
	}
	
	@Test
	void displaySportloto() {
		Random gen = new Random();
		gen.ints(7,1,50)
		.distinct()
		.forEach(n -> System.out.print(n + " "));
	}
}
