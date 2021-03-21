func combinationSum2(candidates []int, target int) [][]int {
    res := [][]int{}
    sort.Ints(candidates)
    helper(candidates, &res, []int{}, 0, target)
    return res
}

func helper(candidates []int, res *[][]int, tmp []int, start int, target int) {
    if target == 0 {
        b := make([]int, len(tmp))
        copy(b, tmp)
        *res = append(*res, b)
    } else {
        for i := start; i < len(candidates); i++ {
            if candidates[i] > target {
                break
            }
            if i > start && candidates[i] == candidates[i - 1] {
                continue
            }
            tmp = append(tmp, candidates[i])
            helper(candidates, res, tmp, i + 1, target - candidates[i])
            tmp = tmp[:len(tmp) - 1]
        }
    }
}