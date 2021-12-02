// Quick Select
// Time: O(N) average case, O(N^2) worst case
class Solution {
    private Map<Integer, Integer> count;
    private int[] unique;
    
    public int[] topKFrequent(int[] nums, int k) {
        count = new HashMap<>();
        for (int num : nums) {
            count.put(num, 1 + count.getOrDefault(num, 0));
        }
        int n = count.size();
        unique = new int[n];
        int i = 0;
        for (int num : count.keySet()) {
            unique[i++] = num;
        }
        helper(0, n - 1, k);
        return Arrays.copyOfRange(unique, n - k, n);
    }
    
    private void helper(int l, int r, int k) {
        int i = quickSelect(l, r);
        if (r - i > k - 1) {
            helper(i + 1, r, k);
        } else if (r - i < k - 1) {
            helper(l, i - 1, k + i - r - 1);
        }
    }
    
    private int quickSelect(int l, int r) {
        swap(unique, r, l + new Random().nextInt(r - l + 1));
        int pivot = unique[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (count.get(unique[j]) < count.get(pivot)) {
                swap(unique, i++, j);
            }
        }
        swap(unique, i, r);
        return i;
    }
    
    private void swap(int[] unique, int i, int j) {
        int tmp = unique[i];
        unique[i] = unique[j];
        unique[j] = tmp;
    }
}




// Standard solution using min heap
// Time: O(Nlog(k)). The complexity of Counter method is O(N). To build a heap and output list takes O(Nlog(k)). 
// Hence the overall complexity of the algorithm is O(N+Nlog(k))=O(Nlog(k))
// Space : O(N) to store the hash map
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) count.put(n, count.getOrDefault(n, 0) + 1);

        // init heap 'the less frequent element first'
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> count.get(n1) - count.get(n2));
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparing(i -> count.get(i)));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b) {
                return count.get(a) - count.get(b);
            }
        });


        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
            minHeap.add(n);
            if (minHeap.size() > k) minHeap.poll();
        }

        // build output list
        // My version: return new ArrayList<>(minHeap);
        List<Integer> top_k = new LinkedList();
        while (!minHeap.isEmpty()) top_k.add(minHeap.poll());
        Collections.reverse(top_k);
        return top_k;
    }
}




// My first solution using max heap
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) count.put(n, count.getOrDefault(n, 0) + 1);
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<Integer>((n1, n2) -> count.get(n2) - count.get(n1));
        maxHeap.addAll(count.keySet());
        List<Integer> top_k = new LinkedList();
        for (int i = 0; i < k; i++) top_k.add(maxHeap.poll());
        return top_k;
    }
}




// Most voted solution using bucket sort
// Time: O(N)
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashSet<Integer>[] bucket = new HashSet[nums.length + 1];
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums)
            freq.put(num, 1 + freq.getOrDefault(num, 0));
        for (int key : freq.keySet()) {
            int frequency = freq.get(key);
            if (bucket[frequency] == null)
                bucket[frequency] = new HashSet<>();
            bucket[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int pos = bucket.length-1; pos>=0 && res.size()<k; pos--) {
            if (bucket[pos] != null)
                res.addAll(bucket[pos]);
        }
        return res;
    }
}




// Using TreeMap whose <key, value> = <frequency, num>
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) count.put(num, 1 + count.getOrDefault(num, 0));
        TreeMap<Integer, List<Integer>> freqMap = new TreeMap<>();
        for (int num : count.keySet()) {
            int freq = count.get(num);
            freqMap.putIfAbsent(freq, new ArrayList<>());
            freqMap.get(freq).add(num);
        }
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) res.addAll(freqMap.pollLastEntry().getValue());
        return res;
    }
}