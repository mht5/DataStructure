package com.test.datastructure;

public class BSTree1 {
	
	private class Node {
		public int key;
		public Node left;
		public Node right;
		public Node(int key) {
			this.key = key;
		}
	}
	
	private Node root;
	
	public Node find(int key) {
		if (root == null) {
			System.out.println("This tree is empty");
		}
		Node current = root;
		while (current.key != key) {
			if (key < current.key) {
				current = current.left;
			} else {
				current = current.right;
			}
			if (current == null) {
				return null;
			}
		}
		return current;
	}
	
	public boolean insert(int key) {
		if (root == null) {
			root = new Node(key);
			return true;
		}
		if (this.find(key) != null) {
			System.out.println("This tree already has a node with the same key.");
			return false;
		}
		Node current = root;
		while (current != null) {
			if (key < current.key) {
				if (current.left == null) {
					current.left = new Node(key);
					return true;
				}
				current = current.left;
			} else {
				if (current.right == null) {
					current.right = new Node(key);
					return true;
				}
				current = current.right;
			}
		}
		return false;
	}
	
	public void preOrder(Node node) {
		if (node != null) {
			System.out.println(node.key);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.println(node.key);
			inOrder(node.right);
		}
	}
	
	public void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.key);
		}
	}
	
	public int min(Node node) {
		if (this.find(node.key) == null) {
			System.out.println("Node " + node.key + "does not exist");
		}
		if (node.left == null) {
			return node.key;
		}
		Node current = node.left;
		while (current.left != null) {
			current = current.left;
		}
		return current.key;
	}
	
	public int max(Node node) {
		if (this.find(node.key) == null) {
			System.out.println("Node " + node.key + "does not exist");
		}
		if (node.right == null) {
			return node.key;
		}
		Node current = node.right;
		while (current.right != null) {
			current = current.right;
		}
		return current.key;
	}
	
	private Node successor(Node node2Del) {
		Node nodeParent = node2Del;
		Node node = node2Del.right;
		while (node.left != null) {
			nodeParent = node;
			node = node.left;
		}
		if (node.key != node2Del.right.key) {
			nodeParent.left = node.right;
		} else {
			nodeParent.right = node.right;
		}
		return node;
	}
	
	public boolean delete(int key) {
		if (root == null) {
			System.out.println("This tree is empty");
			return false;
		}
		Node targetParent = root;
		Node target = root;
		boolean isLeft = true;
		
		while (target.key != key) {
			if (key < target.key) {
				targetParent = target;
				target = target.left;
				isLeft = true;
			} else {
				targetParent = target;
				target = target.right;
				isLeft = false;
			}
			if (target == null) {
				break;
			}
		}
		
		if (target == null) {
			System.out.println("This node does not exist");
		}
//		如要要删除的是叶子节点，直接删除
		if (target.left == null && target.right == null) {
			if (target.key == root.key) {
				root = null;
				return true;
			}
			if (isLeft) {
				targetParent.left = null;
			} else {
				targetParent.right = null;
			}
		}
//		如果要删除的节点只有右子节点，用右子节点替换要删除的节点
		else if (target.left == null && target.right != null) {
			if (target.key == root.key) {
				root = root.right;
				return  true;
			}
			if (isLeft) {
				targetParent.left = target.right;
			} else {
				targetParent.right = target.right;
			}
		}
//		如果要删除的节点只有左子节点，用左子节点替换要删除的节点
		else if (target.right == null && target.left != null) {
			if (target.key == root.key) {
				root = root.left;
				return true;
			}
			if (isLeft) {
				targetParent.left = target.left;
			} else {
				targetParent.right = target.left;
			}
		} 
//		如果要删除的节点有两个子节点，需要找到要删除节点的下一个邻近节点，并用该节点代替要删除的节点
		else {
			Node successor = successor(target);
			if (target.key == root.key) {
				root = successor;
			} else if (isLeft) {
				targetParent.left = successor;
			} else {
				targetParent.right = successor;
			}
			successor.left = target.left;
			successor.right = target.right;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		//插入
		BSTree1 bst = new BSTree1();
		bst.insert(20);
		bst.insert(10);
		bst.insert(30);
		//遍历
		bst.preOrder(bst.root);
		System.out.println();
		bst.inOrder(bst.root);
		System.out.println();
		bst.postOrder(bst.root);
		System.out.println();
		//删除
		bst.insert(5);
		bst.insert(15);
		bst.insert(40);
		bst.insert(35);
		bst.insert(45);
		bst.inOrder(bst.root);
		System.out.println();
		bst.delete(20);
		bst.inOrder(bst.root);
		System.out.println();
	}
}
