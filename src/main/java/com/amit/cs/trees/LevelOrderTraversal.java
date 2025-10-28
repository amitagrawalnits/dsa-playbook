package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Performs a breadth-first (level-order) traversal of a binary tree.
 *
 * <p><strong>What it does:</strong> Visits nodes level by level from the root down,
 * grouping node values by depth (level 0 = root, level 1 = children of root, etc.).</p>
 *
 * <p><strong>How it works:</strong> Uses a queue and processes one level at a time by first
 * snapshotting the current queue size (the number of nodes in this level), then
 * dequeuing exactly that many nodes while enqueuing their non-null children for the next level.</p>
 *
 * <p><strong>Return shape:</strong> A list of levels, where each inner list contains the values
 * of the nodes at that level in left-to-right order.</p>
 *
 * <p><strong>Complexity:</strong>
 * Time <code>O(n)</code> where <code>n</code> is the number of nodes;
 * Space <code>O(w)</code> where <code>w</code> is the maximum width of the tree (queue size).</p>
 *
 * <p><strong>Edge cases:</strong> If {@code root} is {@code null}, returns an empty list.</p>
 *
 * <p><strong>Examples:</strong></p>
 * <pre>{@code
 * // Tree:
 * //     1
 * //    / \
 * //   2   3
 * //      / \
 * //     4   5
 * //
 * // levelOrder(root) -> [[1], [2, 3], [4, 5]]
 * }</pre>
 *
 * @see #levelOrder(TreeNode)
 * @see java.util.ArrayDeque
 */
public class LevelOrderTraversal {

  public List<List<Integer>> levelOrderUsingSizeVariable(TreeNode root) {
    final var result = new ArrayList<List<Integer>>();

    if (root == null) {
      return result;
    }

    final var queue = new ArrayDeque<TreeNode>();
    queue.add(root);

    while (!queue.isEmpty()) {
      final var level = new ArrayList<Integer>();
      final var levelSize = queue.size();

      for (int i = 0; i < levelSize; i++) {
        final var node = queue.poll();
        level.add(node.val);

        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
      result.add(level);
    }

    return result;
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    final var result = new ArrayList<List<Integer>>();

    if (root == null) {
      return result;
    }

    final var queue = new ArrayDeque<TreeNode>();
    queue.add(root);

    while (!queue.isEmpty()) {
      final var level = new ArrayList<TreeNode>();
      while (!queue.isEmpty()) {
        final var node = queue.poll();
        level.add(node);
      }

      final var l = level.stream().peek(node -> {
          if (node.left != null) queue.offer(node.left);
          if (node.right != null) queue.offer(node.right);
        })
        .map(node -> node.val)
        .toList();
      result.add(l);
    }

    return result;
  }

}
