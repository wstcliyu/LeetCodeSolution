func findSubstring(s string, words []string) []int {
    wl := len(words[0])
    res := []int{}
    freq := make(map[string]int)
    for _, word := range words {
        freq[word] += 1
    }
    for i := 0; i < wl; i++ {
        start := i
        count := len(words)
        seen := make(map[string]int)
        for end := start + wl; end <= len(s); end += wl {
            tail := s[end - wl: end]
            if _, ok := freq[tail]; ok {
                if seen[tail]++; seen[tail] <= freq[tail] {
                    count--
                }
                if end - start == wl * len(words) {
                    if count == 0 {
                        res = append(res, start)
                    }
                    head := s[start: start + wl]
                    if seen[head]--; seen[head] < freq[head] {
                        count++
                    }
                    start += wl
                }
            } else {
                start = end
                count = len(words)
                seen = make(map[string]int)
            }
        }
    }
    return res
}