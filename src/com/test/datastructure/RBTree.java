package com.test.datastructure;

/**
 * https://blog.csdn.net/eson_15/article/details/51144079
 * @author mhts
 * @date 2018年11月1日
 */
public class RBTree<T extends Comparable<T>> {

	private class Node<T extends Comparable<T>> {
		T value;
		boolean color;
		Node parent;
		Node left;
		Node right;
		
		public Node(T value, boolean color, Node parent, Node left, Node right) {
			this.value = value;
			this.color = color;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
		
		public T getValue() {
			return this.value;
		}
		
		@Override
		public String toString() {
			return value + (this.color ? "R" : "B");
		}
		
	}
	
	private Node<T> root;
	private static final boolean RED = false;
	private static final boolean BLACK = true;
	
	public RBTree() {
		this.root = null;
	}
	
	public Node<T> parentOf(Node<T> node) {
		return node != null ? node.parent : null;
	}
	
	public void setParent(Node<T> node, Node<T> parent) {
		if (node != null) {
			node.parent = parent;
		}
	}
	
	public boolean colorOf(Node<T> node) {
		return node != null ? node.color : BLACK;
	}
	
	public boolean isRed(Node<T> node) {
		return (node != null) && (node.color == RED) ? true : false;
	}
	
	public boolean isBlack(Node<T> node) {
		return !isRed(node);
	}
	
	public void setRed(Node<T> node) {
		if (node != null) {
			node.color = RED;
		}
	}
	
	public void setBlack(Node<T> node) {
		if (node != null) {
			node.color = BLACK;
		}
	}
	
	public void setColor(Node<T> node, boolean color) {
		if (node != null) {
			node.color = color;
		}
	}
	
	public void preOrder() {
		preOrder(root);
	}
	
	private void preOrder(Node<T> tree) {
		if (tree != null) {
			System.out.print(tree.value + " ");
			preOrder(tree.left);
			preOrder(tree.right);
		}
	}
	
	public void inOrder() {
		inOrder(root);
	}
	
	private void inOrder(Node<T> tree) {
		if (tree != null) {
			inOrder(tree.left);
			System.out.print(tree.value + " ");
			inOrder(tree.right);
		}
	}
	
	public void postOrder() {
		postOrder(root);
	}
	
	private void postOrder(Node<T> tree) {
		if (tree != null) {
			postOrder(tree.left);
			postOrder(tree.right);
			System.out.print(tree.value + " ");
		}
	}
	
	public Node<T> search(T value) {
		return search(root, value);
	}
	
	private Node<T> search(Node<T> current, T value) {
		while (current != null) {
			int cmp = current.value.compareTo(value);
			if (cmp < 0) {
				current = current.right;
			} else if (cmp > 0) {
				current = current.left;
			} else {
				return current;
			}
		}
		return current;
	}
	
	public T minValue() {
		Node<T> node = minNode(root);
		if (node != null) {
			return node.value;
		}
		return null;
	}
	
	private Node<T> minNode(Node<T> tree) {
		if (tree == null) {
			return null;
		}
		while (tree.left != null) {
			tree = tree.left;
		}
		return tree;
	}
	
	public T maxValue() {
		Node<T> node = maxNode(root);
		if (node != null) {
			return node.value;
		}
		return null;
	}
	
	private Node<T> maxNode(Node<T> tree) {
		if (tree == null) {
			return null;
		}
		while (tree.right != null) {
			tree = tree.right;
		}
		return tree;
	}
	
	public Node<T> successor(Node<T> x) {
		if (x.right != null) {
			return minNode(x.right);
		}
		
		Node<T> parent = x.parent;
		while (parent != null && x == parent.right) {
			x = parent;
			parent = x.parent;
		}
		return parent;
	}
	
	public Node<T> predecessor(Node<T> x) {
		if (x.left != null) {
			return maxNode(x.left);
		}
		
		Node<T> parent = x.parent;
		while (parent != null && x == parent.left) {
			x = parent;
			parent = x.parent;
		}
		return parent;
	}
	
	private void leftRotate(Node<T> x) {
		Node<T> y = x.right;
		x.right = y.left;
		if (y.left != null) {
			y.left.parent = x;
		}
		y.parent = x.parent;
		
		if (x.parent == null) {
			this.root = y;
		} else {
			if (x == x.parent.left) {
				x.parent.left = y;
			} else {
				x.parent.right = y;
			}
		}
		
		y.left = x;
		x.parent = y;
	}
	
	private void rightRotate(Node<T> y) {
		Node<T> x = y.left;
		y.left = x.right;
		if (x.right != null) {
			x.right.parent = y;
		}
		x.parent = y.parent;
		
		if (y.parent == null) {
			this.root = x;
		} else {
			if (y == y.parent.left) {
				y.parent.left = x;
			} else {
				y.parent.right = x;
			}
		}
		
		x.right = y;
		y.parent = x;
	}
	
	public void insert(T value) {
		Node<T> node=  new Node<T>(value, RED, null, null, null);
		if (node != null) {
			insert(node);
		}
	}
	
