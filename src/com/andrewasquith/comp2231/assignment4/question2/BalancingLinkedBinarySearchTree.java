package com.andrewasquith.comp2231.assignment4.question2;

/**
 * Import the iterator interface
 */
import java.util.Iterator;

/**
 * Import the classes this one extends
 */
import jsjf.BinaryTreeNode;
import jsjf.LinkedBinarySearchTree;

public class BalancingLinkedBinarySearchTree<T> extends LinkedBinarySearchTree<T> {

	
	/**
	 * Brute force tree balancing routine using an ordered array
	 * Builds the tree structure and then replacing the existing root node
	 */
	@SuppressWarnings("unchecked")
	private void bruteForceBalance() {
		
		//in order array of elements same size as tree
		T[] elementsInOrder = (T[]) new Object[size()];
		
		// counter for the iterator
		int currentIndex = 0;
		
		//get an array of the nodes in order
		Iterator<T> iter = iteratorInOrder();
		while (iter.hasNext()) {
			elementsInOrder[currentIndex] = iter.next();
			currentIndex++;
		}
		
		//build a new tree from the array nodes
		root = sortedArrayToTree(elementsInOrder, 0, size() - 1);
		
	}
	
	/**
	 * Recursive helper method to convert a sorted array into a new tree structure
	 * @param input the in order array of elements to form the new tree with
	 * @param start the starting index to use for the current pass
	 * @param end the ending index to use for the current pass
	 * @return new node with appropriate children
	 */
	private BinaryTreeNode<T> sortedArrayToTree(T[] input, int start, int end) {
		
		//if start > end stop recursing
		if (start > end) {
			return null;
		}
		
		//middle element of this part of the array is root of this tree
		int mid = (start + end) / 2;
		BinaryTreeNode<T>  newRoot = new BinaryTreeNode<T>(input[mid]);
		
		//recursively build the left sub tree from the left half of the array
		newRoot.setLeft(sortedArrayToTree(input, start, mid-1));
		
		//recursively build the right sub tree from the right half of the array
		newRoot.setRight(sortedArrayToTree(input, mid +1, end));
		
		//return the new root node
		return newRoot;
	}
	
	/**
	 * Override of addElement that calls balancing routine after parent implementation
	 */
	public void addElement(T element) {
		super.addElement(element);
		bruteForceBalance();
	}
	
	/**
	 * Override of removeElement that calls balancing routine after parent implementation
	 */
	public T removeElement(T targetElement) {
		T result = super.removeElement(targetElement);
		bruteForceBalance();
		return result;
	}
	
	/**
	 * Override of removeAllOccurrences that calls balancing routine after parent implementation
	 */
	public void removeAllOccurrences(T targetElement) {
		super.removeAllOccurrences(targetElement);
		bruteForceBalance();
	}
	
	/**
	 * Override of removeMax that calls balancing routine after parent implementation
	 */
	public T removeMax() {
		T result = super.removeMax();
		bruteForceBalance();
		return result;
	}
	
	/**
	 * Override of removeMin that calls balancing routine after parent implementation
	 */
	public T removeMin() {
		T result = super.removeMin();
		bruteForceBalance();
		return result;
	}
}
