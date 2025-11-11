package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindBottomLeftValueTest {

  /**
   * Unit tests for the FindBottomLeftValue class.
   * <p>
   * The `findBottomLeftValue` method finds the value of the leftmost node
   * in the last row of a binary tree. These tests verify correctness across
   * various structures, including balanced, skewed, and edge cases, ensuring
   * accuracy when identifying the leftmost value.
   */

  @Test
  void testSingleNodeTree() {
    TreeNode root = new TreeNode(1);
    FindBottomLeftValue solver = new FindBottomLeftValue();

    int result = solver.findBottomLeftValue(root);

    assertEquals(1, result, "The leftmost value in a single-node tree should be the root's value.");
  }

  @Test
  void testBalancedTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    FindBottomLeftValue solver = new FindBottomLeftValue();
    int result = solver.findBottomLeftValue(root);

    assertEquals(4, result, "The leftmost value in the last row of a balanced tree should be 4.");
  }

  @Test
  void testLeftSkewedTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);

    FindBottomLeftValue solver = new FindBottomLeftValue();
    int result = solver.findBottomLeftValue(root);

    assertEquals(3, result, "For a left-skewed tree, the leftmost value in the last row should be the leaf node.");
  }

  @Test
  void testRightSkewedTree() {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);

    FindBottomLeftValue solver = new FindBottomLeftValue();
    int result = solver.findBottomLeftValue(root);

    assertEquals(3, result, "For a right-skewed tree, the leftmost value in the last row is the leftmost leaf node (the only one).");
  }

  @Test
  void testComplexTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    root.left.right.left = new TreeNode(8);
    root.left.right.right = new TreeNode(9);

    FindBottomLeftValue solver = new FindBottomLeftValue();
    int result = solver.findBottomLeftValue(root);

    assertEquals(8, result, "In a complex tree, the leftmost value in the last row should be correctly found.");
  }

  @Test
  void testTreeWithMultipleLevelsSameStart() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(4);

    FindBottomLeftValue solver = new FindBottomLeftValue();
    int result = solver.findBottomLeftValue(root);

    assertEquals(4, result, "For a tree with multiple left levels, the leftmost value in the last row should be correctly returned.");
  }

  @Test
  void testTreeWithNegativeValues() {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(-1);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(-2);
    root.right.right = new TreeNode(2);

    FindBottomLeftValue solver = new FindBottomLeftValue();
    int result = solver.findBottomLeftValue(root);

    assertEquals(-2, result, "The method should handle negative values and return the correct leftmost value.");
  }
}