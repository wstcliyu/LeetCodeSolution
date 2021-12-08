class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && vowels.indexOf(chars[l]) == -1) {
                l++;
            }
            while (l < r && vowels.indexOf(chars[r]) == -1) {
                r--;
            }
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l++;
            r--;
        }
        return new String(chars);
    }
}