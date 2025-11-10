package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;

/**
 * Computes the sum of all left leaf nodes in a binary tree.
 *
 * <strong>What it does:</strong> Traverses the binary tree recursively, identifying and summing the values
 * of all left leaf nodes (nodes that are left children and do not have any children themselves).
 *
 * <strong>How it works:</strong>
 * - If the current node is null, returns 0 (base case).
 * - If the current node is a leaf (both left and right children are null) and is identified as a left child,
 * its value is added to the sum; otherwise, 0 is returned.
 * - The method recursively processes the left child with the {@code isLeft} flag set to {@code true}
 * and the right child with the {@code isLeft} flag set to {@code false}.
 * - Returns the total sum by combining the results from the left and right subtrees.
 *
 * <strong>Return value:</strong> The integer sum of all left leaf nodes.
 *
 * <strong>Complexity:</strong>
 * - Time complexity: O(n), where n is the number of nodes in the tree. Each node is visited exactly once.
 * - Space complexity: O(h), where h is the height of the tree, due to the recursive call stack.
 *
 * <strong>Edge cases:</strong>
 * - If the tree is empty (root is null), the method returns 0.
 * - If the tree contains only one node (the root), the method returns 0 since it has no leaves.
 *
 * @param root   The root of the binary tree.
 * @param isLeft A boolean flag indicating whether the current node is a left child.
 * @return The sum of all left leaf node values in the binary tree.
 */
public class SumOfLeftLeaves {

  public int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) {
      if (isLeft) return root.val;
      else return 0;
    }

    final var left = sumOfLeftLeaves(root.left, true);
    final var right = sumOfLeftLeaves(root.right, false);
    return left + right;
  }
}
