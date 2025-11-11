package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TopBottomViewTest {

  /**
   * Unit tests for the TopView class.
   * <p>
   * The `topView` method computes the top view of a binary tree by retrieving the first visible
   * nodes in the tree when viewed from above.
   * The `bottomView` method computes the bottom view of a binary tree by retrieving the last visible
   * nodes in the tree when viewed from above.
   * <p>
   * Each test ensures the correctness of these methods under various scenarios including edge cases,
   * balanced, skewed, and complex trees.
   */

  @Test
  void testSingleRootNode() {
    TreeNode root = new TreeNode(1);
    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.topView(tuple);

    assertEquals(List.of(1), result, "Top view for a single root node should contain only the root.");
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

    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.topView(tuple);

    assertEquals(List.of(4, 2, 1, 3, 7), result, "Top view for a balanced tree includes nodes visible from the top.");
  }

  @Test
  void testLeftSkewedTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);

    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.topView(tuple);

    assertEquals(List.of(3, 2, 1), result, "Top view of a left-skewed tree contains all nodes in order.");
  }

  @Test
  void testRightSkewedTree() {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);

    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.topView(tuple);

    assertEquals(List.of(1, 2, 3), result, "Top view of a right-skewed tree contains all nodes in order.");
  }

  @Test
  void testComplexTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(7);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.right.right.left = new TreeNode(8);
    root.right.right.right = new TreeNode(9);

    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.topView(tuple);

    assertEquals(List.of(7, 4, 2, 1, 3, 6, 9), result, "Top view of a complex tree should include only visible nodes from the top.");
  }

  @Test
  void testTreeWithOverlappingNodes() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.right = new TreeNode(5);

    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.topView(tuple);

    assertEquals(List.of(4, 2, 1, 3, 5), result, "Top view should handle overlapping nodes correctly.");
  }

  @Test
  void testTreeWithSingleChildPerLevel() {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    root.right.left.right = new TreeNode(4);

    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.topView(tuple);

    assertEquals(List.of(1, 2), result, "Top view of an irregular single-child-per-level tree should include the correct nodes.");
  }

  @Test
  void testTreeWithMultipleNodesOnSameVerticalLine() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(5);
    root.left.right.right = new TreeNode(6);
    root.right.left = new TreeNode(7);

    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.topView(tuple);

    assertEquals(List.of(2, 1, 3), result, "Top view should correctly select the first node for each vertical.");
  }

  @Test
  void testEmptyTree() {
    TopBottomView.Tuple tuple = null;
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.topView(tuple);

    assertEquals(List.of(), result, "Top view of an empty tree should produce an empty list.");
  }

  @Test
  void testTreeWithNegativeAndPositiveValues() {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(-1);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(-2);
    root.right.right = new TreeNode(2);

    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.topView(tuple);

    assertEquals(List.of(-2, -1, 0, 1, 2), result, "Top view with negative and positive values should handle ordering correctly.");
  }

  @Test
  void testBottomViewSingleRootNode() {
    TreeNode root = new TreeNode(1);
    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.bottomView(tuple);

    assertEquals(List.of(1), result, "Bottom view for a single root node should contain only the root.");
  }

  @Test
  void testBottomViewBalancedTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.bottomView(tuple);

    assertEquals(List.of(4, 2, 6, 3, 7), result, "Bottom view for a balanced tree includes nodes visible from the bottom.");
  }

  @Test
  void testBottomViewLeftSkewedTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);

    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.bottomView(tuple);

    assertEquals(List.of(3, 2, 1), result, "Bottom view of a left-skewed tree contains all nodes in order.");
  }

  @Test
  void testBottomViewRightSkewedTree() {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);

    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.bottomView(tuple);

    assertEquals(List.of(1, 2, 3), result, "Bottom view of a right-skewed tree contains all nodes in order.");
  }

  @Test
  void testBottomViewComplexTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.left.left = new TreeNode(7);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.right.right.left = new TreeNode(8);
    root.right.right.right = new TreeNode(9);

    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.bottomView(tuple);

    assertEquals(List.of(7, 4, 2, 5, 8, 6, 9), result, "Bottom view of a complex tree should include only visible nodes from the bottom.");
  }

  @Test
  void testBottomViewTreeWithOverlappingNodes() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.right.right = new TreeNode(5);

    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.bottomView(tuple);

    assertEquals(List.of(4, 2, 1, 3, 5), result, "Bottom view should handle overlapping nodes correctly.");
  }

  @Test
  void testBottomViewTreeWithSingleChildPerLevel() {
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    root.right.left.right = new TreeNode(4);

    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.bottomView(tuple);

    assertEquals(List.of(3, 4), result, "Bottom view of an irregular single-child-per-level tree should include only the bottom nodes.");
  }

  @Test
  void testBottomViewTreeWithMultipleNodesOnSameVerticalLine() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(5);
    root.left.right.right = new TreeNode(6);
    root.right.left = new TreeNode(7);

    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.bottomView(tuple);

    assertEquals(List.of(5, 7, 6), result, "Bottom view should correctly select the last node for each vertical.");
  }

  @Test
  void testBottomViewEmptyTree() {
    TopBottomView.Tuple tuple = null;
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.bottomView(tuple);

    assertEquals(List.of(), result, "Bottom view of an empty tree should produce an empty list.");
  }

  @Test
  void testBottomViewTreeWithNegativeAndPositiveValues() {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(-1);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(-2);
    root.right.right = new TreeNode(2);

    TopBottomView.Tuple tuple = new TopBottomView.Tuple(root, 0, 0);
    TopBottomView topBottomViewSolver = new TopBottomView();
    List<Integer> result = topBottomViewSolver.bottomView(tuple);

    assertEquals(List.of(-2, -1, 0, 1, 2), result, "Bottom view with negative and positive values should handle ordering correctly.");
  }
}