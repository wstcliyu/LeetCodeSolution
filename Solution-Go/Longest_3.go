func lengthOfLongestSubstring(s string) int {
    freq := make(map[rune]int)
    l, repeat := 0, 0
    for _, c := range s {
        if freq[c] += 1; freq[c] == 2 {
            repeat += 1
        }
        if repeat > 0 {
            if freq[rune(s[l])] -= 1; freq[rune(s[l])] == 1 {
                repeat -= 1
            }
            l += 1
        }
    }
    return len(s) - l
}