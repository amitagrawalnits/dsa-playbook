package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;

/**
 * This class calculates the diameter of a binary tree. The diameter is defined as the
 * length of the longest path between any two nodes in the tree. This path may or may
 * not pass through the root.
 *
 * URL: https://leetcode.com/problems/diameter-of-binary-tree/description/
 *
 * Key details:
 * - A helper method `wrapper` recursively computes the height of each subtree and
 *   updates the maximum diameter encountered during the traversal.
 * - The diameter of a binary tree is the sum of the left subtree height and the
 *   right subtree height for the node where the longest path occurs.
 * - The result is tracked using a class-level variable `MAX`.
 *
 * How it works:
 * - The `diameterOfBinaryTree` method initializes the recursive process by
 *   calling the `wrapper` method on the root node.
 * - The `wrapper` method performs a depth-first traversal of the tree,
 *   calculating the height of each subtree for every node.
 * - At each node, the sum of the heights of the left and right subtrees is
 *   compared to the current maximum diameter, and the maximum is updated
 *   if the current sum is larger.
 * - Finally, the maximum diameter is returned by the `diameterOfBinaryTree` method.
 *
 * Edge cases:
 * - If the tree is null or empty, the diameter is 0.
 * - If the tree has only one node, the diameter is 0, as there are no edges.
 *
 * Time complexity: O(n), where n is the total number of nodes in the tree.
 * Each node is visited once during the depth-first traversal.
 *
 * Space complexity: O(h), where h is the height of the tree. This space is used
 * for the recursion stack during the depth-first traversal. In the worst case,
 * the height of the tree can be n (for a skewed tree), and in the best case
 * (balanced tree), the height is log(n).
 */
public class DiameterOfBinaryTree {
  private int MAX = Integer.MIN_VALUE;

  public int wrapper(TreeNode root) {
    if (root == null) return 0;

    int lh = wrapper(root.left);
    int rh = wrapper(root.right);

    MAX = Math.max(MAX, lh + rh);

    return 1 + Math.max(lh, rh);
  }

  public int diameterOfBinaryTree(TreeNode root) {
    wrapper(root);
    return MAX;
  }

}
