package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;
import com.amit.cs.trees.VerticalOrderTraversal.Tuple;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VerticalOrderTraversalTest {

  /**
   * Unit tests for the VerticalOrderTraversal class.
   * <p>
   * The `verticalTraversal` method computes the vertical order traversal of a binary tree,
   * grouping nodes by their vertical positions, then by level, and resolving conflicts
   * by sorting in ascending order of node values.
   * <p>
   * These tests verify correctness across various tree structures, including edge cases,
   * balanced trees, and skewed trees, ensuring correctness when handling overlapping or
   * shared node positions.
   */

  @Test
  void testEmptyTree() {
    Tuple root = null;
    VerticalOrderTraversal solver = new VerticalOrderTraversal();
    List<List<Integer>> result = solver.verticalTraversal(root);

    assertEquals(List.of(), result, "Vertical traversal of an empty tree should return an empty list.");
  }

  @Test
  void testSingleNodeTree() {
    TreeNode root = new TreeNode(1);
    Tuple tuple = new Tuple(root, 0, 0);
    VerticalOrderTraversal solver = new VerticalOrderTraversal();
    List<List<Integer>> result = solver.verticalTraversal(tuple);

    assertEquals(List.of(List.of(1)), result, "Vertical traversal of a single-node tree should only contain the root value.");
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

    Tuple tuple = new Tuple(root, 0, 0);
    VerticalOrderTraversal solver = new VerticalOrderTraversal();
    List<List<Integer>> result = solver.verticalTraversal(tuple);

    assertEquals(List.of(List.of(4), List.of(2), List.of(1, 5, 6), List.of(3), List.of(7)),
      result, "Vertical traversal of a balanced tree should group nodes by vertical position.");
  }

  @Test
  void testLeftSkewedTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);

    Tuple tuple = new Tuple(root, 0, 0);
    VerticalOrderTraversal solver = new VerticalOrderTraversal();
    List<List<Integer>> result = solver.verticalTraversal(tuple);

    assertEquals(List.of(List.of(3), List.of(2), List.of(1)),
      result, "Vertical traversal of a left-skewed tree should correctly return nodes from the leftmost to the root.");
  }

  @Test
  void testRightSkewedTree() {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);

    Tuple tuple = new Tuple(root, 0, 0);
    VerticalOrderTraversal solver = new VerticalOrderTraversal();
    List<List<Integer>> result = solver.verticalTraversal(tuple);

    assertEquals(List.of(List.of(1), List.of(2), List.of(3)),
      result, "Vertical traversal of a right-skewed tree should correctly return nodes from the root to the rightmost leaf.");
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

    Tuple tuple = new Tuple(root, 0, 0);
    VerticalOrderTraversal solver = new VerticalOrderTraversal();
    List<List<Integer>> result = solver.verticalTraversal(tuple);

    assertEquals(List.of(List.of(4), List.of(2, 8), List.of(1, 5, 6), List.of(3, 9), List.of(7)),
      result, "Vertical traversal of a complex tree should correctly order nodes by vertical level and priority.");
  }

  @Test
  void testTreeWithDuplicateVerticalAndLevel() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);

    Tuple tuple = new Tuple(root, 0, 0);
    VerticalOrderTraversal solver = new VerticalOrderTraversal();
    List<List<Integer>> result = solver.verticalTraversal(tuple);

    assertEquals(List.of(List.of(2), List.of(1, 4, 5), List.of(3), List.of(6)),
      result, "Vertical traversal with nodes sharing vertical and level should sort by value.");
  }

  @Test
  void testTreeWithNegativeAndPositiveValues() {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(-1);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(-2);
    root.right.right = new TreeNode(2);

    Tuple tuple = new Tuple(root, 0, 0);
    VerticalOrderTraversal solver = new VerticalOrderTraversal();
    List<List<Integer>> result = solver.verticalTraversal(tuple);

    assertEquals(List.of(List.of(-2), List.of(-1), List.of(0), List.of(1), List.of(2)),
      result, "Vertical traversal should handle both negative and positive values correctly.");
  }
}