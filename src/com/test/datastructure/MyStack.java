package com.test.datastructure;

import java.lang.reflect.Array;
import java.util.Stack;

public class MyStack<T> {

	private static final int DEFAULT_SIZE = 12;
	private T[] myArray;
	private int count;
	
	public MyStack(Class<T> type) {
		this(type, DEFAULT_SIZE);
	}
	
	public MyStack(Class<T> type, int size) {
		myArray = (T[]) Array.newInstance(type, size);
		count = 0;
	}
	
	public void push(T value) {
		myArray[count++] = value;
	}
	
	public T peek() {
		return myArray[count - 1];
	}
	
	public T pop() {
		return myArray[--count];
	}
	
	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public void printArrayStack() {
		if (isEmpty()) {
			System.out.println("Stack is empty.");
		}
		
		System.out.println("Stack size: " + count);
		
		int i = count - 1;
		while (i >= 0) {
			System.out.println(myArray[i--]);
		}
	}
	
	public static void main(String[] args) {
		String tmp;
		
		System.out.println("MyStack:");
		MyStack<String> stack = new MyStack<String>(String.class);
		
		stack.push("10");
		stack.push("20");
		stack.push("30");
		
		tmp = stack.pop();
		System.out.println("tmp=" + tmp);
		
		tmp = stack.peek();
		System.out.println("tmp=" + tmp);
		
		stack.push("40");
		stack.printArrayStack();
		
		System.out.println("java.util.Stack:");
		Stack<String> stack1 = new Stack<String>();
		
		stack1.push("10");
		stack1.push("20");
		stack1.push("30");
		
		tmp = stack1.pop();
		System.out.println("tmp=" + tmp);
		
		tmp = stack1.peek();
		System.out.println("tmp=" + tmp);
		
		stack1.push("40");
		while(!stack1.empty()) {
			tmp = stack1.pop();
			System.out.println("tmp=" + tmp);
		}
		
	}
	
}