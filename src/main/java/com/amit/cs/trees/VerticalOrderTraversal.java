package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;

import java.util.*;

/**
 * Computes the vertical order traversal of a binary tree.
 *
 * What it does:
 * This method returns the vertical order traversal of a binary tree, which groups
 * the nodes based on their vertical columns viewed from top to bottom. Nodes in
 * the same vertical column are further grouped by their depth (distance from the root).
 * If nodes share the same vertical column and depth, they are sorted in ascending order
 * by their value.
 *
 * How it works:
 * - A level-order traversal using a queue is performed to process the tree nodes.
 * - Each node is associated with its vertical and level positions, encapsulated in a `Tuple`.
 * - A nested data structure (TreeMap of TreeMap with PriorityQueue) is used
 *   to store nodes:
 *   - The outer TreeMap organizes nodes by vertical columns.
 *   - Each vertical column contains another TreeMap that groups nodes by their
 *     level depth.
 *   - The PriorityQueue ensures nodes at the same vertical column and level depth
 *     are sorted by their values.
 * - After traversing the entire tree, the stored nodes are extracted from the
 *   data structure and flattened into a list of lists, ordered by vertical columns
 *   from leftmost to rightmost.
 *
 * Edge cases:
 * - If the tree is empty (null root), an empty list is returned.
 * - For single-node trees, the result contains a single list with only that node's value.
 * - Ties are resolved as follows:
 *   - If nodes have the same vertical and level positions, values are sorted in ascending order.
 *
 * Complexity:
 * - Time complexity: O(n * log(n)), where n is the number of nodes in the tree.
 *   The TreeMap and PriorityQueue operations introduce additional logarithmic complexity.
 * - Space complexity: O(n), due to the storage of nodes in the TreeMap and
 *   the queue used during traversal.
 *
 * @param root A `Tuple` representing the root of the binary tree with its associated
 *             vertical and level positions. The `node` property of the `Tuple` should
 *             be the `TreeNode` representing the root of the binary tree.
 * @return A list of lists, where each inner list contains the node values of a
 *         specific vertical column ordered from top to bottom and left to right.
 */
public class VerticalOrderTraversal {

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

  public List<List<Integer>> verticalTraversal(Tuple root) {

    if (root == null) return List.of();

    final var ds = new TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>>(Integer::compareTo);

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
          final var pq = new PriorityQueue<Integer>();
          pq.offer(tuple.node.val);
          final var levelMap = new TreeMap<Integer, PriorityQueue<Integer>>(Integer::compareTo);
          levelMap.put(tuple.level, pq);
          ds.put(tuple.vertical, levelMap);
        }else {
          final var levelMap = ds.get(tuple.vertical);
          if (!levelMap.containsKey(tuple.level)) {
            final var pq = new PriorityQueue<Integer>();
            pq.offer(tuple.node.val);
            levelMap.put(tuple.level, pq);
          }else {
            levelMap.get(tuple.level).offer(tuple.node.val);
          }
        }
      }
    }

    final var result = new ArrayList<List<Integer>>();
    for (final var verticalEntry : ds.entrySet()) {
      final var list = new ArrayList<Integer>();
      for (final var levelEntry: verticalEntry.getValue().entrySet()) {
        while (!levelEntry.getValue().isEmpty()){
          list.add(levelEntry.getValue().remove());
        }
      }
      result.add(list);
    }
    return result;
  }
}
