// https://leetcode.com/problems/string-transforms-into-another-string/discuss/399352/Complete-Logical-Thinking-(This-is-why-only-check-if-str2-has-unused-character)

// How to model this problem?
// 1. Model it as a graph would be the most intuitive way. The edges in the graph represent the mapping relationships.
// 2. Realize that the out degree of a node can only be smaller or equal to 1, otherwise we should just return false immediately! So the graph is just linked lists and using a hashmap will be sufficient to keep track of the edges.
// 3. Use a HashMap<Character, Character> to keep track of the edges.

// Why only check if str2 has unused character?
// See point 8 and 9 below

// Logical Thinking Step by Step:
// 1. Model it as a graph
// 2. Realize that the out degree of a node can only be smaller or equal to 1, so the graph is just a linked list and using a hashmap will be sufficient to keep track of the edges.
// 3. Note that size(key set) >= size(value set) because of point 2 above.
// 4. Realize that if there is no cycle in the graph, we can process the linked list from the end to the beginning, so just return true if no cycle exists.
// 5. It would be tempting for us to conclude that result=hasCycle(graph) but this is incorrect!
// 6. Realize that having cycle doesn't necessarily mean the result is false. This is because cycles can be break by using a temp node (temp node has zero out degree, in other words, temp node doesn't show up in the keyset of the hashmap or temp character doesn't show up in str1)
// 7. It would be tempting for us to conclude that ressult = size(key set)<26 but this is incorrect!
// 8. Realize that size(key set)=26 doesn't necessarily mean the result is false. we still need to pay attention to a spacial case when size(key set)=26 but size(value set)<26. In such case, multiple characters are mapped to the same character. Given this, we can create an unused character
// 9. How to create an unused characte in str1r: let's say c1, c2 are both mapped to c3. we transform c1 to c2 first. After this transformation, c1 disappears from the str1, so c1 is an unused character now!
// 10. We reach the conclusion that "if size(value set)<26, return true". As the final step, Let's prove that "if size(value set)=26, return false". When size(value set)=26, it implies that size(key set)=26 too, so we have 26 one-to-one mappings. If str1 is not the same as str2, cycle must exist, but there is no unused character to break the cycle. So return false.

// Actual Algorithm:
// 1. Loop through str1 and str2, update hashmap with the mapping str1[i] -> str2[i]
// 2. If one-to-more mapping are found, return flase immediately
// 3. return size(value set) < 26 at the end

class Solution {
	public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
           if (map.containsKey(c1) && map.get(c1) != c2) {
                return false;
            }
            map.put(c1, c2);
        }
        return new HashSet<Character>(map.values()).size() < 26;
    }
}