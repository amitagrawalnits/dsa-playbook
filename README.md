# DSA Playbook — 10-Week Study Plan (Java) — Detailed
**Repo:** `dsa-playbook`  
**Package root:** `com.amit.cs`  
**Language:** Java 25, JUnit 5  

---
## How to use this plan
- Aim for **12–14 hrs/week** (≈90 min on weekdays, 3–4 hrs on the weekend).
- Ratio: **60% new**, **30% review**, **10% notes/cheatsheets**.
- One **class per problem**; multiple approaches as separate methods (`...Recursion`, `...DP`, etc.).
- Track every attempt in `DSA_Problem_Tracker.csv` and schedule revisits (+2d, +7d, +21d).
- Every week: **1 timed set**; from Week 4: **+1 mock**.

## Daily loop (≈90–120 min)
1. **Warm-up (10 min):** Revisit 2–3 due problems (filter by *Next Revisit*).
2. **New practice (60–75 min):** 3–4 E/M or 2 M/H from the week's topics.
3. **Post-mortem (10–15 min):** Write *Key Idea* and *Gotchas* in the tracker.
4. **Speed recap (5 min):** Outline a solution to an older problem without code.

## Week 1 — Trees Bootcamp
### Day 1 — Traversals & Basics
- Recursive + iterative inorder/preorder/postorder
- Level order (BFS) and `height()` implementation
- Practice 3–4 E/M: level order, max depth, balanced tree, inorder iterative

### Day 2 — Diameter & Path Sums
- Post-order pattern: return gain & update global
- Root-to-leaf vs any-path sums; negative handling
- Timed set: 4 mediums (diameter, path sum)

### Day 3 — BST Fundamentals
- Validate BST (range/prev), Kth smallest via inorder
- Optional: insert/delete for fluency
- Practice: validate BST, kth smallest, lowest greater

### Day 4 — LCA Patterns
- LCA (recursion) and LCA in BST (ordering)
- Parent-map variant; distance via LCA
- Mini-mock (30–40 min): 2 tree problems aloud

### Day 5 — Build & Serialize
- Build from inorder+preorder (hash map, O(n))
- Serialize/deserialize (BFS or preorder with nulls)
- Zigzag level order; update cheatsheet

### Day 6 — Views & Variants
- Left/Right view; Vertical order with column BFS
- N-ary traversal; boundary traversal (if time)
- Timed set: 5 mediums

### Day 7 — Tree DP & Wrap-up
- Tuples/paired states (e.g., House Robber III)
- Pseudo-palindromic paths; count good nodes
- Mock (60 min) + retrospective; log weak spots

---
## Week 2 — Arrays & Strings
### Day 1 — Two Pointers Essentials
- Opposite-ends sum, partitioning, fast/slow for arrays
- Practice: two-sum sorted, remove duplicates, container with most water
- Timed focus: 4 mediums (two pointers)

### Day 2 — Sliding Window I (fixed length)
- Fixed-size window: maintain counts/sums efficiently
- Practice: max sum subarray (size k), average, longest ones with k flips

### Day 3 — Sliding Window II (variable length)
- Shrink-to-fit invariant; at-most/at-least transformations
- Practice: longest substring without repeat, fruit into baskets

### Day 4 — Hashing Patterns
- Frequency maps, anagrams, prefix counts
- Practice: group anagrams, valid anagram, subarray sum equals k

### Day 5 — Prefix Sums & Differences
- 1D prefix; range add via diff arrays; 2D prefix briefly
- Practice: range addition, find pivot index, 2D prefix demo

### Day 6 — String Tricks
- Two-pointer palindromes; expand around center; K distinct chars
- Practice: valid palindrome, longest palindromic substring (outline + impl)

### Day 7 — Consolidation
- Timed set: 5 mediums mixing windows/two-pointers/prefix
- Notes: record invariants and common pitfalls

---
## Week 3 — Linked List / Stack / Queue
### Day 1 — Linked Lists I
- Dummy nodes, fast/slow, reverse list (iterative)
- Practice: reverse list, middle of list, merge two lists

### Day 2 — Linked Lists II
- Cycle detection (Floyd), reorder list, add two numbers
- Practice: linked list cycle, detect start of cycle

### Day 3 — Stacks Basics
- Monotonic stack next greater/smaller; parentheses validation
- Practice: next greater element, valid parentheses

### Day 4 — Monotonic Stack Harder
- Histogram/rectangle area, daily temperatures
- Practice: largest rectangle in histogram, daily temperatures

### Day 5 — Queues & Deque
- Queue with two stacks, sliding window maximum (deque)
- Practice: sliding window max, recent counter

### Day 6 — Stack/Queue Mix
- Evaluate RPN; min stack; implement queue/stack
- Practice set; tidy cheatsheet

