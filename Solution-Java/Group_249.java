class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> mapHashToList = new HashMap<>();
        
        for (String str : strings ) {
            mapHashToList.computeIfAbsent(getHash(str), k -> new LinkedList<>()).add(str);
        }
        
        return new ArrayList<>(mapHashToList.values());
    }

    char shiftLetter(char letter, int shift) {
        return (char) ((letter - shift + 26) % 26 + 'a');
    }
    
    // Create a hash value
    String getHash(String s) {
        char[] chars = s.toCharArray();
        
        // Calculate the number of shifts to make the first character to be 'a'
        int shift = chars[0];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = shiftLetter(chars[i], shift);
        }
        
        String hashKey = String.valueOf(chars);
        return hashKey;
    }
    

    // Alternative solution
    String getHash(String s) {
        char[] chars = s.toCharArray();
        StringBuilder hashKey = new StringBuilder();
        
        for (int i = 1; i < chars.length; i++) {
            hashKey.append((char) ((chars[i] - chars[i - 1] + 26) % 26 + 'a'));
        }
        
        return hashKey.toString();
    }
}