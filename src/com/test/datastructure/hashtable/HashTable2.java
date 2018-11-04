package com.test.datastructure.hashtable;

/**
 * 使用再哈希法实现的哈希表
 * @author mhts
 * @date 2018年11月4日
 */
public class HashTable2 {
	
	private DataItem[] array;
	private int capacity;
	private int size;
	private DataItem nonItem;
	private final static int DEFAULT_CAPACITY = 13;
	
	HashTable2() {
		this(DEFAULT_CAPACITY);
	}
	
	HashTable2(int initialCapacity) {
		this.capacity = initialCapacity;
		array = new DataItem[capacity];
		size = 0;
		nonItem = new DataItem(-1);
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void display() {
		System.out.print("Table: ");
		for (int i = 0; i < capacity; i++) {
			if (array[i] != null) {
				System.out.print(array[i].getKey() + " ");
			} else {
				System.out.print("** ");
			}
		}
		System.out.print("\n");
	}
	
	public int hash1(int key) {
		return key % capacity;
	}
	
	public int hash2(int key) {
		return 7 - key % 7;
	}
	
	public void extendHashTable() {
		int num = capacity;
		size = 0;
		capacity *= 2;
		DataItem[] oldArray = array;
		array = new DataItem[capacity];
		for (int i = 0; i < num; i++) {
			insert(oldArray[i]);
		}
	}
	
	public void insert(DataItem item) {
		if (isFull()) {
			System.out.println("Hash table is full, rehashing...");
			extendHashTable();
		}
		int key = item.getKey();
		int hashVal = hash1(key);
		int step = hash2(key);
		while (array[hashVal] != null && array[hashVal].getKey() != -1) {
			hashVal += step;
			hashVal %= capacity;
		}
		array[hashVal] = item;
		size++;
	}
	
	public DataItem delete(int key) {
		if (isEmpty()) {
			System.out.println("Hash table is empty.");
			return null;
		}
		int hashVal = hash1(key);
		int step = hash2(key);
		while (array[hashVal] != null) {
			if (array[hashVal].getKey() == key) {
				DataItem tmp = array[hashVal];
				array[hashVal] = nonItem;
				size--;
				return tmp;
			}
			hashVal += step;
			hashVal %= capacity;
		}
		return null;
	}
	
	public DataItem find(int key) {
		int hashVal = hash1(key);
		int step = hash2(key);
		while(array[hashVal] != null) {
			if (array[hashVal].getKey() == key) {
				return array[hashVal];
			}
			hashVal += step;
			hashVal %= capacity;
		}
		return null;
	}
	
	private static class DataItem {
		private int data;
		public DataItem(int data) {
			this.data = data;
		}
		public int getKey() {
			return data;
		}
	}
	
	public static void main(String[] args) {
		HashTable2 hashTable = new HashTable2();
		
		hashTable.insert(new DataItem(1));
		hashTable.insert(new DataItem(3));
		hashTable.insert(new DataItem(4));
		hashTable.insert(new DataItem(5));
		hashTable.insert(new DataItem(18));
		hashTable.insert(new DataItem(7));
		hashTable.insert(new DataItem(8));
		hashTable.insert(new DataItem(9));
		hashTable.insert(new DataItem(31));
		hashTable.display();
		
		hashTable.delete(4);
		hashTable.display();
		
		System.out.println(hashTable.find(5).getKey());
	}
	
}
