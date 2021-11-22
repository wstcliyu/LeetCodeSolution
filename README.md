# LeetCodeSolution

1. [Topics](#topics)
2. [Solutions](#solutions)

## Topics
- Add Two Numbers (Textbook/School Addition)
	- Linked List: 2, 445(reverse twice)
	- String: 415
- Backtrack
	- Regular: 17, 39, 40, 46, 47, 78, 90, 216, 254
	- HashSet: 491
	- Memoization: 638
	- Count: 1079
- BFS
	- Topological Sort: 310
- Binary Search Tree (BST)
	- In-order successor (pred): 285, 510
- Binary Tree
	- Traversal
		- Level-order: 102(103, 107)
		- Pre-order: 144
		- Post-order: 145
		- In-order: 94
	- App
		- Pre-order: 404
- Design
	- (De)Queue: 622, 641
- DFS
	- Regular: 79
	- Memoization: 329
- Linked List
	- Cycle: 142(141)
	- Reverse: 234(206), 92, 143
	- Merge: 21(23), 148
	- Trick: 237
	- Doubly Linked List (DDL): 1472
- Math
	- Regular: 775
- Mono Queue/Stack
	- Mono Queue: 239
- Priority Queue
	- Regular: 692
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
	- Two Sum: 1099


## Solutions
|  #  | Title | Problem | Difficulty | Java | Python | Go | Topic |
|:---:|:------|:-------:|:----------:|:----:|:------:|:--:|:------|
|    2| [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Add_2.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Add_2.java) |  |  | Linked List |
|    3| [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Longest_3.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Longest_3.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Longest_3.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Longest_3.go) | Sliding Window(Max) |
|   17| [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Letter_17.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Letter_17.java) |  |  | Backtrack |
|   21| [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Merge_21.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Merge_21.java) |  |  | Linked List |
|   23| [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Merge_23.md) | Hard | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Merge_23.java) |  |  | Linked List |
|   30| [Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Substring_30.md) | Hard | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Substring_30.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Substring_30.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Substring_30.go) | Sliding Window(Fixed) |
|   39| [Combination Sum](https://leetcode.com/problems/combination-sum/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Combination_39.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Combination_39.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Combination_39.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Combination_39.go) | Backtrack |
|   40| [Combination Sum II](https://leetcode.com/problems/combination-sum-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Combination_40.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Combination_40.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Combination_40.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Combination_40.go) | Backtrack |
|   46| [Permutations](https://leetcode.com/problems/permutations/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Permutations_46.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Permutations_46.java) |  |  | Backtrack |
|   47| [Permutations II](https://leetcode.com/problems/permutations-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Permutations_47.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Permutations_47.java) |  |  | Backtrack |
|   76| [Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Minimum_76.md) | Hard | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Minimum_76.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Minimum_76.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Minimum_76.go) | Sliding Window(Min) |
|   78| [Subsets](https://leetcode.com/problems/subsets/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Subsets_78.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Subsets_78.java) |  |  | Backtrack |
|   79| [Word Search](https://leetcode.com/problems/word-search/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Word_79.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Word_79.java) |  |  | DFS |
|   90| [Subsets II](https://leetcode.com/problems/subsets-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Subsets_90.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Subsets_90.java) |  |  | Backtrack |
|   94| [Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Binary_94.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Binary_94.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Binary_94.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Binary_94.go) | Binary Tree(In-order traversal) |
|  102| [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Binary_102.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Binary_102.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Binary_102.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Binary_102.go) | Binary Tree(Level-order traversal) |
|  103| [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Binary_103.md) | Medium |  |  |  | Binary Tree(Level-order traversal) |
|  107| [Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Binary_107.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Binary_107.java) |  |  | Binary Tree(Level-order traversal) |
|  141| [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Linked_141.md) | Easy |  |  | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Linked_141.go) | Linked List |
|  142| [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Linked_142.md) | Medium |  |  | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Linked_142.go) | Linked List |
|  144| [Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Binary_144.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Binary_144.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Binary_144.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Binary_144.go) | Binary Tree(Pre-order traversal) |
|  145| [Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Binary_145.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Binary_145.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Binary_145.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Binary_145.go) | Binary Tree(Post-order traversal) |
|  148| [Sort List](https://leetcode.com/problems/sort-list/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Sort_148.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Sort_148.java) |  |  | Linked List |
|  159| [Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Longest_159.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Longest_159.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Longest_159.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Longest_159.go) | Sliding Window(Max) |
|  207| [Course Schedule](https://leetcode.com/problems/course-schedule/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Course_207.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Course_207.java) |  |  | Topological Sort |
|  208| [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Implement_208.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Implement_208.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Implement_208.py) |  | Trie |
|  209| [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Minimum_209.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Minimum_209.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Minimum_209.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Minimum_209.go) | Sliding Window(Min) |
|  210| [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Course_210.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Course_210.java) |  |  | Topological Sort |
|  211| [Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Design_211.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Design_211.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Design_211.py) |  | Trie |
|  212| [Word Search II](https://leetcode.com/problems/word-search-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Word_212.md) | Hard | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Word_212.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Word_212.py) |  | Trie, DFS |
|  216| [Combination Sum III](https://leetcode.com/problems/combination-sum-iii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Combination_216.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Combination_216.java) |  |  | Backtrack |
|  234| [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Palindrome_234.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Palindrome_234.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Palindrome_234.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Palindrome_234.go) | Linked List |
|  239| [Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Sliding_239.md) | Hard | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Sliding_239.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Sliding_239.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Sliding_239.go) | Mono queue |
|  254| [Factor Combinations](https://leetcode.com/problems/factor-combinations/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Factor_254.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Factor_254.java) |  |  | Backtrack |
|  269| [Alien Dictionary](https://leetcode.com/problems/alien-dictionary/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Alien_269.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Alien_269.java) |  |  | Topological Sort |
|  285| [Inorder Successor in BST](https://leetcode.com/problems/inorder-successor-in-bst/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Inorder_285.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Inorder_285.java) |  |  | Binary Search Tree |
|  310| [Minimum Height Trees](https://leetcode.com/problems/minimum-height-trees/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Minimum_310.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Minimum_310.java) |  |  | Topological Sort |
|  329| [Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Longest_329.md) | Hard | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Longest_329.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Longest_329.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Longest_329.go) | DFS(Memo), Topological Sort |
|  340| [Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Longest_340.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Longest_340.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Longest_340.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Longest_340.go) | Sliding Window(Max) |
|  404| [Sum of Left Leaves](https://leetcode.com/problems/sum-of-left-leaves/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Sum_404.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Sum_404.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Sum_404.py) |  | Binary Tree(App: Pre-order) |
|  415| [Add Strings](https://leetcode.com/problems/add-strings/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Add_415.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Add_415.java) |  |  | Add Two Numbers |
|  424| [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Longest_424.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Longest_424.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Longest_424.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Longest_424.go) | Sliding Window(Max) |
|  438| [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Find_438.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Find_438.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Find_438.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Find_438.go) | Sliding Window(Fixed) |
|  445| [Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Add_445.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Add_445.java) |  |  | Linked List |
|  491| [Increasing Subsequences](https://leetcode.com/problems/increasing-subsequences/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Increasing_491.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Increasing_491.java) |  |  | Backtrack |
|  510| [Inorder Successor in BST II](https://leetcode.com/problems/inorder-successor-in-bst-ii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Inorder_510.md) | Medium |  | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Inorder_510.py) |  | Binary Search Tree |
|  567| [Permutation in String](https://leetcode.com/problems/permutation-in-string/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Permutation_567.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Permutation_567.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Permutation_567.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Permutation_567.go) | Sliding Window(Fixed) |
|  622| [Design Circular Queue](https://leetcode.com/problems/design-circular-queue/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Design_622.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Design_622.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Design_622.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Design_622.go) | Design(Deque) |
|  638| [Shopping Offers](https://leetcode.com/problems/shopping-offers/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Shopping_638.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Shopping_638.java) |  |  | Backtrack |
|  641| [Design Circular Deque](https://leetcode.com/problems/design-circular-deque/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Design_641.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Design_641.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Design_641.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Design_641.go) | Design(Deque) |
|  692| [Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Top_692.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Top_692.java) |  |  | Priority Queue, Trie |
|  775| [Global and Local Inversions](https://leetcode.com/problems/global-and-local-inversions/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Global_775.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Global_775.java) |  |  | Math |
|  802| [Find Eventual Safe States](https://leetcode.com/problems/find-eventual-safe-states/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Find_802.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Find_802.java) |  |  | Topological Sort |
| 1004| [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Max_1004.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Max_1004.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Max_1004.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Max_1004.go) | Sliding Window(Max) |
| 1079| [Letter Tile Possibilities](https://leetcode.com/problems/letter-tile-possibilities/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Letter_1079.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Letter_1079.java) |  |  | Backtrack |
| 1099| [Two Sum Less Than K](https://leetcode.com/problems/two-sum-less-than-k/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Two_1099.md) | Easy | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Two_1099.java) |  |  | Two Pointers |
| 1100| [Find K-Length Substrings With No Repeated Characters](https://leetcode.com/problems/find-k-length-substrings-with-no-repeated-characters/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Find_1100.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Find_1100.java) | [Python](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Python/Find_1100.py) | [Go](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Go/Find_1100.go) | Sliding Window(Fixed) |
| 1136| [Parallel Courses](https://leetcode.com/problems/parallel-courses/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Parallel_1136.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Parallel_1136.java) |  |  | Topological Sort |
| 1146| [Snapshot Array](https://leetcode.com/problems/snapshot-array/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Snapshot_1146.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Snapshot_1146.java) |  |  | TreeMap |
| 1172| [Design Browser History](https://leetcode.com/problems/design-browser-history/) | [Problem](https://github.com/wstcliyu/LeetCodeSolution/blob/main/ProblemSet/Design_1172.md) | Medium | [Java](https://github.com/wstcliyu/LeetCodeSolution/blob/main/Solution-Java/Design_1172.java) |  |  | Linked List, Stack |