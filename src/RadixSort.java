import java.util.Arrays;

public class RadixSort {

	// Radix Sort

	public void countingSort(String[] arr,int index,char lower,char upper){

		int[] countArray = new int[(upper - lower) + 2];
		String[] tempArray = new String[arr.length];
		Arrays.fill(countArray, 0);

		// Increase count for char at index

		for(int i=0;i<arr.length;i++){
			int charIndex = (arr[i].length()-1 < index) ? 0 : ((arr[i].charAt(index) - lower)+1);
			countArray[charIndex]++;
		}

		/*Sum up countArray
		  CountArray will hold last index
		  for the char at each strings index**/

		for(int i=1;i<countArray.length;i++){
			countArray[i] += countArray[i-1];
		}

		for(int i = arr.length - 1; i >= 0;i --){

			int charIndex = (arr[i].length() - 1 < index) ? 0 : (arr[i].charAt(index) - lower) + 1;
			tempArray[countArray[charIndex] - 1] = arr[i];
			countArray[charIndex] --;
		}

		for(int i=0;i<tempArray.length;i++){
			arr[i] = tempArray[i];   
		}
	}

	public void radixSort(String[] arr,char lower,char upper){
		int maxIndex = 0;
		for(int i = 0; i < arr.length; i ++){
			if(arr[i].length() - 1 > maxIndex){
				maxIndex = arr[i].length() - 1;
			}
		}

		for(int i = maxIndex; i >= 0; i --){
			countingSort(arr, i, lower, upper);
		}
	}
}