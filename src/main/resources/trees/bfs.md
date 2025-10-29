# Trees — BFS & Variants Cheatsheet

**Scope:** Level-order BFS on binary trees + common variants  
**Language:** Java, but concepts are language-agnostic  
**Pkg root:** `com.amit.cs`  
**Use when:** You need level-wise processing, per-level aggregates, tree “views,” vertical order, or shortest steps on tree-as-graph tasks.

---

## 1) Canonical BFS (Level-Order)

**Idea:**
- Maintain a **queue** of nodes.
- Process the tree **level by level**: before each level, record the current queue size; process exactly that many nodes; enqueue their children for the next level.
- Collect a result per level (or compute an aggregate within the level).

**Steps (high level):**
1. If root is empty, return empty result.
2. Push root to queue.
3. While queue not empty:
    - Record `levelSize` = number of nodes currently in queue.
    - Initialize an empty container for this level’s output.
    - Repeat `levelSize` times: pop a node, **use its value**, push its non-null children.
    - Append the level’s output to the final result.

**Complexity:**
- Time: `O(n)` (each node visited once)
- Space: `O(w)` (queue up to max width of the tree)

**Edge Cases:** empty tree, single node, skewed tree

---

## 2) Right / Left View

**Goal:** visible nodes when viewing the tree from the right/left side.

**Key differences from canonical BFS:**
- **Right view:** at each level, **capture the last node** processed.
- **Left view:** at each level, **capture the first node** processed.

**Return shape:** one list of values (one per level).

---

## 3) Zigzag Level-Order

**Goal:** alternate direction each level (left→right, then right→left, etc.).

**Key differences:**
- Keep a per-level container that **appends at end** for left→right levels and **prepends at front** for right→left levels (or reverse at the end — but avoid extra passes if possible).
- Flip a boolean toggle after each level.

**Return shape:** list of levels, each respecting the zigzag order.

---

## 4) Vertical Order (Column Index)

**Goal:** group nodes by **column**, top-to-bottom, left-to-right.

**Concepts:**
- Assign a column index to each node: `root = 0`, `left child = col - 1`, `right child = col + 1`.
- BFS ensures top-to-bottom order within a column naturally (ties may need extra rules depending on problem statement).
- Use an ordered mapping of `column → values` for final left-to-right column traversal.

**Return shape:** list of columns from smallest to largest index, each containing the nodes (top→bottom, tie rules per problem).

---

## 5) Level Aggregates (sum/avg/min/max per level)

**Goal:** compute an aggregate per level.

**Key differences:**
- During the per-level loop, maintain an accumulator (sum, count, min, max, etc.).
- After processing the level, push the aggregate into the result.

**Return shape:** list of numbers (one per level), or a single value depending on task.

---

## 6) Distance-K / Tree as Graph BFS

**Goal:** find all nodes at **distance K** from a target node.

**Concepts:**
- Treat the tree like an **undirected graph** by also allowing movement to the **parent** of a node.
- **Preprocess parent pointers** (via one pass DFS/BFS) to enable upward movement.
- Run BFS from the **target**; when the BFS depth equals **K**, return all nodes in that layer.
- Maintain a **visited set** to avoid revisiting parent/child nodes indefinitely.

**Return shape:** list of node values at distance K (order usually doesn’t matter unless specified).

---

## 7) Complexity Summary

**Symbols:**
- `n` = number of nodes
- `h` = tree height
- `w` = maximum width of the tree (max nodes at any level)
- `C` = number of non-empty vertical columns (for vertical order)

