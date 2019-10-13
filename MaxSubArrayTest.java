package cs146F19.Do.project2;

import java.util.Random;

/**
 * Test class for MaxSubArray.
 * @author Anthony Do
 *
 */
public class MaxSubArrayTest {
	
	private MaxSubArray maxSubArray;
	private int actualMax;
	private int actualArrive;
	private int actualDepart;
	
	
	/**
	 * Creates a new array without the last 3 elements.
	 * @param array An array of integers from maxSumtest.txt
	 */
	public MaxSubArrayTest(int[] array) {
		int[] newArray = new int[array.length - 3];
		
		for (int i = 0; i < array.length - 3; i++) {
			newArray[i] = array[i];
		}
		maxSubArray = new MaxSubArray(newArray);
		
		this.actualMax = array[array.length - 3];
		this.actualArrive = array[array.length - 2];
		this.actualDepart = array[array.length - 1];
	}
	
	
	/**
	 * Tests a random array of size n, numbers -100 to 100.
	 * @param n The size of the random array of integers.
	 */
	public static void testElements(int n) {
		long bruteTotal = 0;
		long divideTotal = 0;
		long kadanesTotal = 0;
		
		int max = 100;
		int min = -100;
		
		for (int i = 0; i < 10; i++) {	
			int[] numbers = new int[n];
			Random random = new Random();
			
			for (int j = 0; j < n; j++) {
				numbers[j] = random.nextInt(max - min) + min; 
			}
		
			MaxSubArray ms = new MaxSubArray(numbers);
			
			long start = System.nanoTime();
			ms.brute();
			bruteTotal += System.nanoTime() - start;
			
			long start2 = System.nanoTime();
			ms.divideAndConquer();
			divideTotal += System.nanoTime() - start2;
			
			long start3 = System.nanoTime();
			ms.kadanes();
			kadanesTotal += System.nanoTime() - start3;
		}
		
		System.out.println("\nAverage Times for " + n + " elements");
		System.out.println("Brute Force: " + bruteTotal / 10);
		System.out.println("Divide and Conquer: " + divideTotal / 10);
		System.out.println("Kadane's: " + kadanesTotal / 10);
	}
	
	
	/**
	 * Returns the MaxSubArray object.
	 * @return maxSubArray
	 */
	public MaxSubArray getMaxSubArray() {
		return maxSubArray;
	}
	
	
	/**
	 * Returns the actual max.
	 * @return actualMax
	 */
	public int getActualMax() {
		return actualMax;
	}
	
	
	/**
	 * Returns the actual arrive index.
	 * @return actualArrive
	 */
	public int getActualArrive() {
		return actualArrive;
	}
	
	
	/**
	 * Returns the actual depart index.
	 * @return actualDepart
	 */
	public int getActualDepart() {
		return actualDepart;
	}
	
	
	public static void main(String[] args) {
		testElements(10000);
		testElements(5000);
		testElements(2000);
		testElements(1000);
		testElements(500);
		testElements(200);
		testElements(100);
	}
}
