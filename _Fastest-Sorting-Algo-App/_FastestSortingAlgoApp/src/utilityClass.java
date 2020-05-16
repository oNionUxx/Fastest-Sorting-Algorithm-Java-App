
public class utilityClass { 

	// Instance Variables

	private WordsPackage packageOfWords;
	private MergeSort m = new MergeSort();
	private RadixSort r = new RadixSort();
	private InsertionSort i = new InsertionSort();
	private String sortType;

	// Constructor 

	public utilityClass(String sortType, WordsPackage packageOfWords) {
		this.packageOfWords = packageOfWords;
		setSortType(sortType);
	}
	
	// Getters && Setters

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public String getSortType() {
		return sortType;
	}

	/* This function purpose is to 
	 * determine which sorting algorithm 
	 * was given by the main class.
	 * According to the right  
	 * sorting algorithm name type 
	 * the switch case navigate to the 
	 * right sorting function there is.
	 */
	
	public void findSortingType(String[] arr) {
		
		String findSortType = sortType; 

		switch(findSortType) {
			case "MergeSort": {
				m.mergeSort(arr);
				break;
			}
	
			case "InsertionSort": {
				i.insertionSort(arr, arr.length);
				break;
			}
	
			case "RadixSort": {
				r.radixSort(arr, 'a','z');
				break;
			}
	
			default: {
				break;
			}
		}
	}
	
	// Time Measuring Execution

	public void executeSortingAlgorithm(String[] arrWords) {
		String result = "";

		long startTime, endTime, avgTime = 0;
		long[] runnigTimes = new long[5];
		String[] arrNotSorted;
		int n = arrWords.length;

		// Run sort 5 times

		for (int i = 0; i < runnigTimes.length; i ++) {

			// Save words to temporary array

			arrNotSorted = arrWords.clone();

			startTime = System.nanoTime();
			
			findSortingType(arrNotSorted);

			endTime = System.nanoTime();

			long tmp = (endTime - startTime) / 1000000;

			avgTime += tmp;
		}

		result += "Algoritm: "+ getSortType() + ", " +
				"N = " + n + " " + packageOfWords.getPackageType() + ".\n" +
				"Average Time " + "Elapsed: [" + avgTime / 5 + "]\n";

		System.out.println(result);

		packageOfWords.writeResultsToFile(result);
		
		System.out.println();
	}
}
