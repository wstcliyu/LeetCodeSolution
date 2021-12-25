class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>(), tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i), tc = t.charAt(i);
            sMap.putIfAbsent(sc, i);
            tMap.putIfAbsent(tc, i);
            if (sMap.get(sc) != tMap.get(tc)) {
                return false;
            }
        }
        return true;
    }
}