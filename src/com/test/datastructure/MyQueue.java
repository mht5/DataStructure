package com.test.datastructure;

public class MyQueue {
	
	private int[] array;
	private int count;
	
	public MyQueue(int size) {
		array = new int[size];
		count = 0;
	}
	
	public void add(int value) {
		array[count++] = value;
	}
	
	public int front() {
		return array[0];
	}
	
	public int pop() {
		int value = array[0];
		count--;
		for (int i = 1; i <= count; i++) {
			array[i - 1] = array[i];
		}
		return value;
	}
	
	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public static void main(String[] args) {
		int tmp=0;
		MyQueue queue = new MyQueue(12);
		
		queue.add(10);
		queue.add(20);
		queue.add(30);
		 
		tmp = queue.pop();
		System.out.printf("tmp=%d\n", tmp);
		 
		tmp = queue.front();
		System.out.printf("tmp=%d\n", tmp);
		 
		queue.add(40);
		 
		System.out.printf("isEmpty()=%b\n", queue.isEmpty());
		System.out.printf("size()=%d\n", queue.size());
		while (!queue.isEmpty()) {
			System.out.printf("value=%d\n", queue.pop());
		}
	}
	
}
