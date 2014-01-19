/*
 * Java Implementation of Insertion sort
 */

import java.io.*;

public class InsertionSort {
	public static void main(String[] args) {
		System.out.println("Please enter integers to be sorted, separated by space: ");

		// Open up standard input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inputLine = null;
		int[] keys = null;

		// Read and parse user input from the command line
		try {
			inputLine = br.readLine();

			// Split the input string to string array, separate by space
			String[] parsedLine = inputLine.split(" ");

			keys = new int[parsedLine.length];

			// Convert the String array to int array
			for (int i = 0; i < parsedLine.length; i++) {
				keys[i] = Integer.parseInt(parsedLine[i]);
			}			
		} catch (IOException ioe) {
			System.out.println("IO error trying to read your input!");
			System.exit(1);
		}

		// Sort the int array
		int[] sorted = sort(keys);

		// Print the sorted array
		System.out.print("Sorted array is: ");
		for (int element: sorted) {
			System.out.print(element + " ");
		}
		System.out.println("\n");
	}

	// Insertion sort an array in place
	public static int[] sort(int[] keys) {
		int key;

		// Start from 2nd element, compared to already sorted elements to its left
		for (int j = 1; j < keys.length; j++) {
			key = keys[j];
			int i = j - 1;
			// Compare and move
			while (i >= 0 && keys[i] > key) {
				// Move the bigger element one place to the right
				keys[i+1] = keys[i];
				i--;
			}
			// Position for the key is found, move the key to the spot
			keys[i+1] = key;
		}

		return keys;
	}
}