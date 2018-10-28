package com.test.datastructure;

public class MyLinkedList {
	
	private class Node {
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Node[" + value + "]";
		}
	}
	
	private int size;
	private Node head;
	private final static int DEFAULT_SIZE = 10;
	
	public MyLinkedList() {
		this(DEFAULT_SIZE);
	}
	
	public MyLinkedList(int initialCapacity) {
		if (initialCapacity < 1) {
			throw new IllegalArgumentException("InitialCapacity can not be less than 1");
		}
		this.head = null;
		this.size = 0;
	}
	
	public Node find(int value) {
		Node current = head;
		int tempSize = size;
		while (tempSize > 0) {
			if (current.value == value) {
				return current;
			} else {
				current = current.next;
				tempSize--;
			}
		}
		return null;
	}
	
	public void add(int value) {
		Node node = new Node(value);
		if (size == 0) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
		size++;
	}
	
	public boolean remove(int value) {
		if (size < 1) {
			return false;
		}
		Node previous = head;
		Node current = head;
		while (current.value != value) {
			if (current.next == null) {
				return false;
			} else {
				previous = current;
				current = current.next;
			}
		}
		if(current == head) {
			head = head.next;
		} else {
			previous.next = current.next;
		}
		size--;
		return true;
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
		MyLinkedList list = new MyLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);
		list.remove(3);
		System.out.println(list);
		System.out.println(list.find(2));
	}
	
}
