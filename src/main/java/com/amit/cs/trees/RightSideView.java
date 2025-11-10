package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Obtain the rightmost view (from top to bottom) of a binary tree.
 *
 * <p><strong>What it does:</strong> For a binary tree, returns the list of values
 * for the nodes visible when the tree is viewed from the right side. From each level,
 * the rightmost node is selected.</p>
 *
 * <p><strong>How it works:</strong> Uses a breadth-first search (BFS, level-order traversal)
 * with a queue. Processes each level by examining all nodes in it from left to right,
 * only retaining the first node encountered at that level in the result, as it corresponds
 * to the rightmost node in the right-side view.</p>
 *
 * <p><strong>Return shape:</strong> A list of integers where each entry is the value of
 * the rightmost node in the corresponding level of the tree.</p>
 *
 * <p><strong>Complexity:</strong>
 * Time <code>O(n)</code>, where <code>n</code> is the total number of nodes in the tree;
 * Space <code>O(w)</code>, where <code>w</code> is the maximum width of the tree
 * (i.e., the maximum number of nodes at any level, which equals the maximum queue size).</p>
 *
 * <p><strong>Edge cases:</strong>
 * If the tree is empty (null root), an empty list is returned. For a single-node tree,
 * the result contains just that node. For skewed trees (all left or all right),
 * every node will be in the result.</p>
 *
 * <p><strong>Example:</strong>
 * Given the tree:
 *     1
 *    / \
 *   2   3
 *    \    \
 *     5    4
 * The result will be [1, 3, 4].</p>
 */
public class RightSideView {

  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) return List.of();

    final var result = new ArrayList<Integer>();
    final var queue = new ArrayDeque<TreeNode>();
    queue.offer(root);

    while (!queue.isEmpty()) {
      final var size = queue.size();
      for (int i = 0; i < size; i++) {
        final var s = queue.pollFirst();
        if (s.right != null) queue.offerLast(s.right);
        if (s.left != null) queue.offerLast(s.left);
        if (i == 0) result.add(s.val);
      }
    }
    return result;
  }
}
