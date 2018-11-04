package com.test.datastructure.linkedlist;

public class DoublePointLinkedList {
	
	private class Node {
		private int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	private Node head;
	private Node tail;
	private int size;
	
	public DoublePointLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void addFirst(int value) {
		Node node = new Node(value);
		if (size == 0) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head = node;
		}
		size++;
	}
	
	public void addLast(int value) {
		Node node = new Node(value);
		if (size == 0) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		size++;
	}
	
	public boolean removeFirst(int value) {
		if (size < 1) {
			return false;
		}
		if (head.next == null) {
			head = null;
			tail = null;
		} else {
			head = head.next;
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
		DoublePointLinkedList list = new DoublePointLinkedList();
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		System.out.println(list);
		list.removeFirst(3);
		System.out.println(list);
	}

}
