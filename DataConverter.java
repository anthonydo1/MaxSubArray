package cs146F19.Do.project2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Class to convert file data into an array.
 * @author Anthony Do
 *
 */
public class DataConverter {
	
	private File file;
	
	
	/**
	 * Constructs a DataConverter object.
	 * @param file The file to be converted.
	 */
	public DataConverter(File file) {
		this.file = file;
	}
	
	
	/**
	 * Converts the file into an array of Integers.
	 * @return An ArrayList of arrays containing integers.
	 * @throws IOException
	 */
	public ArrayList<int[]> convert() throws IOException {
		Scanner sc = new Scanner(file);
		ArrayList<int[]> list = new ArrayList<>();
		
		while (sc.hasNextLine() != false) {
			String current = sc.nextLine();
			if (current.isBlank()) continue;
			
			Scanner lineScanner = new Scanner(current);
			int[] integers = new int[103]; // 103 Elements per line
			int i = 0;
			
			// Add elements to array
			while (lineScanner.hasNextInt()) {
				integers[i] = lineScanner.nextInt();
				i++;
			}
			lineScanner.close();
			list.add(integers); // Add array to ArrayList
		}
		
		sc.close();
		return list;
	}
	
}

