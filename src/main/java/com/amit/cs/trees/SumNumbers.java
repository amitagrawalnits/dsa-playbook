package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;


/**
 * This class provides a method to calculate the total sum of all root-to-leaf numbers
 * in a binary tree. Each root-to-leaf path represents a number, formed by concatenating
 * the node values along the path.

 * URL: https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 *
 * Key details:
 * - A helper method `wrapper` is used recursively to traverse the tree and compute the
 *   sum for each root-to-leaf path.
 * - At each node, the method keeps track of the current number being formed by
 *   multiplying the existing number by 10 and adding the current node's value.
 * - When a leaf node is reached, the current number is added to the cumulative sum.
 *
 * How it works:
 * - The `sumNumbers` method initializes the recursive process with a starting sum of 0.
 * - The `wrapper` method performs a depth-first traversal, updating the current number
 *   along the path.
 * - Upon reaching a leaf node, the number formed by the path is added to the total sum.
 *
 * Edge cases:
 * - If the tree is null or empty, the method returns 0.
 * - If the tree has only one node, the method returns the value of the root.
 *
 * Time complexity: O(n), where n is the total number of nodes in the tree. Each node
 * is visited once during the depth-first traversal.
 *
 * Space complexity: O(h), where h is the height of the tree. This space is used for the
 * recursion stack during the depth-first traversal. In the worst case, the height of the
 * tree can be n (for a skewed tree), and in the best case (balanced tree), the height
 * is log(n).
 */
public class SumNumbers {
  private int SUM = 0;

  public void wrapper(TreeNode root, int currentNumber) {
    if (root == null) return;
    if (root.left == null && root.right == null) {
      SUM = SUM + (currentNumber * 10 + root.val);
    }
    wrapper(root.left, currentNumber * 10 + root.val);
    wrapper(root.right, currentNumber * 10 + root.val);
  }

  public int sumNumbers(TreeNode root) {
    wrapper(root, 0);
    return SUM;
  }
}
