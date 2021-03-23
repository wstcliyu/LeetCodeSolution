func checkInclusion(s1 string, s2 string) bool {
    if len(s1) > len(s2) {
        return false
    }
    freq := make(map[rune]int)
    for _, c := range s1 {
        freq[c] += 1
    }
    l, r, count := 0, 0, len(s1)
    for r < len(s2) {
        if freq[rune(s2[r])] -= 1; freq[rune(s2[r])] >= 0 {
            count -= 1
        }
        r += 1
        if count == 0 {
            return true
        }
        if r - l == len(s1) {
            if freq[rune(s2[l])] += 1; freq[rune(s2[l])] > 0 {
                count += 1
            }
            l += 1
        }
        
    }
    return false
}