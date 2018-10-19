package com.test.datastructure;

public class BSTree<T extends Comparable<T>> {

	private class BSTNode<T extends Comparable<T>> {
		T key;
		BSTNode parent;
		BSTNode left;
		BSTNode right;
		
		public BSTNode(T key, BSTNode parent, BSTNode left, BSTNode right) {
			this.key = key;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
		
		public T getKey() {
			return this.key;
		}
		
		public String toString() {
			return "key: " + key;
		}
		
	}
	
	private BSTNode<T> root;
	
	public BSTree() {
		root = null;
	}
	
	private void preOrder(BSTNode root) {
		if (root != null) {
			System.out.print(root.getKey() + ", ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	public void preOrder() {
		preOrder(root);
	}
	
	private void inOrder(BSTNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.getKey() + ", ");
			inOrder(root.right);
		}
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	private void postOrder(BSTNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.getKey() + ", ");
		}
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	private BSTNode<T> search(BSTNode root, T key) {
		if (root == null) {
			return root;
		}
		int cmp = key.compareTo((T) root.getKey());
		if (cmp < 0) {
			return search(root.left, key);
		} else if (cmp > 0) {
			return search(root.right, key);
		} else {
			return root;
		}
	}
	
	public BSTNode search(T key) {
		return search(root, key);
	}
	
	private BSTNode<T> iterativeSearch(BSTNode root, T key) {
		int cmp;
		while (root != null) {
			cmp = key.compareTo((T) root.getKey());
			if (cmp < 0) {
				root = root.left;
			} else if (cmp > 0) {
				root = root.right;
			} else {
				return root;
			}
		}
		return root;
	}
	
	public BSTNode<T> iterativeSearch(T key) {
		return iterativeSearch(root, key);
	}
	
	private BSTNode<T> min(BSTNode root) {
		if (root == null) {
			return root;
		}
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
	
	public T min() {
		BSTNode node = min(root);
		if (node != null) {
			return (T) node.getKey();
		}
		return null;
	}
	
	private BSTNode<T> max(BSTNode root) {
		if (root == null) {
			return root;
		}
		while (root.right != null) {
			root = root.right;
		}
		return root;
	}
	
	public T max() {
		BSTNode node = max(root);
		if (node != null) {
			return (T) node.getKey();
		}
		return null;
	}
	
	public BSTNode<T> successor(BSTNode<T> root) {
		if (root.right != null) {
			return min(root.right);
		}
		BSTNode<T> x = root.parent;
		while (x != null && root == x.right) {
			root = x;
			x = x.parent;
		}
		return x;
	}
	
	public BSTNode<T> predecessor(BSTNode<T> root) {
		if (root.left != null) {
			return max(root.left);
		}
		BSTNode<T> x = root.parent;
		while (x != null && root == x.left) {
			root = x;
			x = x.parent;
		}
		return x;
	}
	
	private void insert(BSTree<T> tree, BSTNode<T> node) {
		int cmp;
		BSTNode<T> root = tree.root;
		BSTNode<T> tmp = null;
		while (root != null) {
			tmp = root;
			cmp = node.key.compareTo(root.key);
			if (cmp < 0) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		node.parent = tmp;
		if (tmp == null) {
			tree.root = node;
		} else {
			cmp = node.key.compareTo(tmp.key);
			if (cmp < 0) {
				tmp.left = node;
			} else {
				tmp.right = node;
			}
		}
	}
	
	public void insert(T key) {
		BSTNode<T> node = new BSTNode(key, null, null, null);
		if (node != null) {
			insert(this, node);
		}
	}
	
	private void remove(BSTree tree, BSTNode node) {
		BSTNode<T> x = null;
		BSTNode<T> y = null;
		if (node.left == null || node.right == null) {
			y = node;
		} else {
			y = successor(node);
		}
		if (y.left != null) {
			x = y.left;
		} else {
			x = y.right;
		}
		
	}
	
}
