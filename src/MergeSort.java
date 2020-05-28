import java.util.Arrays;

public class MergeSort {
	
	// Merge Sort

	public String[] mergeSort(String arr[])
	{
		int middle = (arr.length) / 2;

		if(arr.length <= 1) {
			return arr;
		}

		String[] left = Arrays.copyOfRange(arr, 0, middle);
		String[] right = Arrays.copyOfRange(arr, middle , arr.length);

		left = mergeSort(left);
		right = mergeSort(right);

		return sort(left, right);
	}

	public String[] sort(String left[], String right[]) {
		
		String[] result = new String[left.length + right.length];
		int leftPointer, rightPointer, resultPointer;
		leftPointer = rightPointer = resultPointer = 0;

		while(leftPointer < left.length || rightPointer < right.length) {
			if(leftPointer < left.length && rightPointer < right.length) {
				if(left[leftPointer].compareTo(right[rightPointer]) <= 0) {
					result[resultPointer++] = left[leftPointer++];
				}
				else {
					result[resultPointer++] = right[rightPointer++];
				}
			}
			else if(leftPointer < left.length) {
				result[resultPointer++] = left[leftPointer++];
			}

			else if(rightPointer < right.length) {
				result[resultPointer++] = right[rightPointer++];
			}
		}
		return result;
	}
}