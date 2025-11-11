package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


/**
 * A utility class providing methods to compute the top and bottom views of a binary tree.
 *
 * <strong>Top View:</strong>
 * Returns the list of nodes visible when the binary tree is viewed from the top.
 * The top view includes only the first node at each horizontal distance from the root.
 *
 * <strong>Bottom View:</strong>
 * Returns the list of nodes visible when the binary tree is viewed from the bottom.
 * The bottom view includes the last node at each horizontal distance from the root.
 *
 * <strong>How the methods work:</strong>
 * - Both the top and bottom view methods perform a breadth-first search (BFS)
 *   of the binary tree using a queue to process each level of the tree incrementally.
 * - Nodes are grouped by their horizontal distances (vertical levels) from the root node.
 * - For the top view, the first encountered node at each vertical level is selected.
 * - For the bottom view, the last encountered node at each vertical level is selected.
 * - A {@code TreeMap} is used to order the vertical levels from leftmost to rightmost.
 *
 * <strong>Parameters:</strong>
 * - {@code root}: The root of the binary tree as a {@code Tuple} object.
 *   A {@code Tuple} represents a tree node along with its vertical distance and level.
 *
 * <strong>Return values:</strong>
 * - For the top view, returns a list of integers representing the node values
 *   from the leftmost vertical level to the rightmost.
 * - For the bottom view, returns a list of integers representing the node values
 *   from the leftmost vertical level to the rightmost.
 *
 * <strong>Complexity:</strong>
 * - Time complexity: O(n), where n is the number of nodes in the binary tree,
 *   as each node is visited exactly once during the BFS traversal.
 * - Space complexity: O(w), where w is the maximum width of the tree,
 *   due to the queue used for BFS.
 *
 * <strong>Edge cases:</strong>
 * - For an empty tree (null root), returns an empty list.
 * - For a single-node tree, the result for both top view and bottom view
 *   will contain just the root node's value.
 * - For left-skewed or right-skewed trees, the top view and bottom view will be the same.
 */
public class TopBottomView {

  static class Tuple {
    public TreeNode node;
    public Integer vertical;
    public Integer level;

    public Tuple(TreeNode node, Integer vertical, Integer level) {
      this.node = node;
      this.vertical = vertical;
      this.level = level;
    }
  }

  public List<Integer> topView(Tuple root) {

    if (root == null) return List.of();

    final var ds = new TreeMap<Integer, Integer>(Integer::compareTo);

    final var queue = new ArrayDeque<Tuple>();
    queue.offerFirst(root);

    while (!queue.isEmpty()) {
      final var size = queue.size();
      for (int i = 0; i < size; i++) {
        final var tuple = queue.pollFirst();
        if (tuple.node.left != null) {
          queue.offerLast(new Tuple(tuple.node.left, tuple.vertical - 1, tuple.level + 1));
        }
        if (tuple.node.right != null) {
          queue.offerLast(new Tuple(tuple.node.right, tuple.vertical + 1, tuple.level + 1));
        }
        if (!ds.containsKey(tuple.vertical)) {
          ds.put(tuple.vertical, tuple.node.val);
        }
      }
    }

    final var result = new ArrayList<Integer>();
    for (final var verticalEntry : ds.entrySet()) {
      result.add(verticalEntry.getValue());
    }
    return result;
  }

  public List<Integer> bottomView(Tuple root) {

    if (root == null) return List.of();

    final var ds = new TreeMap<Integer, Integer>(Integer::compareTo);

    final var queue = new ArrayDeque<Tuple>();
    queue.offerFirst(root);

    while (!queue.isEmpty()) {
      final var size = queue.size();
      for (int i = 0; i < size; i++) {
        final var tuple = queue.pollFirst();
        if (tuple.node.left != null) {
          queue.offerLast(new Tuple(tuple.node.left, tuple.vertical - 1, tuple.level + 1));
        }
        if (tuple.node.right != null) {
          queue.offerLast(new Tuple(tuple.node.right, tuple.vertical + 1, tuple.level + 1));
        }
        ds.put(tuple.vertical, tuple.node.val);
      }
    }

    final var result = new ArrayList<Integer>();
    for (final var verticalEntry : ds.entrySet()) {
      result.add(verticalEntry.getValue());
    }
    return result;
  }
}
