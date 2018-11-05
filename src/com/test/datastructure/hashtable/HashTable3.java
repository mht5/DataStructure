package com.test.datastructure.hashtable;

import com.test.datastructure.hashtable.SortedList.Node;

/**
 * 使用链地址法实现的哈希表
 * @author mhts
 * @date 2018年11月5日
 */
public class HashTable3 {

	private SortedList[] array;
	private int capacity;
	private final static int DEFAULT_CAPACITY = 13;
	
	public HashTable3() {
		this(DEFAULT_CAPACITY);
	}
	
	public HashTable3(int initialCapacity) {
		this.capacity = initialCapacity;
		array = new SortedList[capacity];
		for (int i = 0; i < capacity; i++) {
			array[i] = new SortedList();
		}
	}
	
	public void displayHashTable() {
		for (int i = 0; i < capacity; i++) {
			System.out.print(i + ": ");
			array[i].displayList();
		}
	}
	
	public int hash(int key) {
		return key % capacity;
	}
	
	public void insert(Node node) {
		int hashVal = hash(node.getKey());
		array[hashVal].insert(node);
	}
	
	public Node find(int key) {
		int hashVal = hash(key);
		Node node = array[hashVal].find(key);
		return node;
	}
	
	public Node delete(int key) {
		int hashVal = hash(key);
		Node tmp = find(key);
		array[hashVal].delete(key);
		return tmp;
	}
	
	public static void main(String[] args) {
		HashTable3 hashTable = new HashTable3();
		
		SortedList list = new SortedList();
		hashTable.insert(list.new Node(1));
		hashTable.insert(list.new Node(3));
		hashTable.insert(list.new Node(4));
		hashTable.insert(list.new Node(5));
		hashTable.insert(list.new Node(18));
		hashTable.insert(list.new Node(7));
		hashTable.insert(list.new Node(8));
		hashTable.insert(list.new Node(9));
		hashTable.insert(list.new Node(31));
		hashTable.displayHashTable();
		
		hashTable.delete(4);
		hashTable.displayHashTable();
		
		System.out.println(hashTable.find(5).getKey());
	}
	
}
