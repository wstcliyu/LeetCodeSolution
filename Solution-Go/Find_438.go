func findAnagrams(s string, p string) []int {
    res := []int{}
    if len(s) < len(p) {
        return res
    }
    freq := make(map[rune]int)
    for _, c := range p {
        freq[c] += 1
    }
    l, count := 0, len(p)
    for r, c := range s {
        if freq[c] -= 1; freq[c] >= 0 {
            count -= 1
        }
        if count == 0 {
            res = append(res, l)
        }
        if r - l + 1 == len(p) {
            if freq[rune(s[l])] += 1; freq[rune(s[l])] > 0 {
                count += 1
            }
            l += 1
        }
    }
    return res
}