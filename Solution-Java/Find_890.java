class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        HashMap<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            pMap.putIfAbsent(pattern.charAt(i), i);
        }
        
        List<String> res = new ArrayList<>();
        for (String word : words) {
            HashMap<Character, Integer> cMap = new HashMap<>();
            int i = 0;
            for (; i < word.length(); i++) {
                char c = word.charAt(i);
                cMap.putIfAbsent(c, i);
                if (!cMap.get(c).equals(pMap.get(pattern.charAt(i)))) {
                    break;
                }
            }
            if (i == word.length()) {
                res.add(word);
            }
        }
        
        return res;
    }
}