### Day 7 — Timed & Review
- Timed set: 5 mediums (LL/stack/deque)
- Mini-mock (30–40 min)

---
## Week 4 — Binary Search & Sorting
### Day 1 — Binary Search Templates
- Index search (first/last), lower/upper bound patterns
- Practice: first/last position, search rotated array I

### Day 2 — Binary Search on Answer
- Monotonic predicate + shrink search space
- Practice: capacity to ship packages, Koko eating bananas

### Day 3 — Advanced Search
- Binary search on real answers (precision) & ternary (rare)
- Practice: median of two sorted arrays (outline + impl)

### Day 4 — Sorting + Greedy
- Custom comparators; sort by multiple keys
- Practice: meeting rooms, merge intervals (also Week 6)

### Day 5 — Prefix/Suffix & Diff Arrays
- Range updates; building from diffs
- Practice: car pooling (diff array), range addition

### Day 6 — Consolidation
- Timed set: 5 mediums (search/sort)
- Notes: template snippets; edge conditions

### Day 7 — Mock & Review
- Mock interview (search-heavy) + retrospective

---
## Week 5 — Recursion, Backtracking & Bit
### Day 1 — Recursion Patterns
- Base/choice/explore/unchoose; pruning
- Practice: subsets, permutations, combinations

### Day 2 — Backtracking I
- N-Queens style constraints; board validity checks
- Practice: combination sum, subset sum variants

### Day 3 — Backtracking II
- Word search; phone letter combinations; restore IP
- Practice set; focus on pruning for speed

### Day 4 — Bit Manipulation I
- Set/test/clear/isolate; parity; lowbit
- Practice: single number I/II/III, count bits

### Day 5 — Bit Tricks II
- Submask enumeration; bit DP intros
- Practice: subsets via bitmasks; two unique numbers

### Day 6 — Mix Day
- 2 backtracking + 2 bit problems
- Timed set: 5 mediums

### Day 7 — Review
- Mini-mock + notes consolidation

---
## Week 6 — Heaps, Intervals & DSU
### Day 1 — Heaps Basics
- Top-k, k-way merge, kth element; heapify
- Practice: top-k frequent elements, kth largest element

### Day 2 — More Heaps
- Streaming medians; merge k sorted lists (use PQ)
- Practice set; comparator correctness

### Day 3 — Intervals I
- Sort by start; merge; insert; meeting rooms
- Practice: merge intervals, meeting rooms I/II

### Day 4 — Intervals II + Sweep Line
- Line sweep with +1/-1 events; max overlap
- Practice: employee free time, car pooling

### Day 5 — DSU (Union-Find)
- Union by rank + path compression; connected components
- Practice: number of provinces, accounts merge

### Day 6 — Consolidation
- Timed set: 5 mediums (heap/interval/DSU)
- Refine cheatsheet

### Day 7 — Mock & Review
- Mock interview; focus on DS choice

---
## Week 7 — Graphs I
### Day 1 — Graph Basics
- Representations (adj list/matrix); BFS/DFS templates
- Practice: BFS in grid, number of islands

### Day 2 — Cycle Detection
- Undirected vs directed cycles, coloring technique
- Practice: course schedule (cycle), bipartite graph

### Day 3 — Topo Sort
- Kahn’s algorithm and DFS finishing order
- Practice: course schedule II, alien dictionary (outline)

### Day 4 — Grid BFS Patterns
- States with keys/doors; shortest path in binary matrix
- Practice: shortest path in grid with obstacles elimination (outline)

### Day 5 — Multisource BFS
- Rotting oranges; walls and gates
- Practice set

### Day 6 — Consolidation
- Timed set: 5 mediums (graphs I)
- Notes: visited timing, enqueue vs visit-time

### Day 7 — Mock & Review
- Mini-mock; concentrate on explaining visited-state invariant

---
## Week 8 — Graphs II
### Day 1 — Shortest Paths I
- Dijkstra with PQ; negative edges caveat
- Practice: network delay time, path with minimum effort

### Day 2 — Shortest Paths II
- Bellman-Ford; detect negative cycle
- Practice: bellman-ford template, cheapest flights within K stops

### Day 3 — All-Pairs & Variants
- Floyd–Warshall; path reconstruction idea
- Practice set; matrix DP view

### Day 4 — MST — Kruskal
- Sort edges + DSU; correctness via cut property
- Practice: min cost to connect points (Kruskal)

### Day 5 — MST — Prim
- Prim with PQ; dense vs sparse graphs
- Practice: connect all cities with min cost (Prim)

### Day 6 — Consolidation
- Timed set: 5 mediums (shortest paths/MST)
- Error log sweep

### Day 7 — Mock & Review
- Mock interview; graph algorithms choice justification

