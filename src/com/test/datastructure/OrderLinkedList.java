package com.test.datastructure;

public class OrderLinkedList {
	
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
	
	private Node head;
	
	public void insert(int value) {
		Node node = new Node(value);
		Node previous = null;
		Node current = head;
		while (current != null && current.value < node.value) {
			previous = current;
			current = current.next;
		}
		if (previous == null) {
			head = node;
			head.next = current;
		} else {
			previous.next = node;
			node.next = current;
		}
	}
	
	public void deleteFirst() {
		head = head.next;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head;
		while (current != null) {
			sb.append(current.value + " ");
			current = current.next;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		OrderLinkedList list = new OrderLinkedList();
		list.insert(3);
		list.insert(1);
		list.insert(4);
		list.insert(2);
		System.out.println(list);
		list.deleteFirst();
		System.out.println(list);
	}

}
