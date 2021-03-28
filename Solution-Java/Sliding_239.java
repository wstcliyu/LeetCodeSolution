class Sliding_239 {
    // Mono queue
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && q.getFirst() <= i - k) {
                q.removeFirst();
            }
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.add(i);
            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[q.getFirst()];
            }
        }
        return res;
    }



    // Two pass
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            left[i] = i % k == 0 ? nums[i] : Math.max(nums[i], left[i - 1]);
            right[j] = (j % k == 0 || j == n - 1) ? nums[j] : Math.max(nums[j], right[j + 1]);
        }
        for (int i = 0; i < n - k + 1; i++) {
            res[i] = Math.max(left[i + k - 1], right[i]);
        }
        return res;
    }
}