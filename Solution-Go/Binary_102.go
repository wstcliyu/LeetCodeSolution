// Iteration
func levelOrder(root *TreeNode) [][]int {
    if root == nil {
        return [][]int{}
    }
    res, q := [][]int{}, []*TreeNode{}
    q = append(q, root)
    for len(q) > 0 {
        layer := []int{}
        for i := len(q); i > 0; i-- {
            node := q[0]
            layer = append(layer, node.Val)
            q = q[1:]
            if node.Left != nil {
                q = append(q, node.Left)
            }
            if node.Right != nil {
                q = append(q, node.Right)
            }
        }
        res = append(res, layer)
    }
    return res
}



// Recursion. Similar with 107.
func levelOrder(root *TreeNode) [][]int {
    if root == nil {
        return [][]int{}
    }
    res := [][]int{}
    levelMaker(&res, root, 0)
    return res
}

func levelMaker(res *[][]int, root *TreeNode, depth int) {
    if depth >= len(*res) {
        *res = append(*res, []int{})
    }
    (*res)[depth] = append((*res)[depth], root.Val)
    if root.Left != nil {
        levelMaker(res, root.Left, depth + 1)
    }
    if root.Right != nil {
        levelMaker(res, root.Right, depth + 1)
    }
}