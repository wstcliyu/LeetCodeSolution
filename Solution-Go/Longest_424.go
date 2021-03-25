func characterReplacement(s string, k int) int {
    l, maxCount := 0, 0
    freq := make(map[rune]int)
    for r, c := range s {
        freq[c] += 1
        maxCount = max(maxCount, freq[c])
        if r - l + 1 > maxCount + k {
            freq[rune(s[l])] -= 1
            l += 1
        }
    }
    return len(s) - l
}

func max(x int, y int) int {
    if x > y {
        return x
    }
    return y
}