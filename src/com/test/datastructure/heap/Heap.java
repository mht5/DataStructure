package com.test.datastructure.heap;

/**
 * ���ݽṹ�еĶ���һ����ȫ��������ֻ�����һ����Բ����������ұ��������ģ�
 * ������ʵ�ֵĶ�����������ڵ������ֵΪindex����ô��
 * �ڵ�����ӽڵ��� 2*index+1
 * �ڵ�����ӽڵ��� 2*index+2
 * �ڵ�ĸ��ڵ��� ��index-1��/2
 * @author mhts
 * @date 2018��11��5��
 */
public class Heap {
	
	private Node[] array;
	private int capacity;
	private int size;
	
	public Heap(int initialCapacity) {
		capacity = initialCapacity;
		array = new Node[capacity];
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	
	private void trickleUp(int index) {
		int parentIndex = (index - 1) / 2;
		Node bottom = array[index];
		while (index > 0 && array[parentIndex].getKey() < bottom.getKey()) {
			array[index] = array[parentIndex];
			index = parentIndex;
			parentIndex = (parentIndex - 1) / 2;
		}
		array[index] = bottom;
	}
	
	private void trickleDown(int index) {
		Node top = array[index];
		int largeChildIndex;
		while (index < size / 2) {
			int leftChildIndex = index * 2 + 1;
			int rightChildIndex = leftChildIndex + 1;
			if (rightChildIndex < size 
					&& array[leftChildIndex].getKey() < array[rightChildIndex].getKey()) {
				largeChildIndex = rightChildIndex;
			} else {
				largeChildIndex = leftChildIndex;
			}
			if (top.getKey() >= array[largeChildIndex].getKey()) {
				break;
			}
			array[index] = array[largeChildIndex];
			index = largeChildIndex;
		}
		array[index] = top;
	}
	
	public boolean insert(int key) {
		if (isFull()) {
			return false;
		}
		Node node = new Node(key);
		array[size] = node;
		trickleUp(size++);
		return true;
	}
	
	public Node remove() {
		Node root = array[0];
		array[0] = array[--size];
		trickleDown(0);
		return root;
	}
	
	public boolean change(int index, int newValue) {
		if (index < 0 || index >= size) {
			return false;
		}
		int oldValue = array[index].getKey();
		array[index].setKey(newValue);
		if (oldValue < newValue) {
			trickleUp(index);
		} else {
			trickleDown(index);
		}
		return true;
	}
	
	public void displayHeap() {
		System.out.println("array: ");
		for (int i = 0; i < size; i++) {
			if (array[i] != null) {
				System.out.print(array[i].getKey() + " ");
			} else {
				System.out.print("** ");
			}
		}
		System.out.println();
	}

	private class Node {
		private int data;
		public Node (int data) {
			this.data = data;
		}
		public int getKey() {
			return data;
		}
		public void setKey(int key) {
			this.data = key;
		}
	}
	
	public static void main(String[] args) {
		Heap heap = new Heap(13);
		heap.insert(1);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		heap.insert(6);
		heap.insert(7);
		heap.insert(9);
		heap.displayHeap();
		heap.change(5, 2);
		heap.displayHeap();
		heap.remove();
		heap.displayHeap();
	}
	
}
