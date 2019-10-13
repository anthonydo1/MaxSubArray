package cs146F19.Do.project2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Tester for MaxSubArray.
 * @author Anthony Do
 *
 */
class MaxSubArrayTester {
	
	@Test
	void test() throws IOException {
		DataConverter dc = new DataConverter(new File("maxSumtest.txt"));
		ArrayList<int[]> list = dc.convert();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println("\nArray " + i);
			MaxSubArrayTest mst = new MaxSubArrayTest(list.get(i));
			MaxSubArray ms = mst.getMaxSubArray();
			
			// Brute Force
			long start = System.nanoTime();
			Element brute = ms.brute();
			System.out.println("Brute Force algorithm took: " + (System.nanoTime() - start) + "ns");
			
			// Divide and Conquer
			long start2 = System.nanoTime();
			Element divideAndConquer = ms.divideAndConquer();
			System.out.println("Divide and conquer algorithm took: " + (System.nanoTime() - start2) + "ns");
			
			// Kadane's Algorithm
			long start3 = System.nanoTime();
			Element kadanes = ms.kadanes();
			System.out.println("Kadane's algorithm took: " + ( System.nanoTime() - start3) + "ns");
			
			// Max comparison
			assertEquals(mst.getActualMax(), brute.getMax());
			assertEquals(mst.getActualMax(), divideAndConquer.getMax());
			assertEquals(mst.getActualMax(), kadanes.getMax());
			
			// Arrive comparison
			assertEquals(mst.getActualArrive(), brute.getArrive());
			assertEquals(mst.getActualArrive(), divideAndConquer.getArrive());
			assertEquals(mst.getActualArrive(), kadanes.getArrive());
			
			// Depart comparison
			assertEquals(mst.getActualDepart(), brute.getDepart());
			assertEquals(mst.getActualDepart(), divideAndConquer.getDepart());
			assertEquals(mst.getActualDepart(), kadanes.getDepart());
			
		}
		
	}

}
