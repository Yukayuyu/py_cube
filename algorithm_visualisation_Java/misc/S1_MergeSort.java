import java.util.Arrays;

public class S1_MergeSort {
	// MergeSort(arr[], descend = false);
	// 1. Find the middle point, divide into two arrays;
	// 2. Call mergeSort for each half:
	// 3. Merge the result;
	public int[] mergeSort(int[] arr) {
		Boolean descend = false;
		return mergeSort(arr, descend);
	}

	// Boolean order = 0:"ascend", 1:"descend", default 0;
	public int[] mergeSort(int[] arr, Boolean descend) {
		// Find length
		// System.out.println(Array.getLength(arr));
		int length = arr.length;
		int m = length / 2;
		int l = 0;
		int r = length;
		// Create temp arrays (0 1 2 3 4);
		int lengthLeftArray = m - l; // m = 2, l = 0, r = 5, split to (0 1) (2 3 4)
		int lengthRightArray = r - m;
		int[] leftArray = new int[lengthLeftArray];
		int[] rightArray = new int[lengthRightArray];

		System.arraycopy(arr, 0, leftArray, 0, lengthLeftArray);
		System.arraycopy(arr, m, rightArray, 0, lengthRightArray);
		if (lengthLeftArray > 1 || lengthRightArray > 1) {
			int[] subLeft = mergeSort(leftArray, descend);
			int[] subRight = mergeSort(rightArray, descend);
			// if all recursion finished, return the combined result;
			return combineSorted(subLeft, subRight, descend);
		} else { // if both Array has only 1 element; the combineSorted can take it.
			return combineSorted(leftArray, rightArray, descend);
		}
	}

	int[] combineSorted(int[] sortedLeft, int[] sortedRight, Boolean descend) {
		int ll = sortedLeft.length;
		int lr = sortedRight.length;
		int[] result = new int[ll + lr];
		int resultPointer = 0;
		int lp = 0; // leftArray pointer
		int rp = 0; // leftArray pointer

		while (lp < ll && rp < lr) { // copy till either of the array's last element is copied.
			if ((!descend && sortedLeft[lp] < sortedRight[rp]) || (descend && sortedLeft[lp] > sortedRight[rp])) {
				result[resultPointer++] = sortedLeft[lp++];
			} else {
				result[resultPointer++] = sortedRight[rp++];
			}
		}
		// after the former loop, lp = 3, ll = 3; rp =3, lr =3;
		// copy the remaining, if there's any.
		if (lp < ll) {
			System.arraycopy(sortedLeft, lp, result, resultPointer, ll - lp);
		}
		if (rp < lr) {
			System.arraycopy(sortedRight, rp, result, resultPointer, lr - rp);
		}
		return result;
	}

	public static void main(String[] args) {
		S1_MergeSort x = new S1_MergeSort();
		int[] arrTest = new int[] { 1, 3, 2, 5, 0, 2, 1, 1, 5, 6, 3 };
		int[] arrSorted = new int[arrTest.length];
		arrSorted = x.mergeSort(arrTest);
		System.out.println(Arrays.toString(arrSorted));
	}
}
