// My solution
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int num : asteroids) {
            while (!stack.isEmpty() && num < 0 && stack.getLast() > 0 && Math.abs(stack.getLast()) < Math.abs(num)) {
                stack.removeLast();
            }
            if (stack.isEmpty() || num > 0 || stack.getLast() < 0) {
                stack.addLast(num);
            } else if (Math.abs(stack.getLast()) == Math.abs(num)) {
                stack.removeLast();
            }
        }
        
        // int[] res = new int[stack.size()];
        // for (int i = 0; i < res.length; i++) {
        //     res[i] = stack.removeFirst();
        // }
        // return res;
        return stack.stream().mapToInt(i -> i).toArray();
    }
}