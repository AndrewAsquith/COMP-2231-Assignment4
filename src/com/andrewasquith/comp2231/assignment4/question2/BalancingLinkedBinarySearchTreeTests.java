/**
 * @author Andrew Asquith
 * COMP 2231
 * Assignment 4
 * Question 2 - BalancingLinkedBinarySearchTreeTests
 * Test harness for the BalancingLinkedBinarySearchTree class
 */
package com.andrewasquith.comp2231.assignment4.question2;

/**
 * Import the Junit Assertions and Setup/Teardown
 */
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test harness to ensure the brute force balancing 
 * implementation works as expected
 *
 */
public class BalancingLinkedBinarySearchTreeTests {

	/**
	 * Tree instance under test
	 */
	private BalancingLinkedBinarySearchTree<Integer> tree;

	@Before
	public void setUp() throws Exception {
		//create a new tree for each test
		tree = new BalancingLinkedBinarySearchTree<Integer>();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test of a tree with just the root element
	 */
	@Test
	public final void TestTreeWithOneElement() {
		tree.addElement(8);
		assertEquals(new Integer(8), tree.getRootElement());
	}
	
	/**
	 * Test of a tree with two elements 
	 * Balancing should make the second 
	 * element added the root
	 */
	@Test
	public final void TestTreeWithTwoElements() {
		tree.addElement(8);
		tree.addElement(4);
		// based on the balancing algorithm
		// the mid point will be 1/2 = 1 so the root should become 4
		// and the right subtree will have a root of 8
		assertEquals(new Integer(4), tree.getRootElement());
		assertNull(tree.getLeft());
		assertEquals(new Integer(8), tree.getRight().getRootElement());
	}

	/**
	 * Test of a tree with three elements
	 * Balancing should make the first element 
	 * added the root with the other two becoming leaf nodes
	 */
	@Test
	public final void TestTreeWithThreeElements() {
		tree.addElement(8);
		tree.addElement(4);
		tree.addElement(12);
		// based on the balancing the the tree should be
		//  8
		// 4 12
		assertEquals(new Integer(8), tree.getRootElement());
		assertEquals(new Integer(4), tree.getLeft().getRootElement());
		assertEquals(new Integer(12), tree.getRight().getRootElement());

	}

	/**
	 * Test of a tree with six elements added out of order
	 */
	@Test
	public final void TestTreeWithSixElements() {
		tree.addElement(8);
		tree.addElement(4);
		tree.addElement(12);
		tree.addElement(1);
		tree.addElement(3);
		tree.addElement(5);
		// after balancing the tree should look like
		//      4
		//   1     8
		//    3   5 12
		assertEquals(6, tree.size());
		assertEquals(3, tree.getHeight());
		assertEquals(new Integer(4), tree.getRootElement());
		assertEquals(new Integer(1), tree.getLeft().getRootElement());
		assertEquals(new Integer(3), tree.getLeft().getRight().getRootElement());
		assertEquals(new Integer(8), tree.getRight().getRootElement());
		assertEquals(new Integer(5), tree.getRight().getLeft().getRootElement());
		assertEquals(new Integer(12), tree.getRight().getRight().getRootElement());
	}

	/**
	 * Test of a tree with six elements out of order and the 
	 * resulting root being removed forcing a rebalancing
	 */
	@Test
	public final void TestTreeWithSixAdditionsAndRootRemoval() {
		tree.addElement(8);
		tree.addElement(4);
		tree.addElement(12);
		tree.addElement(1);
		tree.addElement(3);
		tree.addElement(5);
		tree.removeElement(4); //this should be the root at this point
		// after removal and balancing the tree should look like
		//       5
		//    1     8
		//      3     12
		// array looks like - 1 3 5 8 12 (roots are 5, 1, 8)
		assertEquals(5, tree.size());
		assertEquals(3, tree.getHeight());
		assertEquals(new Integer(5), tree.getRootElement());
		assertEquals(new Integer(1), tree.getLeft().getRootElement());
		assertNull(tree.getLeft().getLeft());
		assertEquals(new Integer(3), tree.getLeft().getRight().getRootElement());
		assertEquals(new Integer(8), tree.getRight().getRootElement());
		assertNull(tree.getRight().getLeft());
		assertEquals(new Integer(12), tree.getRight().getRight().getRootElement());
	}

	/**
	 * Test of a tree with multiple additions and removals
	 */
	@Test
	public final void TestTreeWithMultipleAdditionsAndRemovals() {
		tree.addElement(8);
		tree.addElement(4);
		tree.addElement(12);
		tree.addElement(1);
		tree.addElement(3);
		tree.addElement(5);
		tree.removeElement(4);
		tree.addElement(2);
		tree.addElement(6);
		tree.addElement(10);
		tree.addElement(14);
		tree.removeElement(10);
		//at the end the tree should look like this
		//
		//            5
		//      2           8
		//   1     3     6     12
		//                        14
		//
		assertEquals(8, tree.size());
		assertEquals(4, tree.getHeight());
		assertEquals(new Integer(5), tree.getRootElement());
		assertEquals(new Integer(2), tree.getLeft().getRootElement());
		assertEquals(new Integer(1), tree.getLeft().getLeft().getRootElement());
		assertEquals(new Integer(3), tree.getLeft().getRight().getRootElement());
		assertEquals(new Integer(8), tree.getRight().getRootElement());
		assertEquals(new Integer(6), tree.getRight().getLeft().getRootElement());
		assertEquals(new Integer(12), tree.getRight().getRight().getRootElement());
		assertEquals(new Integer(14), tree.getRight().getRight().getRight().getRootElement());
		assertEquals(new Integer(1), tree.findMin());
		assertEquals(new Integer(14), tree.findMax());
	}
}
