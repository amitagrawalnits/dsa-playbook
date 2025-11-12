package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;

/**
 * This class provides methods to compute the maximum path sum in a binary tree.
 * The path can start and end at any node in the tree.
 *
 * URL: https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * Key details:
 * - The class maintains an internal state (`MAX`) to keep track of the maximum path sum
 *   encountered during the traversal of the tree.
 * - A helper method `wrapper` is used to recursively calculate the maximum path sum for any
 *   given node by considering the contributions of its left and right subtrees.
 *
 * How it works:
 * - The `maxPathSum` method initializes the process and delegates the computation to the
 *   helper method `wrapper`.
 * - The `wrapper` method computes the maximum sum branch that can be formed from the left
 *   and right subtrees of a node while ensuring each subtree's contribution is non-negative.
 * - At each node, the method calculates the potential contribution of the node by summing
 *   its value with the contributions from its left and right subtrees. This value is
 *   compared against the globally tracked `MAX` to update if it's larger.
 * - The method then returns the maximum contribution a node can give to its parent node,
 *   which is its value plus the maximum of its left and right subtree contributions.
 *
 * Edge cases:
 * - If the tree is null or empty, the method accounts for that internally when `wrapper`
 *   encounters a null node.
 * - If the tree contains only one node, the maximum path sum is the value of that single node.
 *
 * Return value:
 * The maximum path sum in the binary tree.
 *
 * Time complexity: O(n), where n is the total number of nodes in the tree. Each node is visited
 * exactly once during the traversal.
 *
 * Space complexity: O(h), where h is the height of the tree. This is due to the recursion stack
 * space used during the depth-first traversal. In the worst case, h can be n (for a skewed tree),
 * and in the best case (balanced tree), h is log(n).
 */
public class MaxPathSum {
  private int MAX = Integer.MIN_VALUE;

  public int wrapper(TreeNode root) {
    if (root == null)
      return 0;

    final var ls = Math.max(wrapper(root.left), 0);
    final var rs = Math.max(wrapper(root.right), 0);

    MAX = Math.max(MAX, ls + rs + root.val);

    return root.val + Math.max(ls, rs);
  }

  public int maxPathSum(TreeNode root) {
    wrapper(root);
    return MAX;
  }

}
