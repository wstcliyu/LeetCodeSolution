func lengthOfLongestSubstringTwoDistinct(s string) int {
    freq := make(map[rune]int)
    l, count := 0, 0
    for _, c := range s {
        if freq[c] += 1; freq[c] == 1 {
            count += 1
        }
        if count > 2 {
            if freq[rune(s[l])] -= 1; freq[rune(s[l])] == 0 {
                count -= 1
            }
            l += 1
        }
    }
    return len(s) - l
}