// My solution (like rolling hash)
// Time: O(n m^2)
class Solution {
	public boolean differByOne(String[] dict) {
		int n = dict.length;
		int m = dict[0].length();
		for (int j = 0; j < m; j++) {
			HashSet<String> seen = new HashSet<>();
			for (int i = 0; i < n; i++) {
				String s = dict[i].substring(0, j) + dict[i].substring(j + 1);
				if (!seen.add(s)) {
					return true;
				}
			}
			// HashMap<String, HashSet<Integer>> map = new HashMap<>();
			// for (int i = 0; i < n; i++) {
			// 	String s = dict[i].substring(0, j) + dict[i].substring(j + 1);
			// 	if (map.containsKey(s)) {
			// 		for (int idx : map.get(s)) {
			// 			if (dict[i].charAt(j) != dict[idx].charAt(j)) {
			// 				return true;
			// 			}
			// 		}
			// 	}
			// 	map.computeIfAbsent(s, k -> new HashSet<>()).add(i);
			// }
		}
		return false;
	}
}




// Rolling Hash
// https://leetcode.com/problems/strings-differ-by-one-character/discuss/802871/Rabin-Karp-O(nm)
// I found a good Java implementation
// Time: O(mn)
class Solution {
    public boolean differByOne(String[] dict) {
        if (dict == null || dict.length == 0) {
            return false;
        }
        
        int n = dict.length;
        int m = dict[0].length();
        long[] hash = new long[n];
        // abcd -> 0123
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                hash[i] = (hash[i] * 26 + dict[i].charAt(j) - 'a');
            }
        }
        
        long base = 1;
        // 因為最右邊的才是第一位(26^0)，所以從最右邊開始看
        for (int index = m - 1; index >= 0; index--) {
            Set<Long> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                long newHash = (hash[i] - base * (dict[i].charAt(index) - 'a'));
                if (set.contains(newHash)) {  //如果拿掉某一位，set裡面有重複元素就是有找到
                    return true;
                }
                
                set.add(newHash);
            }
            base = 26 * base;
        }
        return false;
    }
}




// Trie
// https://leetcode.com/problems/strings-differ-by-one-character/discuss/843911/Java-Trie-Solution
class Solution {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean end;
        public TrieNode() {
            children = new HashMap<>();
        }
    }
    
    public boolean differByOne(String[] dict) {
        TrieNode root = buildTrie(dict);
        for (String w : dict) {
            if (search(root, w, 0, 0)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean search (TrieNode root, String w, int diff, int index) {
        if (diff > 1) {
            return false;
        }
        
        if (index >= w.length()) {
            return root.end && diff == 1;
        }
        
        char c = w.charAt(index);
        for (char key: root.children.keySet()) {
            if (key == c ) {
                if (search(root.children.get(key), w, diff, index+1)) {
                    return true;
                } 
            } else {
                if (search(root.children.get(key), w, diff+1, index+1)) {
                    return true;
                }
            }
        }
        return false;
        
    }
    
    public TrieNode buildTrie(String[] dict) {
        TrieNode root = new TrieNode();
        for (String word : dict) {
            TrieNode node = root;
            for (Character c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                } 
                node = node.children.get(c);
            }
            node.end = true;
        }
        return root;
    }
}