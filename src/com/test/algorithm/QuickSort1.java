package com.test.algorithm;

public class QuickSort1 {

	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	private static int partitionIt(int[] array, int left, int right) {
		int leftPointer = left;
		int rightPointer = right + 1;
		int pivot = array[left];
		while (true) {
			while (leftPointer < right && array[++leftPointer] < pivot) {}
			while (rightPointer > 0 && array[--rightPointer] > pivot) {}
			if (leftPointer >= rightPointer) {
				break;
			} else {
				swap(array, leftPointer, rightPointer);
			}
		}
		swap(array, left, rightPointer);
		return rightPointer;
	}
	
	public static void quickSort(int[] array, int left, int right) {
		if (right <= left) {
			return;
		} else {
			int partition = partitionIt(array, left, right);
			quickSort(array, left, partition - 1);
			quickSort(array, partition + 1, right);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {57,1,6,5,4,89,9,7,6,34,432,4,54,64,3,2,432,65,67,657,5,4,1};
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
		quickSort(array, 0, array.length - 1);
		for (int i : array) {
			System.out.print(i + " ");
		}
	}
	
}
