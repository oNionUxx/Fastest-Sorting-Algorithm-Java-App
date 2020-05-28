
public class InsertionSort {
	
	// Insertion Sort
	
	public void insertionSort(String[] arr, int n) {
		int i, j;
		String value;
		
		for (i = 1; i < arr.length; i++) {
			value = arr[i];
			j = i - 1;
			while ((j >= 0) && (arr[j].compareTo(value) > 0)) {
				arr[j+1] = arr[j];
				j --;
			}
			arr[j+1] = value;
		}
	}
}