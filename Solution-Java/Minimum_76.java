class Minimum_76 {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        String res = "";
        int[] freq = new int[128];
        for (char c : t.toCharArray())
            freq[c]++;
        int count = t.length();
        int left = 0, right = 0;
        while (right < s.length()) {
            if (freq[s.charAt(right++)]-- > 0)
                count--;
            while (count == 0) {
                if (res.isEmpty() || right - left < res.length())
                    res = s.substring(left, right);
                if (++freq[s.charAt(left++)] > 0)
                    count++;
            }
        }
        return res;
    }
}