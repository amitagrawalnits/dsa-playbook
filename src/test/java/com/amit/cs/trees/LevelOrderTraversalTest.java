package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LevelOrderTraversalTest {

  // --- Helpers ----------------------------------------------------------------

  /**
   * Build a binary tree from a level-order array (nulls allowed for gaps).
   * Example: [1,2,3,null,4] =>
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

  private static List<List<Integer>> LL(List<Integer>... levels) {
    return List.of(levels);
  }

  // --- Tests ------------------------------------------------------------------

  @Test
  void balancedTwoLevels() {
    LevelOrderTraversal s = new LevelOrderTraversal();
    TreeNode root = buildLevelOrder(1, 2, 3);
    assertEquals(LL(List.of(1), List.of(2, 3)), s.levelOrder(root));
  }

  @Test
  void skewedRight_chainProducesSingleElementLevels() {
    LevelOrderTraversal s = new LevelOrderTraversal();
    // 1 -> 2 -> 3 -> 4 (all right)
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);
    root.right.right.right = new TreeNode(4);
    assertEquals(LL(List.of(1), List.of(2), List.of(3), List.of(4)), s.levelOrder(root));
  }

  @Test
  void sampleFromJavadoc() {
    LevelOrderTraversal s = new LevelOrderTraversal();
    // Tree:
    //     1
    //    / \
    //   2   3
    //      / \
    //     4   5
    TreeNode r = new TreeNode(1);
    r.left = new TreeNode(2);
    r.right = new TreeNode(3);
    r.right.left = new TreeNode(4);
    r.right.right = new TreeNode(5);

    assertEquals(LL(List.of(1), List.of(2, 3), List.of(4, 5)), s.levelOrder(r));
  }

  @Test
  void treeNotModified_structureIntactAfterTraversal() {
    LevelOrderTraversal s = new LevelOrderTraversal();
    TreeNode r = buildLevelOrder(1, 2, 3, 4, 5, 6, 7);
    s.levelOrder(r); // call under test

    // Sanity: structure still intact
    assertEquals(1, r.val);
    assertEquals(2, r.left.val);
    assertEquals(3, r.right.val);
    assertEquals(4, r.left.left.val);
    assertEquals(5, r.left.right.val);
    assertEquals(6, r.right.left.val);
    assertEquals(7, r.right.right.val);
  }

  @Test
  void emptyTree_returnsEmptyList() {
    LevelOrderTraversal s = new LevelOrderTraversal();
    TreeNode root = null;

    var e = List.<List<Integer>>of();

    assertEquals(e, s.levelOrderUsingSizeVariable(root));
    assertEquals(e, s.levelOrder(root));
  }

  @Test
  void singleNode_oneLevel() {
    LevelOrderTraversal s = new LevelOrderTraversal();
    TreeNode r = new TreeNode(42);

    var e = LL(List.of(42));

    assertEquals(e, s.levelOrderUsingSizeVariable(r));
    assertEquals(e, s.levelOrder(r));
  }

  @Test
  void balancedThreeLevels() {
    LevelOrderTraversal s = new LevelOrderTraversal();
    //        1
    //      /   \
    //     2     3
    //    / \   / \
    //   4  5  6   7
    TreeNode r = buildLevelOrder(1, 2, 3, 4, 5, 6, 7);

    var e = LL(List.of(1), List.of(2, 3), List.of(4, 5, 6, 7));

    assertEquals(e, s.levelOrderUsingSizeVariable(r));
    assertEquals(e, s.levelOrder(r));
  }

  @Test
  void unbalancedWithGaps() {
    LevelOrderTraversal s = new LevelOrderTraversal();
    //      1
    //     / \
    //    2   3
    //     \
    //      4
    TreeNode r = buildLevelOrder(1, 2, 3, null, 4);

    var e = LL(List.of(1), List.of(2, 3), List.of(4));

    assertEquals(e, s.levelOrderUsingSizeVariable(r));
    assertEquals(e, s.levelOrder(r));
  }

  @Test
  void skewedLeft_chainProducesSingleElementLevels() {
    LevelOrderTraversal s = new LevelOrderTraversal();
    // 1 -> 2 -> 3 -> 4 (all left)
    TreeNode r = new TreeNode(1);
    r.left = new TreeNode(2);
    r.left.left = new TreeNode(3);
    r.left.left.left = new TreeNode(4);

    var e = LL(List.of(1), List.of(2), List.of(3), List.of(4));

    assertEquals(e, s.levelOrderUsingSizeVariable(r));
    assertEquals(e, s.levelOrder(r));
  }

  @Test
  void largerMixedTree_methodsProduceSameOutput() {
    LevelOrderTraversal s = new LevelOrderTraversal();
    //        10
    //      /    \
    //     5      15
    //    / \       \
    //   3   7       18
    //        \
    //         8
    TreeNode r = new TreeNode(10);
    r.left = new TreeNode(5);
    r.right = new TreeNode(15);
    r.left.left = new TreeNode(3);
    r.left.right = new TreeNode(7);
    r.right.right = new TreeNode(18);
    r.left.right.right = new TreeNode(8);

    var expected = LL(List.of(10), List.of(5, 15), List.of(3, 7, 18), List.of(8));

    var usingSize = s.levelOrderUsingSizeVariable(r);
    var streaming  = s.levelOrder(r);

    assertEquals(expected, usingSize);
    assertEquals(expected, streaming);
    // Redundant but explicit: both methods agree
    assertEquals(usingSize, streaming);
  }
}
