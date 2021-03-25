func lengthOfLongestSubstringKDistinct(s string, k int) int {
    freq := make(map[rune]int)
    l := 0
    for _, c := range s {
        if freq[c] += 1; freq[c] == 1 {
            k -= 1
        }
        if k < 0 {
            if freq[rune(s[l])] -= 1; freq[rune(s[l])] == 0 {
                k += 1
            }
            l += 1
        }
    }
    return len(s) - l
}