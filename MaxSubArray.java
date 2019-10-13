package cs146F19.Do.project2;


/**
 * Models a MaxSubArray class
 * @author Anthony Do
 *
 */
public class MaxSubArray {
	
	private int[] array;
	
	/**
	 * Constructs a MaxSubArray object and initalizes
	 * the array.
	 * @param array an array of integers
	 */
	public MaxSubArray(int[] array) {
		this.array = array;
	}
	
	
	/**
	 * Brute force approach to finding the max subarray
	 * @return An Element object containing the max, arrive, and depart.
	 */
	public Element brute() {
		int max = Integer.MIN_VALUE;
		int length = array.length;
		int arrive = 0;
		int depart = 0;
		
		for (int i = 0; i < length; i++) {
			int sum = 0;
			for (int j = i; j < length; j++) {
				sum += array[j];
				if (sum > max) {
					max = sum;
					arrive = i;
					depart = j;
				}
			}
		}
		
		return new Element(max, arrive, depart);
	}
	
	
	/**
	 * Divide and conquer approach to finding the max subarray
	 * @return An Element object containing the max, arrive, and depart.
	 */
	public Element divideAndConquer() {
		return maxSubArraySum(array, 0, array.length - 1);
	}
	
	
	/**
	 * Divide and conquer approach to finding the max subarray
	 * @param array The array itself.
	 * @param start The start index of the subarray.
	 * @param end The end index of the subarray.
	 * @return An Element object containing the max, arrive, and depart.
	 */
	private static Element maxSubArraySum(int[] array, int start, int end) {
		if (start == end) return new Element(array[start], start, start);
		
		int middle = (start + end) / 2; // Find middle of array
		
		Element leftMaxSub = maxSubArraySum(array, start, middle); // Find max subarray of left half
		Element rightMaxSub = maxSubArraySum(array, middle + 1, end); // Find max subarray of right half
		
		
		// Find max subarray middle out
		int arrive = -1;
		int depart = -1;
		
		int sum = 0;
		int leftSum = Integer.MIN_VALUE;
		
		for (int i = middle; i >= start; i--) {
			sum += array[i];
			
			if (sum > leftSum) {
				leftSum = sum;
				arrive = i; 
			}
		}
		
		sum = 0;
		int rightSum = Integer.MIN_VALUE;
		
		for (int i = middle + 1; i <= end; i++) {
			sum += array[i];
			
			if (sum > rightSum) {
				rightSum = sum;
				depart = i;
			}
		}
		
		// Return largest subarray
		Element element = new Element(0, 0, 0);
		
		int leftMax = leftMaxSub.getMax();
		int rightMax = rightMaxSub.getMax();
		int max = leftSum + rightSum;
		
		if (leftMax > rightMax && leftMax > max) {
			element = new Element(leftMaxSub.getMax(), leftMaxSub.getArrive(), leftMaxSub.getDepart());	
			
		} else if (rightMax > leftMax && rightMax > max) {
			element = new Element(rightMaxSub.getMax(), rightMaxSub.getArrive(), rightMaxSub.getDepart());	
			
		} else {
			element = new Element(leftSum + rightSum, arrive, depart);
		}
		
		return element;	
		
	}
	
	
	/**
	 * Kadane's algorithm approach to finding the max subarray.
	 * @return An Element object containing the max, arrive, and depart.
	 */
	public Element kadanes() {
		int maxSum = 0;
		int maxTemp = 0;
		int arrive = -1;
		int depart = -1;
		int tempArrive = 0;
		
		for (int i = 0; i < array.length; i++) {
			maxTemp += array[i];
			if (maxTemp < 0) {
				maxTemp = 0;
				arrive = i + 1;
			}
			
			if (maxSum < maxTemp) {
				maxSum = maxTemp;
				depart = i;
				tempArrive = arrive;
			}	
		}
		
		arrive = tempArrive;
		return new Element(maxSum, arrive, depart);
	}

}