| Pattern / Task                      | Time Complexity                    | Space Complexity                         | Notes |
|------------------------------------|------------------------------------|------------------------------------------|------|
| **Canonical BFS (Level-Order)**    | `O(n)`                             | `O(w)`                                   | Queue holds at most one level. |
| **Right / Left View**              | `O(n)`                             | `O(w)`                                   | Same as level-order; capture first/last per level. |
| **Zigzag Level-Order**             | `O(n)`                             | `O(w)`                                   | Direction toggle per level; avoid per-level reversals when possible. |
| **Level Aggregates (sum/avg/max)** | `O(n)`                             | `O(w)`                                   | Aggregation done inside level loop. |
| **Vertical Order (basic)**         | `O(n + C log C)`                   | `O(w) + O(C)`                            | `C log C` if columns collected in a map/tree and iterated in order. |
| **Vertical Order (with row ties)** | `O(n log n)` (worst case)          | `O(w) + O(C)`                            | May need per-column sorting when tie rules require row/value ordering. |
| **Distance-K (tree as graph)**     | `O(n)` (parents) + `O(n)` (BFS)    | `O(w)` + `O(n)` (parent + visited maps)  | Build parent links once, then BFS over `{left,right,parent}`. |

**Auxiliary Costs**

- **Parent map build (for Distance-K):** `O(n)` time, `O(n)` space.
- **Recursion (if used to build parents):** stack space `O(h)`; switch to iterative to avoid deep recursion.

**Practical Bounds & Notes**

- `w ≤ n`, `h ≤ n − 1` (skewed tree).
- For balanced trees, `w = Θ(n)` only at the last level in the worst balanced cases; typical memory fits within `O(w)`.
- Vertical order that **only** groups by column (no complex tie rules) can be kept near `O(n)` time with a hash map + min/max column tracking and a final linear gather; ordered output still needs `O(C)` iteration.

---
## 8) Pitfalls (Checklist)

- Snapshot the **level size** before the inner loop; don’t let it change as you enqueue children.
- Don’t enqueue `null`.
- For vertical order, ensure consistent **column indexing** and a deterministic **column iteration order**.
- For distance-K, **must** track visited nodes (parent/child back-and-forth loops).
- Zigzag: make sure direction toggles correctly after each level.
- Large trees: BFS is iterative (stack overflow isn’t a concern), but parent-building with recursion can stack—use iterative if needed.
---

## 9) Testing Guide

**Basic cases**
- Empty tree → empty structure
- Single node → single level / single view value
- Perfect/Balanced tree (3–4 levels) → validates level boundaries

**Edge/Stress cases**
- Skewed tree (all-left or all-right) → validates width=1 behavior
- Vertical order ties (same column, different rows) → tie rules per statement
- Distance-K: `K=0` (target itself), `K` greater than height (should be empty), target at leaf/internal node

---

## 10) Logging (for your tracker)

- **Topic:** Trees
- **Pattern:** BFS-level / Right-View / Left-View / Zigzag / Vertical / Distance-K
- **Key Idea:** e.g., “Process by fixed level size; right view = last node per level.”
- **Gotchas:** e.g., “Forgot visited set for distance-K,” “Mixed levels by not fixing size.”
- **Revisit:** +2d → +7d → +21d

---

## 11) Links (fill as you add code)

- Level-order:
    - Class: `src/main/java/com/amit/cs/trees/LevelOrderTraversal.java`
    - Test: `src/test/java/com/amit/cs/trees/LevelOrderTraversalTest.java`
- Right/Left view:
    - Class: `src/main/java/com/amit/cs/trees/<ClassName_RightLeftView>.java`
- Zigzag:
    - Class: `src/main/java/com/amit/cs/trees/ZigzagLevelOrderTraversal.java`
    - Test: `src/test/java/com/amit/cs/trees/ZigzagLevelOrderTraversalTest.java`
- Vertical order:
    - Class: `src/main/java/com/amit/cs/trees/<ClassName_VerticalOrder>.java`
- Distance-K:
    - Class: `src/main/java/com/amit/cs/trees/<ClassName_DistanceK>.java`

---

**One-sentence summary:** BFS on trees = queue + process fixed-size levels; variants tweak **what** you collect per level (views, zigzag, aggregates) or add **state/parent links** (vertical order, distance-K).
