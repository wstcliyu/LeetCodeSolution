func numKLenSubstrNoRepeats(S string, K int) int {
    if len(S) < K {
        return 0
    }
    freq := make(map[rune]int)
    l, r, repeat, res := 0, 0, 0, 0
    for r < len(S) {
        if freq[rune(S[r])] += 1; freq[rune(S[r])] == 2 {
            repeat += 1
        }
        r += 1
        if r - l == K {
            if repeat == 0 {
                res += 1
            }
            if freq[rune(S[l])] -= 1; freq[rune(S[l])] == 1 {
                repeat -= 1
            }
            l += 1
        }
    }
    return res
}