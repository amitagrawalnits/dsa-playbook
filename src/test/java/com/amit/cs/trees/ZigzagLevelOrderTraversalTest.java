package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZigzagLevelOrderTraversalTest {

  // ---------- Helpers ----------

  /**
   * Build a binary tree from a level-order array with nulls for gaps.
   * Example: [1,2,3,null,4] ->
   *     1
   *    / \
   *   2   3
   *    \
   *     4
   */
  private static TreeNode buildLevelOrder(Integer... vals) {
    if (vals == null || vals.length == 0 || vals[0] == null) return null;
    TreeNode root = new TreeNode(vals[0]);
    Deque<TreeNode> q = new ArrayDeque<>();
    q.offer(root);
    int i = 1;
    while (!q.isEmpty() && i < vals.length) {
      TreeNode cur = q.poll();
      if (i < vals.length && vals[i] != null) {
        cur.left = new TreeNode(vals[i]);
        q.offer(cur.left);
      }
      i++;
      if (i < vals.length && vals[i] != null) {
        cur.right = new TreeNode(vals[i]);
        q.offer(cur.right);
      }
      i++;
    }
    return root;
  }

  @SafeVarargs
  private static List<List<Integer>> LL(List<Integer>... levels) {
    return List.of(levels);
  }

  // ---------- Tests ----------

  @Test
  void emptyTree_returnsEmptyList() {
    ZigzagLevelOrderTraversal s = new ZigzagLevelOrderTraversal();
    assertEquals(List.of(), s.zigzagLevelOrder(null));
  }

  @Test
  void singleNode_oneLevel() {
    ZigzagLevelOrderTraversal s = new ZigzagLevelOrderTraversal();
    TreeNode r = new TreeNode(1);
    assertEquals(LL(List.of(1)), s.zigzagLevelOrder(r));
  }

  @Test
  void twoLevels_alternatesOnSecondLevel() {
    ZigzagLevelOrderTraversal s = new ZigzagLevelOrderTraversal();
    //    1
    //   / \
    //  2   3
    TreeNode r = buildLevelOrder(1, 2, 3);
    // Level 0: [1] (L->R), Level 1: [3,2] (R->L)
    assertEquals(LL(List.of(1), List.of(3, 2)), s.zigzagLevelOrder(r));
  }

  @Test
  void threeLevels_balancedTree() {
    ZigzagLevelOrderTraversal s = new ZigzagLevelOrderTraversal();
    //        1
    //      /   \
    //     2     3
    //    / \   / \
    //   4  5  6   7
    TreeNode r = buildLevelOrder(1, 2, 3, 4, 5, 6, 7);
    // L0: [1] (L->R)
    // L1: [3,2] (R->L)
    // L2: [4,5,6,7] (L->R)
    assertEquals(
        LL(List.of(1), List.of(3, 2), List.of(4, 5, 6, 7)),
        s.zigzagLevelOrder(r)
    );
  }

  @Test
  void unbalancedWithGaps_correctZigzagOrdering() {
    ZigzagLevelOrderTraversal s = new ZigzagLevelOrderTraversal();
    //      1
    //     / \
    //    2   3
    //     \
    //      4
    TreeNode r = buildLevelOrder(1, 2, 3, null, 4);
    // L0: [1]
    // L1: [3,2]
    // L2: [4]
    assertEquals(
        LL(List.of(1), List.of(3, 2), List.of(4)),
        s.zigzagLevelOrder(r)
    );
  }

  @Test
  void skewedLeft_chainProducesSingleElementLevels() {
    ZigzagLevelOrderTraversal s = new ZigzagLevelOrderTraversal();
    // 1 -> 2 -> 3 -> 4 (all left)
    TreeNode r = new TreeNode(1);
    r.left = new TreeNode(2);
    r.left.left = new TreeNode(3);
    r.left.left.left = new TreeNode(4);
    // Regardless of direction, each level has one node.
    assertEquals(
        LL(List.of(1), List.of(2), List.of(3), List.of(4)),
        s.zigzagLevelOrder(r)
    );
  }

  @Test
  void exampleFromJavadoc_likeStructure() {
    ZigzagLevelOrderTraversal s = new ZigzagLevelOrderTraversal();
    //     1
    //    / \
    //   2   3
    //  / \   \
    // 4   5   6
    TreeNode r = new TreeNode(1);
    r.left = new TreeNode(2);
    r.right = new TreeNode(3);
    r.left.left = new TreeNode(4);
    r.left.right = new TreeNode(5);
    r.right.right = new TreeNode(6);

    // L0: [1]
    // L1: [3,2]
    // L2: [4,5,6]
    assertEquals(
        LL(List.of(1), List.of(3, 2), List.of(4, 5, 6)),
        s.zigzagLevelOrder(r)
    );
  }
}
