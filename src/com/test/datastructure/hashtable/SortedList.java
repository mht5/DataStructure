package com.test.datastructure.hashtable;

public class SortedList {
	
	private Node head;
	
	public SortedList() {
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void insert(Node node) {
		int key = node.getKey();
		Node previous = null;
		Node current = head;
		while (current != null && current.getKey() < key) {
			previous = current;
			current = current.next;
		}
		if (previous == null) {
			head = node;
		} else {
			previous.next = node;
			node.next = current;
		}
	}
	
	public void delete(int key) {
		Node previous = null;
		Node current = head;
		if (isEmpty()) {
			System.out.println("List is empty.");
			return;
		}
		while (current != null && current.getKey() < key) {
			previous = current;
			current = current.next;
		}
		if (previous == null) {
			head = head.next;
		} else {
			previous.next = current.next;
		}
	}
	
	public Node find(int key) {
		Node current = head;
		while (current != null && current.getKey() <= key) {
			if (current.getKey() == key) {
				return current;
			}
			current = current.next;
		}
		return null;
	}
	
	public void displayList() {
		System.out.print("List(First -> Last): ");
		Node current = head;
		while (current != null) {
			System.out.print(current.getKey() + " ");
			current = current.next;
		}
		System.out.println();
	}

	class Node {
		private int data;
		private Node next;
		public Node(int data) {
			this.data = data;
		}
		public int getKey() {
			return data;
		}
		public void displayLink() {
			System.out.println(data + " ");
		}
	}
	
}
