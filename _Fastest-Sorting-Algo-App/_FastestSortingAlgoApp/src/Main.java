
public class Main {

	public static void main(String[] args) {
		
		WordsPackage Semi_Sorted_Strings = new WordsPackage("Semi-Sorted Strings");
		WordsPackage Strings_In_Ascending_Order = new WordsPackage("Strings In Ascending Order");
		WordsPackage Strings_In_Descending_Order = new WordsPackage("Strings In Descending Order");
		WordsPackage Unsorted_Strings = new WordsPackage("Unsorted Strings");
	
		// Semi-Sorted Strings
		
		utilityClass("InsertionSort", Semi_Sorted_Strings);
		utilityClass("MergeSort",Semi_Sorted_Strings);
		utilityClass("RadixSort", Semi_Sorted_Strings);
		
		// Strings In Ascending Order
		
		utilityClass("InsertionSort", Strings_In_Ascending_Order);
		utilityClass("MergeSort",Strings_In_Ascending_Order);
		utilityClass("RadixSort", Strings_In_Ascending_Order);
		
		// Strings In Descending Order Strings_In_Descending_Order
		
		utilityClass("InsertionSort", Strings_In_Descending_Order);
		utilityClass("MergeSort",Strings_In_Descending_Order);
		utilityClass("RadixSort", Strings_In_Descending_Order);
		
		// Unsorted_Strings Folder
		
		utilityClass("InsertionSort", Unsorted_Strings);
		utilityClass("MergeSort",Unsorted_Strings);
		utilityClass("RadixSort", Unsorted_Strings);
	}
	
	public static void utilityClass(String sortType, WordsPackage wordPackage) {
		utilityClass sorting = new utilityClass(sortType, wordPackage);
		sorting.executeSortingAlgorithm(wordPackage.get50kArray());
		sorting.executeSortingAlgorithm(wordPackage.get250kArray());
		sorting.executeSortingAlgorithm(wordPackage.get500kArray());
		sorting.executeSortingAlgorithm(wordPackage.get1mArray());
	}
}