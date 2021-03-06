func numKLenSubstrNoRepeats(S string, K int) int {
    if len(S) < K {
        return 0
    }
    freq := make(map[rune]int)
    l, repeat, res := 0, 0, 0
    for r, c := range S {
        if freq[c] += 1; freq[c] == 2 {
            repeat += 1
        }
        if r - l + 1 == K {
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