package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;

import java.util.ArrayDeque;

/**
 * Finds the leftmost value in the last row of a binary tree.
 *
 * This class provides a method to compute the leftmost value in the bottom row
 * of a given binary tree using a level-order traversal (breadth-first search).
 *
 * <strong>How It Works:</strong>
 * - Performs a level-order traversal using a queue to process nodes level by level.
 * - At each level, the first node encountered is tracked as the potential leftmost value.
 * - Continues this process until reaching the last level of the tree.
 *
 * <strong>Edge Cases:</strong>
 * - If the tree consists of only one node, that node's value is the result.
 * - For larger trees, the method ensures that the first node of the last row is returned.
 *
 * <strong>Complexity*/
public class FindBottomLeftValue {

  public int findBottomLeftValue(TreeNode root) {
    var num = root.val;
    final var queue = new ArrayDeque<TreeNode>();
    queue.offerFirst(root);
    while (!queue.isEmpty()){
      final var size = queue.size();
      for (int i = 0; i < size; i++) {
        final var node = queue.pollFirst();
        if (node.left != null) queue.offerLast(node.left);
        if (node.right != null) queue.offerLast(node.right);
        if (i == 0) num = node.val;
      }
    }
    return num;
  }
}