	private void insert(Node<T> node) {
		Node<T> parent = null;
		Node<T> current = this.root;
		
		while (current != null) {
			parent = current;
			int cmp = current.value.compareTo(node.value);
			if (cmp < 0) {
				current = current.right;
			} else {
				current = current.left;
			}
		}
		node.parent = parent;
		
		if (parent != null) {
			int cmp = parent.value.compareTo(node.value);
			if (cmp < 0) {
				parent.right = node;
			} else {
				parent.left = node;
			}
		} else {
			this.root = node;
		}
		
		insertFixup(node);
	}
	
	private void insertFixup(Node<T> node) {
		Node<T> parent, gParent;
		
		while (((parent = parentOf(node)) != null) && isRed(parent)) {
			gParent = parentOf(parent);
			
			if (parent == gParent.left) {
				Node<T> uncle = gParent.right;
				
				if (uncle != null && isRed(uncle)) {
					setBlack(parent);
					setBlack(uncle);
					setRed(gParent);
					node = gParent;
					continue;
				}
				
				if (node == parent.right) {
					leftRotate(parent);
					Node<T> tmp = parent;
					parent = node;
					node =  tmp;
				}
				
				setBlack(parent);
				setRed(gParent);
				rightRotate(gParent);
			} else {
				Node<T> uncle = parent.left;
				
				if (uncle != null && isRed(uncle)) {
					setBlack(parent);
					setBlack(uncle);
					setRed(gParent);
					node = gParent;
					continue;
				}
				
				if (node == parent.left) {
					rightRotate(parent);
					Node<T> tmp = parent;
					parent = node;
					node = tmp;
				}
				
				setBlack(parent);
				setRed(gParent);
				leftRotate(gParent);
			}
		}
		setBlack(this.root);
	}
	
	public void remove(T key) {
		Node<T> node;
		if ((node = search(root, key)) != null) {
			remove(node);
		}
	}
	
	private void remove(Node<T> node) {
		Node<T> parent, child;
		boolean color;
		
		if ((node.left != null) && (node.right != null)) {
			Node<T> successor = node;
			successor = successor.right;
			while (successor.left != null) {
				successor = successor.left;
			}
			
			if ((parent = parentOf(node)) != null) {
				if (node == parent.left) {
					parent.left = successor;
				} else {
					parent.right = successor;
				}
			} else {
				this.root = successor;
			}
			
			child = successor.right;
			parent = parentOf(successor);
			color = colorOf(successor);
			if (parent == node) {
				parent = successor;
			} else {
				if (child != null) {
					setParent(child, parent);
				}
				parent.left = child;
				successor.right = node.right;
				setParent(node.right, successor);
			}
			successor.parent = node.parent;
			successor.color = node.color;
			successor.left = node.left;
			node.left.parent = successor;
			
			if (color == BLACK) {
				removeFixup(child, parent);
			}
			
			node=  null;
			return;
		}
	}
	
	private void removeFixup(Node<T> child, Node<T> parent) {
		// TODO Auto-generated method stub
		
	}

	public void clear() {
		destroy(root);
		root = null;
	}
	
	private void destroy(Node<T> tree) {
		if (tree == null) {
			return;
		}
		if (tree.left != null) {
			destroy(tree.left);
		}
		if (tree.right != null) {
			destroy(tree.right);
		}
		tree = null;
	}
	
	public void print() {
		if (root != null) {
			print(root, root.value, 0);
		}
	}
	
	private void print(Node<T> tree, T value, int direction) {
		if (tree != null) {
			if (0 == direction) {
				System.out.printf("%2d(B) is root\n", tree.value);
			} else {
				System.out.printf("%2d(%s) is %2d's %6s child\n", tree.value, isRed(tree) ? "R" : "B", value, direction == 1 ? "right" : "left");
			}
			print(tree.left, tree.value, -1);
			print(tree.right, tree.value, 1);
		}
	}
	
	public static void main(String[] args) {
		int a[] = {10, 40, 30, 60, 90, 70, 20, 50, 80};
		boolean mDebugInsert = true;
		boolean mDebugDelete = true;
		int i, ilen = a.length;
        RBTree<Integer> tree = new RBTree<Integer>();

        System.out.printf("== 原始数据: ");
        for(i = 0; i < ilen; i++) {
            System.out.printf("%d ", a[i]);
        }
        System.out.printf("\n");

        for(i = 0; i < ilen; i++) {
           tree.insert(a[i]);
            // 设置mDebugInsert=true,测试"添加函数"
            if (mDebugInsert) {
                System.out.printf("== 添加节点: %d\n", a[i]);
                System.out.printf("== 树的详细信息: \n");
                tree.print();
                System.out.printf("\n");
            }
        }

        System.out.printf("== 前序遍历: ");
        tree.preOrder();

        System.out.printf("\n== 中序遍历: ");
        tree.inOrder();

        System.out.printf("\n== 后序遍历: ");
        tree.postOrder();
        System.out.printf("\n");

        System.out.printf("== 最小值: %s\n", tree.minValue());
        System.out.printf("== 最大值: %s\n", tree.maxValue());
        System.out.printf("== 树的详细信息: \n");
        tree.print();
        System.out.printf("\n");

        // 设置mDebugDelete=true,测试"删除函数"
//        if (mDebugDelete) {
//            for(i=0; i<ilen; i++)
//            {
//                tree.remove(a[i]);
//
//                System.out.printf("== 删除节点: %d\n", a[i]);
//                System.out.printf("== 树的详细信息: \n");
//                tree.print();
//                System.out.printf("\n");
//            }
//        }
	}
	
}
