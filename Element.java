package cs146F19.Do.project2;

/**
 * Models an Element class
 * @author Anthony Do
 *
 */
public class Element {
	private int max;
	private int arrive;
	private int depart;
	
	/**
	 * Constructs an element
	 * @param max The max subarray value
	 * @param arrive The arrival index
	 * @param depart The departure index
	 */
	public Element(int max, int arrive, int depart) {
		this.max = max;
		this.arrive = arrive;
		this.depart = depart;
	}
	
	/**
	 * Returns the max
	 * @return max
	 */
	public int getMax() {
		return max;
	}
	
	/**
	 * Returns the arrive
	 * @return the arrive
	 */
	public int getArrive() {
		return arrive;
	}
	
	/**
	 * Returns the depart
	 * @return the depart
	 */
	public int getDepart() {
		return depart;
	}
}
