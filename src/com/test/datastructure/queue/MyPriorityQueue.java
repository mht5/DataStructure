package com.test.datastructure.queue;

public class MyPriorityQueue {
	
	private int[] array;
	private int capacity;
	private int size;
	private final static int DEFAULT_SIZE = 10;
	
	public MyPriorityQueue() {
		this(DEFAULT_SIZE);
	}
	
	public MyPriorityQueue(int initialCapacity) {
		if (initialCapacity < 1) {
			throw new IllegalArgumentException("InitialCapacity can not be less than 1");
		}
		this.capacity = initialCapacity;
		this.array = new int[this.capacity];
		this.size = 0;
	}
	
	public void push(int value) {
		if (size == 0) {
			array[size++] = value;
		} else {
			int i = size - 1;
			while (i >= 0 && value > array[i]) {
				array[i + 1] = array[i];
				i--;
			}
			array[i] = value;
			size++;
		}
	}
	
	public int push() {
		int i = size - 1;
		int value = array[i];
		array[i] = -1;
		size--;
		return value;
	}
	
	public int peek() {
		return array[size - 1];
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public boolean isFull() {
		return this.size == this.capacity;
	}
	
}
