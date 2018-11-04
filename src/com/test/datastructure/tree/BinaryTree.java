package com.test.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	
	// ǰ������ݹ�ķ�ʽ
	public void preOrder(BinaryTreeNode root) {
		if (null != root) {
			System.out.print(root.getData() + "\t");
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	// ǰ������ǵݹ�ķ�ʽ
	public void preOrderNonRecursive(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while (true) {
			while (root != null) {
				System.out.print(root.getData() + "\t");
				stack.push(root);
				root = root.getLeft();
			}
			if (stack.isEmpty())
				break;
			root = stack.pop();
			root = root.getRight();
		}
	}

	// ����������õݹ�ķ�ʽ
	public void inOrder(BinaryTreeNode root) {
		if (null != root) {
			inOrder(root.getLeft());
			System.out.print(root.getData() + "\t");
			inOrder(root.getRight());
		}
	}

	// ����������÷ǵݹ�ķ�ʽ
	public void inOrderNonRecursive(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.getLeft();
			}
			if (stack.isEmpty())
				break;
			root = stack.pop();
			System.out.print(root.getData() + "\t");
			root = root.getRight();
		}
	}

	// ����������õݹ�ķ�ʽ
	public void postOrder(BinaryTreeNode root) {
		if (root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getData() + "\t");
		}
	}

	// ����������÷ǵݹ�ķ�ʽ
	public void postOrderNonRecursive(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.getLeft();
			} else {
				if (stack.isEmpty())
					return;

				if (null == stack.lastElement().getRight()) {
					root = stack.pop();
					System.out.print(root.getData() + "\t");
					while (root == stack.lastElement().getRight()) {
						System.out.print(stack.lastElement().getData() + "\t");
						root = stack.pop();
						if (stack.isEmpty()) {
							break;
						}
					}
				}

				if (!stack.isEmpty())
					root = stack.lastElement().getRight();
				else
					root = null;
			}
		}
	}

	// �������
	public void levelOrder(BinaryTreeNode root) {
		BinaryTreeNode temp;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			temp = queue.poll();
			System.out.print(temp.getData() + "\t");
			if (null != temp.getLeft())
				queue.offer(temp.getLeft());
			if (null != temp.getRight()) {
				queue.offer(temp.getRight());
			}
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode node10 = new BinaryTreeNode(10, null, null);
		BinaryTreeNode node8 = new BinaryTreeNode(8, null, null);
		BinaryTreeNode node9 = new BinaryTreeNode(9, null, node10);
		BinaryTreeNode node4 = new BinaryTreeNode(4, null, null);
		BinaryTreeNode node5 = new BinaryTreeNode(5, node8, node9);
		BinaryTreeNode node6 = new BinaryTreeNode(6, null, null);
		BinaryTreeNode node7 = new BinaryTreeNode(7, null, null);
		BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
		BinaryTreeNode node3 = new BinaryTreeNode(3, node6, node7);
		BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

		BinaryTree tree = new BinaryTree();
		// ���õݹ�ķ�ʽ���б���
		System.out.println("-----ǰ�����------");
		tree.preOrder(node1);
		System.out.println();
		// ���÷ǵݹ�ķ�ʽ����
		tree.preOrderNonRecursive(node1);
		System.out.println();

		// ���õݹ�ķ�ʽ���б���
		System.out.println("-----�������------");
		tree.inOrder(node1);
		System.out.println();
		// ���÷ǵݹ�ķ�ʽ����
		tree.inOrderNonRecursive(node1);
		System.out.println();

		// ���õݹ�ķ�ʽ���б���
		System.out.println("-----�������------");
		tree.postOrder(node1);
		System.out.println();
		// ���÷ǵݹ�ķ�ʽ����
		tree.postOrderNonRecursive(node1);
		System.out.println();

		// ���õݹ�ķ�ʽ���б���
		System.out.println("-----�������------");
		tree.levelOrder(node1);
		System.out.println();
	}
}