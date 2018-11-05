package com.test.algorithm;

import java.util.Arrays;

public class ShellSort {
	
	public static int[] shellSort(int[] array) {
		int step = 1;
		int length = array.length;
		while (step <= length / 3) {
			step = step * 3 + 1;
		}
		while (step > 0) {
			for (int i = step; i < length; i++) {
				int tmp = array[i];
				int j = i;
				while (j > step - 1 && tmp <= array[j - step]) {
					array[j] = array[j - step];
					j -= step;
				}
				array[j] = tmp;
			}
			System.out.println("step: " + step);
			System.out.println(Arrays.toString(array));
			step = (step - 1) / 3;
		}
		return array;
	}
	
	public static void main(String[] args) {
		int[] array = {3,4,8,1,2,5,4,3,1,0,6,7,9,9,5,4,3};
		System.out.println(Arrays.toString(array));
		array = shellSort(array);
		System.out.println(Arrays.toString(array));
	}

}