---
## Week 9 — Dynamic Programming I
### Day 1 — DP Basics
- State, transition, base, order, space cuts
- Practice: climbing stairs, house robber, coin change

### Day 2 — Knapsack Patterns
- 0/1 vs unbounded; order matters vs not
- Practice: coin change 2, target sum

### Day 3 — LIS & Variants
- DP O(n^2) and patience sorting O(n log n)
- Practice: LIS length + reconstruct sequence

### Day 4 — 1D Prefix/DP Mix
- Prefix DP, partition problems
- Practice: partition equal subset sum, min cost climbing stairs

### Day 5 — Optimization Tricks
- Rolling arrays; bitset knapsack teaser
- Practice: alcohol-free day for code refactors

### Day 6 — Consolidation
- Timed set: 5 mediums (DP I)
- Cheatsheet pass

### Day 7 — Mock & Review
- Mini-mock; focus on defining states crisply

---
## Week 10 — DP II + Review
### Day 1 — Grid DP
- Paths, min-cost, obstacles; boundary conditions
- Practice: unique paths I/II, min path sum

### Day 2 — Tree DP
- Rerooting taste + classic tuple DP
- Practice: house robber III, good nodes, diameter-style reframe

### Day 3 — Bitmask DP
- TSP-style and subsets DP; meet-in-the-middle idea
- Practice: count subsets with property; assignment DP (outline)

### Day 4 — Mix Day
- Two DP problems + one graphs/tree revisit from weak list
- Refactor notes

### Day 5 — Review Marathon
- Go through tracker: 15–20 key problems; re-solve quickly
- Fix persistent gotchas

### Day 6 — Final Mocks
- Mock 1: company-style set; Mock 2: general mix
- Timebox + debrief

### Day 7 — Wrap-up & Next Steps
- Finalize cheatsheets; mark long-term review list (+30/+60 days)
- Plan company-specific rounds & system design touch-up
---

## Weekly rituals
- **Mock cadence:** start Week 4, 1 per week; Week 10 run 2 mocks; rotate patterns (Trees/Graphs/DP).
- **Spaced repetition:** +2d → +7d → +21d after each successful revisit.
- **Quality bar per problem:** AC in time, note Key Idea & Gotchas, unit tests, revisit scheduled.
- **Timed set (75–90 min):** 5–6 mediums from current topics.
- **Cheatsheet updates (15–20 min):** Add/trim templates under `/docs/cheatsheets`.

## Topic totals to aim for (across 10 weeks)
- Arrays/Strings/Hashing: 45–50
- Two Pointers/Sliding Window: 25–30
- Linked List/Stack/Queue: 25–30
- Binary Search/Sorting/Prefix: 35–40
- Recursion/Backtracking/Bit: 30–35
- Trees/BST: 35–40
- Heaps/Intervals/DSU: 30–35
- Graphs (BFS/DFS/Topo/Shortest Paths/MST): 40–45
- Dynamic Programming (1-D, Knapsack, LIS, Grid, Tree, Bitmask): 50–55

## Java-specific checklist
- **Project:** Maven/Gradle with JUnit 5, Checkstyle, CI.
- **Package root:** `com.amit.cs`; topics: `.trees`, `.graphs`, `.dp`, etc.
- **Common models:** `TreeNode`, `ListNode`, `Pair`, `DisjointSet` in `com.amit.cs.common`.
- **Naming:** `LC0xxx_TitleCase`, variants as extra methods (`...Recursion`, `...ParentMap`, etc.).
- **Tests:** Mirror packages; parameterized where you have multiple methods per class.

## Mocks & milestones
- **Week 4:** First full mock (Trees/Arrays/Binary Search).
- **Week 6:** Graphs I mock; resume & project quick pass.
- **Week 8:** Graphs II + DP intro mock; fix weak areas.
- **Week 10:** Two mocks (company-style + general), finalize notes.

## Quality bar (per problem)
- ✅ AC within target time
- 🧠 Notes: *Key Idea* + *Gotchas* updated
- 🔁 Revisit scheduled
- 🧪 Unit tests cover main paths + edge cases

---

## Appendix — common templates (Java snippets)
**Validate BST (range)**
```java
boolean isBST(TreeNode n, long lo, long hi){
  if(n==null) return true;
  if(!(lo < n.val && n.val < hi)) return false;
  return isBST(n.left, lo, n.val) && isBST(n.right, n.val, hi);
}
```
**LCA (binary tree, recursion)**
```java
TreeNode lca(TreeNode r, TreeNode p, TreeNode q){
  if(r==null||r==p||r==q) return r;
  TreeNode L=lca(r.left,p,q), R=lca(r.right,p,q);
  return (L!=null && R!=null)? r : (L!=null ? L : R);
}
```
---

**Good luck! Ship daily, review weekly, and keep the notes tight.**