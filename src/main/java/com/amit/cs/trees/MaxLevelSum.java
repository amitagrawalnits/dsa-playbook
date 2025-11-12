package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;

import java.util.ArrayDeque;

/**
 * Determines the level in a binary tree with the maximum sum of node values.
 * URL: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
 *
 * This class provides a method for finding the level in a binary tree
 * where the sum of the node values is the largest. The level numbering
 * starts at 1 for the root level.
 * <p>
 * Key details:
 * - Uses a breadth-first search (BFS) or level-order traversal to calculate
 * the sum of node values at each level.
 * - The method iterates through all levels of the tree, comparing the sum
 * of the node values at each level.
 * - Maintains a record of the maximum sum encountered and the corresponding
 * level, updating these values when a new maximum is found.
 * <p>
 * How it works:
 * - A queue is used to traverse the tree level by level.
 * - For each level, the method computes the sum of the node values.
 * - If the sum for the current level is greater than the previously recorded
 * maximum sum, the maximum is updated along with the current level.
 * <p>
 * Edge cases:
 * - If the tree is null (empty), the method returns 0.
 * - If the tree has only one node, the method returns 1 as the root is the
 * only level and has the maximum sum.
 * <p>
 * Time complexity: O(n), where n is the total number of nodes in the tree. Each node
 * is processed exactly once.
 * Space complexity: O(w), where w is the maximum width of the tree, as determined
 * by the largest number of nodes at any single level.
 */
public class MaxLevelSum {

  public int maxLevelSum(TreeNode root) {
    if (root == null) return 0;

    int maxLevelSum = Integer.MIN_VALUE;
    int maxLevel = 0;
    int level = 0;

    final var queue = new ArrayDeque<TreeNode>();
    queue.add(root);

    while (!queue.isEmpty()) {
      level++;
      final var size = queue.size();
      int levelSum = 0;
      for (int i = 0; i < size; i++) {
        final var node = queue.pollFirst();
        levelSum += node.val;
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }

      if (levelSum > maxLevelSum) {
        maxLevelSum = levelSum;
        maxLevel = level;
      }
    }
    return maxLevel;
  }
}
