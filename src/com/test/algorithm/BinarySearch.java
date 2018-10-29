package com.test.algorithm;

public class BinarySearch {

	public static int binarySearch(int[] array, int value, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = (high - low) / 2 + low;
		if (array[mid] == value) {
			return mid;
		} else if (array[mid] < value) {
			return binarySearch(array, value, mid + 1, high);
		} else {
			return binarySearch(array, value, low, mid - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {0,1,2,3,4,5,6,7,8,9};
		System.out.println(binarySearch(array, 3, 0, 9));
	}
	
}
