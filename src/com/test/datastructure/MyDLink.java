package com.test.datastructure;

public class MyDLink<T> {

	private class DNode<T> {
		public DNode prev;
		public DNode next;
		public T value;
		
		public DNode(T value, DNode prev, DNode next) {
			this.value = value;
			this.prev = prev;
			this.next = next;
		}
	}
	
	private DNode<T> head;
	private int count;
	
	public MyDLink() {
		head = new DNode(null, null, null);
		head.prev = head.next = head;
		count = 0;
	}
	
	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	private DNode<T> getNode(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException();
		}
		
		if (index <= count / 2) {
			DNode<T> node = head.next;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		}

		index = count - 1 - index;
		DNode<T> node=  head.prev;
		for (int i = 0; i < index; i++) {
			node = node.prev;
		}
		return node;
	}
	
	public T get(int index) {
		return getNode(index).value;
	}
	
	public T getFirst() {
		return getNode(0).value;
	}
	
	public T getLast() {
		return getNode(count - 1).value;
	}
	
	public void insert(int index, T value) {
		if (index == 0) {
			DNode<T>  node = new DNode(value, head, head.next);
			head.next.prev = node;
			head.next = node;
			count++;
			return;
		}
		DNode<T> oldNode = getNode(index);
		DNode<T> newNode = new DNode(value, oldNode.prev, oldNode);
		oldNode.prev.next = newNode;
		oldNode.prev = newNode;
		count++;
		return;
	}
	
	public void insertFirst(T value) {
		insert(0, value);
	}
	
	public void appendLast(T value) {
		DNode<T> node = new DNode(value, head.prev, head);
		head.prev.next = node;
		head.prev = node;
		count++;
	}
	
	public void delete(int index) {
		DNode node = getNode(index);
		node.prev.next = node.next;
		node.next.prev = node.prev;
		count--;
	}
	
	public void deleteFirst() {
		delete(0);
	}
	
	public void deleteLast() {
		delete(count - 1);
	}
	
	public static void main(String[] args) {
		String[] sarr = {"111", "222", "333", "444"};
		
		MyDLink<String> link = new MyDLink<String>();
		
		link.insert(0, sarr[1]);
		link.appendLast(sarr[0]);
		link.insertFirst(sarr[2]);
		
		System.out.printf("isEmpty()=%b\n", link.isEmpty());
		System.out.printf("size()=%d\n", link.size());
		
		for (int i=0; i<link.size(); i++) {
			System.out.println("dlink("+i+")="+ link.get(i));
		}
	}

}
