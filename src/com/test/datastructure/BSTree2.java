package com.test.datastructure;

public class BSTree2 {

	private class Node {
		int value;
		Node left;
		Node right;
		
		public Node(int value) {
			this.value = value;
		}
		
		@Override
		public String toString() {
			return "Node[" + this.value + "]";
		}
	}
	
	private Node root;
	
	public void preOrder(Node current) {
		if (current != null) {
			System.out.print(current.value + " ");
			preOrder(current.left);
			preOrder(current.right);
		}
	}
	
	public void inOrder(Node current) {
		if (current != null) {
			inOrder(current.left);
			System.out.print(current.value + " ");
			inOrder(current.right);
		}
		
	}
	
	public void postOrder(Node current) {
		if (current != null) {
			postOrder(current.left);
			postOrder(current.right);
			System.out.print(current.value + " ");
		}
	}
	
	public Node findMax() {
		Node current = root;
		Node maxNode = current;
		while (current != null) {
			maxNode = current;
			current = current.right;
		}
		return maxNode;
	}
	
	public Node findMin() {
		Node current = root;
		Node minNode = current;
		while (current != null) {
			minNode= current;
			current = current.left;
		}
		return minNode;
	}
	
	public Node find(int value) {
		Node current = root;
		while (current != null) {
			if (current.value > value) {
				current = current.left;
			} else if (current.value < value) {
				current = current.right;
			} else {
				return current;
			}
		}
		return null;
	}
	
	public boolean insert(int value) {
		Node node = new Node(value);
		if (root == null) {
			root = node;
			return true;
		} else {
			Node current = root;
			Node parent = null;
			while (current != null) {
				parent = current;
				if (current.value > value) {
					current = current.left;
					if (current == null) {
						parent.left = node;
						return true;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = node;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.right;
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		if (successor.value != delNode.right.value) {
			successorParent.left = successor.right;
			successor.right = delNode.right;
		}
		return successor;
	}
	
	public boolean delete(int value) {
		Node current = root;
		Node parent = root;
		boolean isLeft = false;
		
		while (current.value != value) {
			parent = current;
			if (current.value > value) {
				isLeft = true;
				current = current.left;
			} else {
				isLeft = false;
				current = current.right;
			}
			if (current == null) {
				return false;
			}
		}
		
		if (current.left == null && current.right == null) {
			if (current == root) {
				root = null;
			} else if (isLeft) {
				parent.left = null;
			} else {
				parent.right = null;
			}
			return true;
		} else if (current.left == null && current.right != null) {
			if (current == root) {
				root = current.right;
			} else if (isLeft) {
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}
			return true;
		} else if (current.left != null && current.right == null) {
			if (current == root) {
				root = current.left;
			} else if (isLeft) {
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}
			return true;
		} else {
			Node successor = getSuccessor(current);
			if (current == root) {
				successor = root;
			} else if (isLeft) {
				parent.left = successor;
			} else {
				parent.right = successor;
			}
			successor.left = current.left;
			return true;
		}
	}
	
	public static void main(String[] args) {
		BSTree2 bt = new BSTree2();
        bt.insert(50);
        bt.insert(20);
        bt.insert(80);
        bt.insert(10);
        bt.insert(30);
        bt.insert(60);
        bt.insert(90);
        bt.insert(25);
        bt.insert(85);
        bt.insert(100);
        bt.inOrder(bt.root);
        System.out.println();
        bt.delete(10);
        bt.delete(30);
        bt.delete(80);
        bt.inOrder(bt.root);
        System.out.println();
        System.out.println(bt.findMax().value);
        System.out.println(bt.findMin().value);
        System.out.println(bt.find(100));
        System.out.println(bt.find(200));
	}
	
}
