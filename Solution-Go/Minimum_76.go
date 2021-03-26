func minWindow(s string, t string) string {
    if len(s) < len(t) {
        return ""
    }
    res := ""
    freq := make(map[rune]int)
    for _, c := range t {
        freq[c] += 1
    }
    l, count := 0, len(t)
    for r, c := range s {
        if freq[c] -= 1; freq[c] >= 0 {
            count -= 1
        }
        for count == 0 {
            if res == "" || r - l + 1 < len(res) {
                res = s[l : r + 1]
            }
            if freq[rune(s[l])] += 1; freq[rune(s[l])] > 0 {
                count += 1
            }
            l += 1
        }
    }
    return res
}