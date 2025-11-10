package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the RightSideView class.
 *
 * <p>Tests the {@code rightSideView} method, which computes the right-side view of a binary tree.
 * The right-side view is defined as the set of node values visible when the tree is observed from the right side.
 *
 * <p>Edge cases such as an empty tree, a single-node tree, and highly unbalanced trees are validated.
 */
class RightSideViewTest {

  // Helper method to build a binary tree from level-order array representation
  private static TreeNode buildLevelOrder(Integer... vals) {
    if (vals == null || vals.length == 0 || vals[0] == null) return null;
    TreeNode root = new TreeNode(vals[0]);
    var queue = new java.util.ArrayDeque<TreeNode>();
    queue.offer(root);
    int i = 1;
    while (!queue.isEmpty() && i < vals.length) {
      TreeNode node = queue.poll();
      if (i < vals.length && vals[i] != null) {
        node.left = new TreeNode(vals[i]);
        queue.offer(node.left);
      }
      i++;
      if (i < vals.length && vals[i] != null) {
        node.right = new TreeNode(vals[i]);
        queue.offer(node.right);
      }
      i++;
    }
    return root;
  }

  @Test
  void testEmptyTree() {
    RightSideView solution = new RightSideView();
    TreeNode root = null;
    assertEquals(List.of(), solution.rightSideView(root));
  }

  @Test
  void testSingleNodeTree() {
    RightSideView solution = new RightSideView();
    TreeNode root = new TreeNode(1);
    assertEquals(List.of(1), solution.rightSideView(root));
  }

  @Test
  void testBalancedTree() {
    RightSideView solution = new RightSideView();
    // Tree:       1
    //           /   \
    //          2     3
    //         / \   / \
    //        4   5 6   7
    TreeNode root = buildLevelOrder(1, 2, 3, 4, 5, 6, 7);
    assertEquals(List.of(1, 3, 7), solution.rightSideView(root));
  }

  @Test
  void testLeftSkewedTree() {
    RightSideView solution = new RightSideView();
    // Tree: 1 -> 2 -> 3 -> 4 (all nodes form a left chain)
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(4);
    assertEquals(List.of(1, 2, 3, 4), solution.rightSideView(root));
  }

  @Test
  void testRightSkewedTree() {
    RightSideView solution = new RightSideView();
    // Tree: 1 -> 2 -> 3 -> 4 (all nodes form a right chain)
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);
    root.right.right.right = new TreeNode(4);
    assertEquals(List.of(1, 2, 3, 4), solution.rightSideView(root));
  }

  @Test
  void testUnbalancedTree() {
    RightSideView solution = new RightSideView();
    // Tree:       1
    //           /   \
    //          2     3
    //           \      \
    //            5      4
    TreeNode root = buildLevelOrder(1, 2, 3, null, 5, null, 4);
    assertEquals(List.of(1, 3, 4), solution.rightSideView(root));
  }

  @Test
  void testComplexUnbalancedTree() {
    RightSideView solution = new RightSideView();
    // Tree:         1
    //             /   \
    //            2     3
    //           /     / \
    //          4     5   6
    //           \         \
    //            7         8
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2, new TreeNode(4, null, new TreeNode(7)), null);
    root.right = new TreeNode(3, new TreeNode(5), new TreeNode(6, null, new TreeNode(8)));
    assertEquals(List.of(1, 3, 6, 8), solution.rightSideView(root));
  }
}