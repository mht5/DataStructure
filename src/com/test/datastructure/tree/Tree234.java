package com.test.datastructure.tree;

public class Tree234 {
	
	private Node root = new Node();
	
	public int find(long key) {
		Node current = root;
		int childNumber;
		while (true) {
			if ((childNumber = current.findItem(key)) != -1) {
				return childNumber;
			} else if (current.isLeaf()) {
				return -1;
			} else {
				current = getNextChild(current, key);
			}
		}
	}
	
	private Node getNextChild(Node current, long key) {
		int i;
		int numItems = current.getNumItems();
		for (i = 0; i < numItems; i++) {
			if (key < current.getItem(i).data) {
				return current.getChild(i);
			}
		}
		return current.getChild(i);
	}
	
	public void insert(long data) {
		Node current = root;
		DataItem item = new DataItem(data);
		
		while (true) {
			if (current.isFull()) {
				split(current);
				current = current.parent;
				current = getNextChild(current, data);
			} else if (current.isLeaf()) {
				break;
			} else {
				current = getNextChild(current, data);
			}
		}
		
		current.insertItem(item);
	}
	
	public void split(Node node2Split) {
		DataItem itemB, itemC;
		Node parent, child2, child3;
		int itemIndex;
		
		itemC = node2Split.removeItem();
		itemB = node2Split.removeItem();
		child2 = node2Split.disconnectChild(2);
		child3 = node2Split.disconnectChild(3);
		
		Node newRight = new Node();
		if (node2Split == root) {
			root = new Node();
			parent = root;
			root.connectChild(0, node2Split);
		} else {
			parent = node2Split.parent;
		}
		
		itemIndex = parent.insertItem(itemB);
		int n = parent.getNumItems();
		for (int i = n - 1; i > itemIndex; i--) {
			Node tmp = parent.disconnectChild(i);
			parent.connectChild(i + 1, tmp);
		}
		parent.connectChild(itemIndex + 1, newRight);
		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(0, child3);
	}
	
	public void displayTree() {
		displayTree(root, 0, 0);
	}

	private void displayTree(Node current, int level, int childNumber) {
		System.out.print("level = " + level + ", child = " + childNumber + " ");
		current.displayNode();
		int numItems=  current.getNumItems();
		for (int i = 0; i < numItems + 1; i++) {
			Node child = current.getChild(i);
			if (child != null) {
				displayTree(child, level + 1, i);
			} else {
				continue;
			}
		}
	}

	private class DataItem {
		private long data;
		public DataItem(long data) {
			this.data = data;
		}
		public void displatItem() {
			System.out.print("/" + data);
		}
	}
	
	private class Node {
		private static final int ORDER = 4;
		private int numItems;
		private Node parent;
		private Node[] childArray = new Node[ORDER];
		private DataItem[] itemArray = new DataItem[ORDER - 1];
		
		public void connectChild(int childNum, Node child) {
			childArray[childNum] = child;
			if (child != null) {
				child.parent = this;
			}
		}
		
		public Node disconnectChild(int childNum) {
			Node node = childArray[childNum];
			childArray[childNum] = null;
			return node;
		}
		
		public Node getChild(int childNum) {
			return childArray[childNum];
		}
		
		public Node getParent() {
			return parent;
		}
		
		public boolean isLeaf() {
			return childArray[0] == null;
		}
		
		public int getNumItems() {
			return numItems;
		}
		
		public DataItem getItem(int index) {
			return itemArray[index];
		}
		
		public boolean isFull() {
			return numItems == ORDER - 1;
		}
		
		public int findItem(long key) {
			for (int i = 0; i < ORDER - 1; i++) {
				if (itemArray[i] == null) {
					break;
				} else if (itemArray[i].data == key) {
					return i;
				}
			}
			return -1;
		}
		
		public int insertItem(DataItem item) {
			numItems++;
			long key = item.data;
			
			for (int i = ORDER - 2; i >= 0; i--) {
				if (itemArray[i] == null) {
					continue;
				} else {
					long oldKey = itemArray[i].data;
					if (key < oldKey) {
						itemArray[i + 1] = itemArray[i];
					} else {
						itemArray[i + 1] = item;
						return i + 1;
					}
				}
			}
			itemArray[0] = item;
			return 0;
		}
		
		public DataItem removeItem() {
			DataItem item = itemArray[numItems - 1];
			itemArray[numItems - 1] = null;
			numItems--;
			return item;
		}
		
		public void displayNode() {
			for (int i = 0; i < numItems; i++) {
				itemArray[i].displatItem();
			}
			System.out.print("/");
		}
		
	}
	
}
