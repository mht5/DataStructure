package com.test.datastructure;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class MyStack1<T> {

	private T[] array;
	private int top;
	private int size;
	
	public MyStack1(Class<T> type) {
		this(type, 2);
	}
	
	@SuppressWarnings("unchecked")
	public MyStack1(Class<T> type, int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("initial size can not be less than 0: " + initialCapacity);
		}
		this.array = (T[]) Array.newInstance(type, initialCapacity);
		this.top = -1;
		this.size = initialCapacity;
	}

	private void ensureCapacity(int minCapacity) {
		int oldCapacity = size;
		if (oldCapacity <= minCapacity) {
			if ((oldCapacity << 1) - Integer.MAX_VALUE > 0) {
				this.size = Integer.MAX_VALUE;
			} else {
				this.size = oldCapacity << 1;
			}
			array = Arrays.copyOf(array, size);
		}
	}
	
	public T push(T item) {
		ensureCapacity(top + 1);
		array[++top] = item;
		return item;
	}
	
	public T peek() {
		if (top == -1) {
			throw new EmptyStackException();
		}
		return array[top];
	}
	
	public T pop() {
		T obj = peek();
		array[top--] = null;
		return obj;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public static void main(String[] args) {
		Object tmp;
		
		System.out.println("MyStack:");
		MyStack1<String> stack = new MyStack1<String>(String.class);
		
		stack.push("10");
		stack.push("20");
		stack.push("30");
		
		tmp = stack.pop();
		System.out.println("tmp=" + tmp);
		
		tmp = stack.peek();
		System.out.println("tmp=" + tmp);
		
		stack.push("40");
		while(!stack.isEmpty()) {
			tmp = stack.pop();
			System.out.println("tmp=" + tmp);
		}
		
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
