package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Performs a breadth-first (level-order) traversal of a binary tree with
 * alternating per-level direction (a.k.a. “zigzag” or “spiral” level order).
 *
 * <p><strong>What it does:</strong> Visits nodes level by level from top to bottom.
 * On even levels (0-indexed) it reads left→right; on odd levels it reads right→left.
 * The result groups values per level, preserving this alternating order.</p>
 *
 * <p><strong>How it works (typical implementation):</strong>
 * Use a queue for BFS to isolate each level by snapshotting its size, and a
 * per-level buffer (often a deque) to place values at the front or back depending
 * on the current direction. Enqueue non-null children for the next level.</p>
 *
 * <p><strong>Return shape (when implemented):</strong>
 * a list of levels, where each inner list contains the node values for that level
 * in zigzag order.</p>
 *
 * <p><strong>Complexity (for a standard implementation):</strong>
 * Time <code>O(n)</code> where <code>n</code> is the number of nodes;
 * Space <code>O(w)</code> where <code>w</code> is the maximum width of the tree
 * (queue + per-level buffer).</p>
 *
 * <p><strong>Edge cases:</strong> null root (empty result), single node (one level),
 * skewed trees (each level has one node). Avoid building each level left→right and
 * reversing the list afterward—using a deque typically avoids extra copies.</p>
 *
 * <p><strong>Example:</strong></p>
 * <pre>{@code
 * // Tree:
 * //     1
 * //    / \
 * //   2   3
 * //  / \   \
 * // 4   5   6
 * //
 * // zigzagLevelOrder(root) -> [[1], [3, 2], [4, 5, 6]]
 * }</pre>
 *
 * <p><strong>Notes:</strong>
 * Keep the class focused on traversal; place shared node models (e.g., TreeNode)
 * under a common package (e.g., {@code com.amit.cs.common}).</p>
 *
 * @see LevelOrderTraversal
 * @since 1.0
 */
public class ZigzagLevelOrderTraversal {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    final var result = new ArrayList<List<Integer>>();
    if (root == null) return result;

    final var queue = new ArrayDeque<TreeNode>();
    queue.offer(root);

    var left = true;

    while (!queue.isEmpty()) {
      final var queueSize = queue.size();
      final var level = new ArrayList<Integer>(queueSize);

      if (left) {
        for (int i = 0; i < queueSize; i++) {
          final var node = queue.pollFirst();
          level.add(node.val);
          if (node.left != null) queue.offerLast(node.left);
          if (node.right != null) queue.offerLast(node.right);
        }
      } else {
        for (int i = 0; i < queueSize; i++) {
          final var node = queue.pollLast();
          level.add(node.val);
          if (node.right != null) queue.offerFirst(node.right);
          if (node.left != null) queue.offerFirst(node.left);
        }
      }
      result.add(level);
      left = !left;
    }
    return result;
  }
}
