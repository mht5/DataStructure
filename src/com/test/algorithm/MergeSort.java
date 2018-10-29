package com.test.algorithm;

public class MergeSort {
	
	public static int[] mergeSort(int[] array, int low, int high) {
		if (low < high) {
			int mid = (high - low) / 2 + low;
			mergeSort(array, low, mid);
			mergeSort(array, mid + 1, high);
			merge(array, low, mid, high);
		}
		return array;
	}

	private static void merge(int[] array, int low, int mid, int high) {
		int[] tmp = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= high) {
			if (array[i] < array[j]) {
				tmp[k++] = array[i++];
			} else {
				tmp[k++] = array[j++];
			}
		}
		while (i <= mid) {
			tmp[k++] = array[i++];
		}
		while (j <= high) {
			tmp[k++] = array[j++];
		}
		for (int n = 0; n < tmp.length; n++) {
			array[low + n] = tmp[n];
		}
	}
	
	public static void main(String[] args) {
		int[] array = {3,4,5,6,7,8,9,4,433,2,1,3,54,5,6,7};
		array = mergeSort(array, 0, array.length - 1);
		for (int n : array) {
			System.out.print(n + " ");
		}
	}
	
}
