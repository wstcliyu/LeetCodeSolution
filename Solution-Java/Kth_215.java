// Min Heap
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }
        return heap.peek();
    }
}




// Quick Select
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }
    
    private int findKthLargest(int[] nums, int l, int r, int k) {
        int i = quickSelect(nums, l, r, k);
        if (r - i > k - 1) {
            return findKthLargest(nums, i + 1, r, k);
        } else if (r - i < k - 1) {
            return findKthLargest(nums, l, i - 1, k - r + i - 1);
        } else {
            return nums[i];
        }
    }
    
    private int quickSelect(int[] nums, int l, int r, int k) {
        swap(nums, r, l + new Random().nextInt(r - l + 1));
        int pivot = nums[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (nums[j] < pivot) {
                swap(nums, i++, j);
            }
        }
        swap(nums, i, r);
        return i;
    }
    
    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}




// Template for quickSort and quickSelect

// Quick Sort Time Complexity: Average O(NlogN), Worst O(N^2)
// T(N) = 2 * T(N/2) + O(N)
// Quick Select Time Complexity: Average O(N), Worst O(N^2)
// T(N) = T(N/2) + O(N)

// Master Theorem
// https://leetcode.com/explore/learn/card/recursion-ii/470/divide-and-conquer/2871/
private void quickSort(int[] A, int left, int right) {
    if (left >= right) return;
    int i = quickSelect(A, left, right);
    quickSort(A, left, i - 1);
    quickSort(A, i + 1, right);
}

private int quickSelect(int[] A, int left, int right) {
    swap(A, right, left + new Random().nextInt(right - left + 1));
    int pivot = A[right];
    int i = left;
    for (int j = left; j < right; j++) {
        if (A[j] < pivot) swap(A, i++, j);
    }
    swap(A, i, right);
    return i;
}