package com.test.algorithm;

public class SelectionSort {
	
	public static int[] selectionSort(int[] array) {
		int tmp, min;
		for (int i = 0; i < array.length - 1; i++) {
			min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			if (i != min) {
				tmp = array[i];
				array[i] = array[min];
				array[min] = tmp;
			}
		}
		return array;
	}
	
	public static void display(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
	
	public static void main(String[] args) {
		int[] array = {4, 2, 8, 9, 5, 7, 6, 1, 3};
        System.out.println("未排序数组顺序为：");
        display(array);
        System.out.println("-----------------------");
        array = selectionSort(array);
        System.out.println("-----------------------");
        System.out.println("经过选择排序后的数组顺序为：");
        display(array);
	}

}
