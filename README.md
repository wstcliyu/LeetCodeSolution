# LeetCodeSolution

1. [Topics](#topics)
2. [Solutions](#solutions)

## Topics
- Add Two Numbers (Textbook Addition)
	- Linked List: 2, 445(reverse twice)
	- String: 67, 415
	- Array: 66, 989
- Backtrack
	- Regular: 17, 39(40), 46(47), 78(90), 216, 254
	- HashSet: 491
	- Memoization: 638
	- Count: 1079
- BFS
	- Regular: 200
	- Topological Sort: 310
- Binary Search Tree (BST)
	- In-order successor (pred): 285, 510
	- Search: 700
	- Insert: 701
	- Delete: 450
- Binary Tree
	- Traversal
		- Level-order: 102(103, 107)
		- Pre-order: 144
		- Post-order: 145
		- In-order: 94, 897
	- App
		- Pre-order: 257, 404, 671, 872
		- Post-order: 104, 1022, 1026, 1302
	- Serialize/Deserialize
		- 572, 606
	- Lowest Common Ancestor (LCA)
		- 235, 236(1676), 1123(865), 1644, 1650(160)
	- Path Sum
		- 112
- Bit Manipulation
	- Add Two Numbers: 67, 371
	- Regular: 136，137, 260
- Bitmask
	- App: 78(90)
- Design
	- (De)Queue: 622, 641
- DFS
	- Regular: 79, 200
	- Memoization: 329
- Dynamic Programming (DP)
	- 2D: 1738
- Greedy
	- Regular: 280
- Hash Table
	- Design: 706(705 BST)
- Linked List
	- Cycle: 142(141)
	- Reverse: 234(206), 92, 143
	- Merge: 21(23), 148
	- Intersection: 160(1650)
	- Trick: 237
	- Doubly Linked List (DDL): 146, 1472
- Math
	- Regular: 775
- Mono Queue/Stack
	- Mono Queue: 239
- Priority Queue
	- Regular: 692
- Quick Select
	- Regular: 215, 347, 973
- Rejection Sampling
	- Regualr: 470
- Reservoir Sampling
	- Regular: 382, 398
- Sliding Window
	- Fixed: 30, 438, 567, 1100
	- Max: 3, 159, 340, 424, 1004
	- Min: 76, 209
- Stack
	- Two Stack: 1472
- Topological Sort
	- Regular: 207, 210, 269, 329, 1136
	- BFS: 310
	- Reverse: 802
- TreeMap
	- App: 1146
- Trie
	- Regular: 208, 211, 212, 692
- Two Pointers
	- Regular: 27, 125(680), 1570
- Two Sum
	- Regular: 1099
	- BST: 653
- Union Find
	- Regular: 305(200), 684(685)


## Solutions
|  #  | Title | Problem | Difficulty | Java | Python | Go | Topic |
|:---:|:------|:-------:|:----------:|:----:|:------:|:--:|:------|
|    2| [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Add_2.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Add_2.java) |  |  | Linked List |
|    3| [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Longest_3.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Longest_3.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Longest_3.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Longest_3.go) | Sliding Window(Max) |
|   17| [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Letter_17.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Letter_17.java) |  |  | Backtrack |
|   21| [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Merge_21.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Merge_21.java) |  |  | Linked List |
|   23| [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Merge_23.md) | Hard | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Merge_23.java) |  |  | Linked List |
|   27| [Remove Element](https://leetcode.com/problems/remove-element/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Remove_27.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Remove_27.java) |  |  | Two Pointers |
|   30| [Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Substring_30.md) | Hard | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Substring_30.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Substring_30.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Substring_30.go) | Sliding Window(Fixed) |
|   39| [Combination Sum](https://leetcode.com/problems/combination-sum/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Combination_39.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Combination_39.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Combination_39.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Combination_39.go) | Backtrack |
|   40| [Combination Sum II](https://leetcode.com/problems/combination-sum-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Combination_40.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Combination_40.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Combination_40.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Combination_40.go) | Backtrack |
|   46| [Permutations](https://leetcode.com/problems/permutations/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Permutations_46.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Permutations_46.java) |  |  | Backtrack |
|   47| [Permutations II](https://leetcode.com/problems/permutations-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Permutations_47.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Permutations_47.java) |  |  | Backtrack |
|   66| [Plus One](https://leetcode.com/problems/plus-one/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Plus_66.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Plus_66.java) |  |  | Add Two Numbers |
|   67| [Add Binary](https://leetcode.com/problems/add-binary/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Add_67.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Add_67.java) |  |  | Add Two Numbers |
|   76| [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Minimum_76.md) | Hard | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Minimum_76.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Minimum_76.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Minimum_76.go) | Sliding Window(Min) |
|   78| [Subsets](https://leetcode.com/problems/subsets/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Subsets_78.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Subsets_78.java) |  |  | Backtrack, Bitmask |
|   79| [Word Search](https://leetcode.com/problems/word-search/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Word_79.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Word_79.java) |  |  | DFS |
|   90| [Subsets II](https://leetcode.com/problems/subsets-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Subsets_90.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Subsets_90.java) |  |  | Backtrack |
|   94| [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Binary_94.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Binary_94.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Binary_94.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Binary_94.go) | Binary Tree(In-order traversal) |
|  102| [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Binary_102.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Binary_102.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Binary_102.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Binary_102.go) | Binary Tree(Level-order traversal) |
|  103| [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Binary_103.md) | Medium |  |  |  | Binary Tree(Level-order traversal) |
|  104| [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Maximum_104.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Maximum_104.java) |  |  | Binary Tree |
|  107| [Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Binary_107.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Binary_107.java) |  |  | Binary Tree(Level-order traversal) |
|  112| [Path Sum](https://leetcode.com/problems/path-sum/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Path_112.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Path_112.java) |  |  | Binary Tree |
|  125| [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Valid_125.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Valid_125.java) |  |  | Two Pointers |
|  136| [Single Number](https://leetcode.com/problems/single-number/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Single_136.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Single_136.java) |  |  | Bit Manipulation |
|  137| [Single Number II](https://leetcode.com/problems/single-number-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Single_137.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Single_137.java) |  |  | Bit Manipulation |
|  141| [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Linked_141.md) | Easy |  |  | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Linked_141.go) | Linked List |
|  142| [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Linked_142.md) | Medium |  |  | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Linked_142.go) | Linked List |
|  144| [Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Binary_144.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Binary_144.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Binary_144.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Binary_144.go) | Binary Tree(Pre-order traversal) |
|  145| [Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Binary_145.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Binary_145.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Binary_145.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Binary_145.go) | Binary Tree(Post-order traversal) |
|  146| [LRU Cache](https://leetcode.com/problems/lru-cache/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/LRU_146.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/LRU_146.java) |  |  | Linked List |
|  148| [Sort List](https://leetcode.com/problems/sort-list/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Sort_148.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Sort_148.java) |  |  | Linked List |
|  159| [Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Longest_159.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Longest_159.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Longest_159.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Longest_159.go) | Sliding Window(Max) |
|  160| [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Intersection_160.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Intersection_160.java) |  |  | Linked List |
|  200| [Number of Islands](https://leetcode.com/problems/number-of-islands/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Number_200.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Number_200.java) |  |  | DFS, BFS, Union Find |
|  207| [Course Schedule](https://leetcode.com/problems/course-schedule/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Course_207.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Course_207.java) |  |  | Topological Sort |
|  208| [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Implement_208.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Implement_208.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Implement_208.py) |  | Trie |
|  209| [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Minimum_209.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Minimum_209.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Minimum_209.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Minimum_209.go) | Sliding Window(Min) |
|  210| [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Course_210.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Course_210.java) |  |  | Topological Sort |
|  211| [Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Design_211.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Design_211.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Design_211.py) |  | Trie |
|  212| [Word Search II](https://leetcode.com/problems/word-search-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Word_212.md) | Hard | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Word_212.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Word_212.py) |  | Trie, DFS |
|  215| [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Kth_215.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Kth_215.java) |  |  | Quick Select, Heap |
|  216| [Combination Sum III](https://leetcode.com/problems/combination-sum-iii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Combination_216.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Combination_216.java) |  |  | Backtrack |
|  234| [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Palindrome_234.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Palindrome_234.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Palindrome_234.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Palindrome_234.go) | Linked List |
|  235| [Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Lowest_235.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Lowest_235.java) |  |  | Lowest Common Ancestor |
|  236| [Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Lowest_236.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Lowest_236.java) |  |  | Lowest Common Ancestor |
|  239| [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Sliding_239.md) | Hard | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Sliding_239.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Sliding_239.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Sliding_239.go) | Mono queue |
|  254| [Factor Combinations](https://leetcode.com/problems/factor-combinations/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Factor_254.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Factor_254.java) |  |  | Backtrack |
|  257| [Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Binary_257.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Binary_257.java) |  |  | Binary Tree(App: Pre-order) |
|  260| [Single Number III](https://leetcode.com/problems/single-number-iii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Single_260.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Single_260.java) |  |  | Bit Manipulation |
|  269| [Alien Dictionary](https://leetcode.com/problems/alien-dictionary/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Alien_269.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Alien_269.java) |  |  | Topological Sort |
|  280| [Wiggle Sort](https://leetcode.com/problems/wiggle-sort/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Wiggle_280.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Wiggle_280.java) |  |  | Greedy |
|  285| [Inorder Successor in BST](https://leetcode.com/problems/inorder-successor-in-bst/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Inorder_285.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Inorder_285.java) |  |  | Binary Search Tree |
|  305| [Number of Islands II](https://leetcode.com/problems/number-of-islands-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Number_305.md) | Hard | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Number_305.java) |  |  | Union Find |
|  310| [Minimum Height Trees](https://leetcode.com/problems/minimum-height-trees/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Minimum_310.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Minimum_310.java) |  |  | Topological Sort |
|  329| [Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Longest_329.md) | Hard | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Longest_329.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Longest_329.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Longest_329.go) | DFS(Memo), Topological Sort |
|  340| [Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Longest_340.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Longest_340.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Longest_340.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Longest_340.go) | Sliding Window(Max) |
|  347| [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Top_347.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Top_347.java) |  |  | Quick Select, Heap, TreeMap |
|  371| [Sum of Two Integers](https://leetcode.com/problems/sum-of-two-integers/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Sum_371.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Sum_371.java) |  |  | Bit Manipulation |
|  382| [Linked List Random Node](https://leetcode.com/problems/linked-list-random-node/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Linked_382.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Linked_382.java) |  |  | Reservoir Sampling |
|  398| [Random Pick Index](https://leetcode.com/problems/random-pick-index/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Random_398.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Random_398.java) |  |  | Reservoir Sampling |
|  404| [Sum of Left Leaves](https://leetcode.com/problems/sum-of-left-leaves/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Sum_404.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Sum_404.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Sum_404.py) |  | Binary Tree(App: Pre-order) |
|  415| [Add Strings](https://leetcode.com/problems/add-strings/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Add_415.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Add_415.java) |  |  | Add Two Numbers |
|  424| [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Longest_424.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Longest_424.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Longest_424.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Longest_424.go) | Sliding Window(Max) |
|  438| [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Find_438.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Find_438.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Find_438.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Find_438.go) | Sliding Window(Fixed) |
|  445| [Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Add_445.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Add_445.java) |  |  | Linked List |
|  450| [Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-bst/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Delete_450.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Delete_450.java) |  |  | Binary Search Tree |
|  470| [Implement Rand10() Using Rand7()](https://leetcode.com/problems/implement-rand10-using-rand7/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Implement_470.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Implement_470.java) |  |  | Rejection Sampling |
|  478| [Generate Random Point in a Circle](https://leetcode.com/problems/generate-random-point-in-a-circle/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Generate_478.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Generate_478.java) |  |  | Rejection Sampling |
|  491| [Increasing Subsequences](https://leetcode.com/problems/increasing-subsequences/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Increasing_491.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Increasing_491.java) |  |  | Backtrack |
|  510| [Inorder Successor in BST II](https://leetcode.com/problems/inorder-successor-in-bst-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Inorder_510.md) | Medium |  | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Inorder_510.py) |  | Binary Search Tree |
|  567| [Permutation in String](https://leetcode.com/problems/permutation-in-string/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Permutation_567.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Permutation_567.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Permutation_567.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Permutation_567.go) | Sliding Window(Fixed) |
|  572| [Subtree of Another Tree](https://leetcode.com/problems/subtree-of-another-tree/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Subtree_572.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Subtree_572.java) |  |  | Binary Tree (Serialize/Deserialize) |
|  606| [Construct String from Binary Tree](https://leetcode.com/problems/construct-string-from-binary-tree/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Construct_606.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Construct_606.java) |  |  | Binary Tree (Serialize/Deserialize) |
|  622| [Design Circular Queue](https://leetcode.com/problems/design-circular-queue/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Design_622.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Design_622.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Design_622.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Design_622.go) | Design(Deque) |
|  638| [Shopping Offers](https://leetcode.com/problems/shopping-offers/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Shopping_638.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Shopping_638.java) |  |  | Backtrack |
|  641| [Design Circular Deque](https://leetcode.com/problems/design-circular-deque/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Design_641.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Design_641.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Design_641.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Design_641.go) | Design(Deque) |
|  653| [Two Sum IV - Input is a BST](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Two_653.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Two_653.java) |  |  | Two Sum |
|  671| [Second Minimum Node In a Binary Tree](https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Second_671.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Second_671.java) |  |  | Binary Tree |
|  680| [Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Valid_680.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Valid_680.java) |  |  | Two Pointers |
|  684| [Redundant Connection](https://leetcode.com/problems/redundant-connection/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Redundant_684.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Redundant_684.java) |  |  | Union Find |
|  685| [Redundant Connection II](https://leetcode.com/problems/redundant-connection-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Redundant_685.md) | Hard | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Redundant_685.java) |  |  | Union Find |
|  692| [Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Top_692.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Top_692.java) |  |  | Priority Queue, Trie |
|  705| [Design HashSet](https://leetcode.com/problems/design-hashset/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Design_705.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Design_705.java) |  |  | Hash Table |
|  706| [Design HashMap](https://leetcode.com/problems/design-hashmap/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Design_706.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Design_706.java) |  |  | Hash Table |
|  775| [Global and Local Inversions](https://leetcode.com/problems/global-and-local-inversions/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Global_775.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Global_775.java) |  |  | Math |
|  802| [Find Eventual Safe States](https://leetcode.com/problems/find-eventual-safe-states/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Find_802.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Find_802.java) |  |  | Topological Sort |
|  865| [Smallest Subtree with all the Deepest Nodes](https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Smallest_865.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Lowest_1123.java) |  |  | Lowest Common Ancestor |
|  872| [Leaf-Similar Trees](https://leetcode.com/problems/leaf-similar-trees/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Leaf_872.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Leaf_872.java) |  |  | Binary Tree |
|  897| [Increasing Order Search Tree](https://leetcode.com/problems/increasing-order-search-tree/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Increasing_897.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Increasing_897.java) |  |  | Binary Tree |
|  973| [K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/K_973.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/K_973.java) |  |  | Quick Select, Heap |
|  989| [Add to Array-Form of Integer](https://leetcode.com/problems/add-to-array-form-of-integer/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Add_989.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Add_989.java) |  |  | Add Two Numbers |
| 1004| [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Max_1004.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Max_1004.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Max_1004.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Max_1004.go) | Sliding Window(Max) |
| 1022| [Sum of Root To Leaf Binary Numbers](https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Sum_1022.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Sum_1022.java) |  |  | Binary Tree |
| 1026| [Maximum Difference Between Node and Ancestor](https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Maximum_1026.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Maximum_1026.java) |  |  | Binary Tree |
| 1079| [Letter Tile Possibilities](https://leetcode.com/problems/letter-tile-possibilities/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Letter_1079.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Letter_1079.java) |  |  | Backtrack |
| 1099| [Two Sum Less Than K](https://leetcode.com/problems/two-sum-less-than-k/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Two_1099.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Two_1099.java) |  |  | Two Sum |
| 1100| [Find K-Length Substrings With No Repeated Characters](https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Find_1100.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Find_1100.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Find_1100.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Find_1100.go) | Sliding Window(Fixed) |
| 1123| [Lowest Common Ancestor of Deepest Leaves](https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Lowest_1123.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Lowest_1123.java) |  |  | Lowest Common Ancestor |
| 1136| [Parallel Courses](https://leetcode.com/problems/parallel-courses/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Parallel_1136.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Parallel_1136.java) |  |  | Topological Sort |
| 1146| [Snapshot Array](https://leetcode.com/problems/snapshot-array/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Snapshot_1146.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Snapshot_1146.java) |  |  | TreeMap |
| 1302| [Deepest Leaves Sum](https://leetcode.com/problems/deepest-leaves-sum/solution/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Deepest_1302.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Deepest_1302.java) |  |  | Binary Tree |
| 1472| [Design Browser History](https://leetcode.com/problems/design-browser-history/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Design_1172.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Design_1172.java) |  |  | Linked List, Stack |
| 1570| [Dot Product of Two Sparse Vectors](https://leetcode.com/problems/dot-product-of-two-sparse-vectors/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Dot_1570.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Dot_1570.java) |  |  | Two Pointers, Hash Table |
| 1644| [Lowest Common Ancestor of a Binary Tree II](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Lowest_1644.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Lowest_1644.java) |  |  | Lowest Common Ancestor |
| 1650| [Lowest Common Ancestor of a Binary Tree III](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Lowest_1650.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Lowest_1650.java) |  |  | Lowest Common Ancestor |
| 1676| [Lowest Common Ancestor of a Binary Tree IV](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iv/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Lowest_1676.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Lowest_1676.java) |  |  | Lowest Common Ancestor |
| 1738| [Find Kth Largest XOR Coordinate Value](https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Find_1738.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Find_1738.java) |  |  | Dynamic Programming |