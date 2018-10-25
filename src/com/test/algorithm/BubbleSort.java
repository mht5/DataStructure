package com.test.algorithm;

public class BubbleSort {
	
	public static int[] bubbleSort(int[] array) {
		int tmp;
		for (int i = 1; i < array.length; i++) {
			boolean flag = true;
			for (int j = 0; j < array.length - i; j++) {
				if (array[j] > array[j + 1]) {
					tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
					flag = false;
				}
			}
			if (flag) {
				break;
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
        array = bubbleSort(array);
        System.out.println("-----------------------");
        System.out.println("经过冒泡排序后的数组顺序为：");
        display(array);
	}

}
