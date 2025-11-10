package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the SumOfLeftLeaves class.
 * The method computes the sum of all left leaves in a binary tree.
 */
public class SumOfLeftLeavesTest {

  @Test
  void testEmptyTree() {
    SumOfLeftLeaves solution = new SumOfLeftLeaves();
    TreeNode root = null;
    assertEquals(0, solution.sumOfLeftLeaves(root, false));
  }

  @Test
  void testSingleNodeTree() {
    SumOfLeftLeaves solution = new SumOfLeftLeaves();
    TreeNode root = new TreeNode(8);
    assertEquals(0, solution.sumOfLeftLeaves(root, false));
  }

  @Test
  void testTreeWithOnlyLeftChild() {
    SumOfLeftLeaves solution = new SumOfLeftLeaves();
    // Tree:   1
    //         /
    //        2
    TreeNode root = new TreeNode(1, new TreeNode(2), null);
    assertEquals(2, solution.sumOfLeftLeaves(root, false));
  }

  @Test
  void testTreeWithOnlyRightChild() {
    SumOfLeftLeaves solution = new SumOfLeftLeaves();
    // Tree:   1
    //          \
    //           3
    TreeNode root = new TreeNode(1, null, new TreeNode(3));
    assertEquals(0, solution.sumOfLeftLeaves(root, false));
  }

  @Test
  void testTreeWithMultipleLeftLeaves() {
    SumOfLeftLeaves solution = new SumOfLeftLeaves();
    // Tree:       1
    //           /   \
    //          2     3
    //         / \   / \
    //        4   5 6   7
    TreeNode root = new TreeNode(
      1,
      new TreeNode(2, new TreeNode(4), new TreeNode(5)),
      new TreeNode(3, new TreeNode(6), new TreeNode(7))
    );
    assertEquals(10, solution.sumOfLeftLeaves(root, false)); // Left leaves are 4 and 6
  }

  @Test
  void testLeftSkewedTree() {
    SumOfLeftLeaves solution = new SumOfLeftLeaves();
    // Tree: 1 -> 2 -> 3 -> 4 (all nodes are left-children)
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(4);
    assertEquals(4, solution.sumOfLeftLeaves(root, false)); // Only left leaf is 4
  }

  @Test
  void testRightSkewedTree() {
    SumOfLeftLeaves solution = new SumOfLeftLeaves();
    // Tree: 1 -> 2 -> 3 -> 4 (all nodes are right-children)
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);
    root.right.right.right = new TreeNode(4);
    assertEquals(0, solution.sumOfLeftLeaves(root, false)); // No left leaf
  }

  @Test
  void testTreeWithMixedNodes() {
    SumOfLeftLeaves solution = new SumOfLeftLeaves();
    // Tree:         1
    //             /   \
    //            2     3
    //           /     /   \
    //          4     5     6
    //               /
    //              7
    TreeNode root = new TreeNode(
      1,
      new TreeNode(2, new TreeNode(4), null),
      new TreeNode(3, new TreeNode(5, new TreeNode(7), null), new TreeNode(6))
    );
    assertEquals(11, solution.sumOfLeftLeaves(root, false)); // Left leaves: 4 and 7
  }

  @Test
  void testTreeWithOnlyLeavesOnRightChildren() {
    SumOfLeftLeaves solution = new SumOfLeftLeaves();
    // Tree:       10
    //              \
    //               12
    //                 \
    //                  14
    //                    \
    //                     16
    TreeNode root = new TreeNode(10);
    root.right = new TreeNode(12);
    root.right.right = new TreeNode(14);
    root.right.right.right = new TreeNode(16);
    assertEquals(0, solution.sumOfLeftLeaves(root, false)); // No left leaf nodes
  }

  @Test
  void testTreeWithNoLeaves() {
    SumOfLeftLeaves solution = new SumOfLeftLeaves();
    // Tree:    1
    //         / \
    //       2     3
    //      /
    //     4
    TreeNode root = new TreeNode(
      1,
      new TreeNode(2, new TreeNode(4), null),
      new TreeNode(3)
    );
    assertEquals(4, solution.sumOfLeftLeaves(root, false)); // Only one left leaf is 4
  }

  @Test
  void testTreeWithDeeplyNestedLeftLeaf() {
    SumOfLeftLeaves solution = new SumOfLeftLeaves();
    // Tree:       1
    //           /   \
    //         10     20
    //       /           \
    //      5             30
    //                     /
    //                    40
    TreeNode root = new TreeNode(
      1,
      new TreeNode(10, new TreeNode(5), null),
      new TreeNode(20, null, new TreeNode(30, new TreeNode(40), null))
    );
    assertEquals(45, solution.sumOfLeftLeaves(root, false)); // Only left leaf is 5
  }

  @Test
  void testTreeWithMultipleLevelsOfLeftLeaves() {
    SumOfLeftLeaves solution = new SumOfLeftLeaves();
    // Tree:         1
    //             /   \
    //           2       3
    //          / \     /
    //         4   5   8
    //            /
    //           6
    TreeNode root = new TreeNode(
      1,
      new TreeNode(2, new TreeNode(4), new TreeNode(5, new TreeNode(6), null)),
      new TreeNode(3, new TreeNode(8), null)
    );
    assertEquals(18, solution.sumOfLeftLeaves(root, false)); // Left leaves: 4, 6, 8
  }
}