class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        
        HashMap<Character, Integer> cMap = new HashMap<>();
        HashMap<String, Integer> wMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            cMap.putIfAbsent(c, i);
            wMap.putIfAbsent(w, i);
            // Do not diectly compare 2 Integer using "!=" or "=="
            // Alternative #1: a.compareTo(b) != 0
            // Alternative #2: (int)a != (int)b or a.intValue() != b.intValue()
            if (!cMap.get(c).equals(wMap.get(w))) {
                return false;
            }
        }
        
        return true;
    }
}