package com.test.datastructure;

import java.lang.reflect.Array;

public class MyQueue1<T> {

	private T[] array;
	private int capacity;
	private int size;
	private int front;
	private int rear;
	private final static int DEFAULT_SIZE = 10;
	
	public MyQueue1(Class<T> type) {
		this(type, DEFAULT_SIZE);
	}
	
	@SuppressWarnings("unchecked")
	public MyQueue1(Class<T> type, int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("initial size can not be less than 0: " + initialCapacity);
		}
		this.array = (T[]) Array.newInstance(type, initialCapacity);
		this.front = 0;
		this.rear = -1;
		this.capacity = initialCapacity;
		this.size = 0;
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
	
	public void push(T item) {
		if (isFull()) {
			System.err.println("Queue is full!");
		} else {
			if (rear == capacity - 1) {
				rear = -1;
			}
			array[++rear] = item;
			size++;
		}
	}
	
	public T pop() {
		T item = null;
		if (isEmpty()) {
			System.err.println("Queue is empty!");
		} else {
			item = array[front];
			array[front] = null;
			if (front == capacity - 1) {
				front = -1;
			}
			front++;
			size--;
		}
		return item;
	}
	
	public T peek() {
		return array[front];
	}
	
	public static void main(String[] args) {
		String tmp=null;
		MyQueue1<String> queue = new MyQueue1<String>(String.class, 12);
		
		queue.push("10");
		queue.push("20");
		queue.push("30");
		 
		tmp = queue.pop();
		System.out.printf("tmp=%s\n", tmp);
		 
		tmp = queue.peek();
		System.out.printf("tmp=%s\n", tmp);
		 
		queue.push("40");
		 
		System.out.printf("isEmpty()=%b\n", queue.isEmpty());
		System.out.printf("size()=%d\n", queue.size());
		while (!queue.isEmpty()) {
			System.out.printf("value=%s\n", queue.pop());
		}
	}
	
}
