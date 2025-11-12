package com.amit.cs.trees;

import com.amit.cs.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the MaxLevelSum class, which calculates the level in a binary tree
 * with the maximum sum of node values.
 */
public class MaxLevelSumTest {

  @Test
  public void testMaxLevelSum_SingleNode() {
    TreeNode root = new TreeNode(10);
    MaxLevelSum maxLevelSum = new MaxLevelSum();

    int result = maxLevelSum.maxLevelSum(root);

    assertEquals(1, result, "Single-node tree should return level 1.");
  }

  @Test
  public void testMaxLevelSum_TwoLevels() {
    TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
    MaxLevelSum maxLevelSum = new MaxLevelSum();

    int result = maxLevelSum.maxLevelSum(root);

    assertEquals(2, result, "Level 2 has the maximum sum (2 + 3).");
  }

  @Test
  public void testMaxLevelSum_UnbalancedTree() {
    TreeNode root = new TreeNode(1,
      new TreeNode(2, null, new TreeNode(4)),
      new TreeNode(3));
    MaxLevelSum maxLevelSum = new MaxLevelSum();

    int result = maxLevelSum.maxLevelSum(root);

    assertEquals(2, result, "Unbalanced tree with max sum at level 2.");
  }

  @Test
  public void testMaxLevelSum_NegativeValues() {
    TreeNode root = new TreeNode(-1,
      new TreeNode(-2),
      new TreeNode(-3, new TreeNode(-4), null));
    MaxLevelSum maxLevelSum = new MaxLevelSum();

    int result = maxLevelSum.maxLevelSum(root);

    assertEquals(1, result, "Negative-valued tree should return root level if it's the least negative.");
  }

  @Test
  public void testMaxLevelSum_LargeTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    MaxLevelSum maxLevelSum = new MaxLevelSum();

    int result = maxLevelSum.maxLevelSum(root);

    assertEquals(3, result, "Level 3 has the maximum sum (4+5+6+7).");
  }

  @Test
  public void testMaxLevelSum_NullTree() {
    TreeNode root = null;
    MaxLevelSum maxLevelSum = new MaxLevelSum();

    int result = maxLevelSum.maxLevelSum(root);

    assertEquals(0, result, "Null tree should return level 0.");
  }

  @Test
  public void testMaxLevelSum_MultipleMaxLevels() {
    TreeNode root = new TreeNode(1,
      new TreeNode(3, new TreeNode(7), new TreeNode(-6)),
      new TreeNode(2, new TreeNode(5), new TreeNode(2)));
    MaxLevelSum maxLevelSum = new MaxLevelSum();

    int result = maxLevelSum.maxLevelSum(root);

    assertEquals(3, result, "Level 3 has the maximum sum when multiple levels are valid.");
  }

  @Test
  public void testMaxLevelSum_SkewedLeft() {
    TreeNode root = new TreeNode(10,
      new TreeNode(20,
        new TreeNode(30,
          new TreeNode(40), null), null), null);
    MaxLevelSum maxLevelSum = new MaxLevelSum();

    int result = maxLevelSum.maxLevelSum(root);

    assertEquals(4, result, "Skewed left tree with level 4 having max sum (40).");
  }

  @Test
  public void testMaxLevelSum_SkewedRight() {
    TreeNode root = new TreeNode(10, null,
      new TreeNode(20, null,
        new TreeNode(30, null,
          new TreeNode(40))));
    MaxLevelSum maxLevelSum = new MaxLevelSum();

    int result = maxLevelSum.maxLevelSum(root);

    assertEquals(4, result, "Skewed right tree with level 4 having max sum (40).");
  }

  @Test
  public void testMaxLevelSum_AllZeroValues() {
    TreeNode root = new TreeNode(0,
      new TreeNode(0, new TreeNode(0), new TreeNode(0)),
      new TreeNode(0, new TreeNode(0), new TreeNode(0)));
    MaxLevelSum maxLevelSum = new MaxLevelSum();

    int result = maxLevelSum.maxLevelSum(root);

    assertEquals(1, result, "All sums are zero, so root level (1) is returned.");
  }

  @Test
  public void testMaxLevelSum_MixedPositiveAndNegativeValues() {
    TreeNode root = new TreeNode(1,
      new TreeNode(-5,
        new TreeNode(10),
        new TreeNode(-10)),
      new TreeNode(3,
        new TreeNode(-2),
        new TreeNode(6)));
    MaxLevelSum maxLevelSum = new MaxLevelSum();

    int result = maxLevelSum.maxLevelSum(root);

    assertEquals(3, result, "Level 3 has the maximum sum (10 + (-10) + (-2) + 6 = 4).");
  }

  @Test
  public void testMaxLevelSum_SingleBranchTree() {
    TreeNode root = new TreeNode(5,
      new TreeNode(10,
        new TreeNode(-15), null), null);
    MaxLevelSum maxLevelSum = new MaxLevelSum();

    int result = maxLevelSum.maxLevelSum(root);

    assertEquals(2, result, "Level 2 has the maximum sum (10).");
  }
}