// Heap
// Time: O(nlogn)
class Solution {
    public int[] sortArray(int[] nums) {
        buildMaxHeap(nums);
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            swap(nums, 0, i);
            maxheapify(nums, 0, i);
        }
    }

    private void buildMaxHeap(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            maxheapify(nums, i, n);
        }
    }
    
    private void maxheapify(int[] nums, int i, int size) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < size && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < size && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(nums, i, largest);
            maxheapify(nums, largest, size);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}




// Quick
// Time: O(nlogn)
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int p = quickSelect(nums, l, r);
            quickSort(nums, l, p - 1);
            quickSort(nums, p + 1, r);
        }
    }
    
    private int quickSelect(int[] nums, int l, int r) {
        swap(nums, r, l + new Random().nextInt(r - l + 1));
        int pivot = nums[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (nums[j] < pivot) {
                swap(nums, j, i++);
            }
        }
        swap(nums, i, r);
        return i;
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}




// Merge
// Time: O(nlogn)
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);
            merge(nums, l, m, r);
        }
    }
    
    private void merge(int[] nums, int l, int m, int r) {
        int[] tmp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) {
            tmp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= m) {
            tmp[k++] = nums[i++];
        }
        while (j <= r) {
            tmp[k++] = nums[j++];
        }
        for (int h = r; h >= l; h--, k--) {
            nums[h] = tmp[k - 1];
        }
    }
}




// Insertion
// Time: O(n^2)
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int key = nums[i];
            int j = i - 1;
            for (; j >= 0 && nums[j] > key; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = key;
        }
        return nums;
    }
}




// Selection
// Time: O(n^2)
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i; j < n; j++) {
                if (nums[j] < nums[min_idx]) min_idx = j;
            }
            swap(nums, i, min_idx);
        }
        return nums;
    }
}




// Bubble
// Time: O(n^2)
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for (int i = n; i > 1; i--) {
            for (int j = 1; j < i; j++) {
                if (nums[j - 1] > nums[j]) swap(nums, j - 1, j);
            }
        }
        return nums;
    }
}