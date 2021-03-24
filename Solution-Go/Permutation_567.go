func checkInclusion(s1 string, s2 string) bool {
    if len(s1) > len(s2) {
        return false
    }
    freq := make(map[rune]int)
    for _, c := range s1 {
        freq[c] += 1
    }
    l, count := 0, len(s1)
    for r, c := range s2 {
        if freq[c] -= 1; freq[c] >= 0 {
            count -= 1
        }
        if r - l + 1 == len(s1) {
            if count == 0 {
                return true
            }
            if freq[rune(s2[l])] += 1; freq[rune(s2[l])] > 0 {
                count += 1
            }
            l += 1
        }
        
    }
    return false
}