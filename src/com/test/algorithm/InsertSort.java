package com.test.algorithm;

public class InsertSort {
	
	public static int[] insertSort(int[] array) {
		int tmp, index;
		for (int i = 1; i < array.length; i++) {
			tmp = array[i];
			index = i;
			while (index > 0 && tmp < array[index - 1]) {
				array[index] = array[index - 1];
				index--;
			}
			array[index] = tmp;
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
        array = insertSort(array);
        System.out.println("-----------------------");
        System.out.println("经过插入排序后的数组顺序为：");
        display(array);
	}
	
}
