package cs146F19.Do.project2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MaxSubArrayTester {
	
	@Test
	void test() throws IOException {
		DataConverter dc = new DataConverter(new File("maxSumtest.txt"));
		ArrayList<int[]> list = dc.convert();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println("\nArray " + i);
			MaxSubArray ms = new MaxSubArray(list.get(i));
			
			long start = System.nanoTime();
			Element brute = ms.brute();
			System.out.println("Brute Force algorithm took: " + (System.nanoTime() - start) + "ns");
			
			long start2 = System.nanoTime();
			Element divideAndConquer = ms.divideAndConquer();
			System.out.println("Divide and conquer algorithm took: " + (System.nanoTime() - start2) + "ns");
			
			long start3 = System.nanoTime();
			Element kadanes = ms.kadanes();
			System.out.println("Kadane's algorithm took: " + ( System.nanoTime() - start3) + "ns");
			
			assertEquals(ms.getActualMax(), brute.getMax());
			assertEquals(ms.getActualMax(), divideAndConquer.getMax());
			assertEquals(ms.getActualMax(), kadanes.getMax());
			
			assertEquals(ms.getActualArrive(), brute.getArrive());
			assertEquals(ms.getActualArrive(), divideAndConquer.getArrive());
			assertEquals(ms.getActualArrive(), kadanes.getArrive());
			
			assertEquals(ms.getActualDepart(), brute.getDepart());
			assertEquals(ms.getActualDepart(), divideAndConquer.getDepart());
			assertEquals(ms.getActualDepart(), kadanes.getDepart());
			
		}
		
	}

}
