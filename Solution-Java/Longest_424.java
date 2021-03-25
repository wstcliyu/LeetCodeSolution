class Longest_424 {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int l = 0;
        int maxCount = 0;
        for (int r = 0; r < s.length(); r++) {
            maxCount = Math.max(maxCount, ++freq[s.charAt(r) - 'A']);
            if (r - l + 1 > maxCount + k) --freq[s.charAt(l++) - 'A'];
        }
        return s.length() - l;
    }
}