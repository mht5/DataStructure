package com.test.datastructure.linkedlist;

public class MyDLink1 {

	private class Node {
		private int value;
		private Node prev;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public MyDLink1() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void insertFirst(int value) {
		Node node = new Node(value);
		if (size == 0) {
			head = node;
			tail = node;
		} else {
			head.prev = node;
			node.next = head;
			head = node;
		}
		size++;
	}
	
	public void insertLast(int value) {
		Node node = new Node(value);
		if (size == 0) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		size++;
	}
	
	public Node deleteFirst() {
		Node tmp = head;
		if (size != 0) {
			head = head.next;
			head.prev = null;
			size--;
		}
		return tmp;
	}
	
	public Node deleteLast() {
		Node tmp = tail;
		if (size != 0) {
			tail = tail.prev;
			tail.next = null;
			size--;
		}
		return tmp;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (size == 0) {
			sb.append("[]");
		} else {
			Node node = head;
			int tempSize = size;
			if (tempSize == 1) {
				sb.append("[" +node.value + "]");
			} else {
				while (tempSize > 0) {
					if (node.equals(head)) {
						sb.append("[" + node.value + "->");
					} else if (node.next !=null) {
						sb.append(node.value + "->");
					} else {
						sb.append(node.value + "]");
					}
					node = node.next;
					tempSize--;
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int[] arr = {111, 222, 333, 444};
		
		MyDLink1 link = new MyDLink1();
		
		link.insertFirst(arr[1]);
		link.insertLast(arr[0]);
		link.insertFirst(arr[2]);
		
		System.out.printf("isEmpty()=%b\n", link.isEmpty());
		System.out.printf("size()=%d\n", link.size());
		System.out.println(link);
	}
	
}
