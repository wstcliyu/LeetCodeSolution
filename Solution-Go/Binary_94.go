// Using Stack
func inorderTraversal(root *TreeNode) []int {
    res, stack, node := []int{}, []*TreeNode{}, root
    for len(stack) > 0 || node != nil {
        if node != nil {
            stack = append(stack, node)
            node = node.Left
        } else {
            node = stack[len(stack) - 1]
            stack = stack[:len(stack) - 1]
            res = append(res, node.Val)
            node = node.Right
        }
    }
    return res
}



// Morris Traversal
func inorderTraversal(root *TreeNode) []int {
    res, node := []int{}, root
    for node != nil {
        if node.Left == nil {
            res = append(res, node.Val)
            node = node.Right
        } else {
            pred := node.Left
            for pred.Right != nil && pred.Right != node {
                pred = pred.Right
            }
            if pred.Right == nil {
                pred.Right = node
                node = node.Left
            } else {
                pred.Right = nil
                res = append(res, node.Val)
                node = node.Right
            }
        }
    }
    return res
}