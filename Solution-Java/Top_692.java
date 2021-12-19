// Min Heap
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, 1 + freq.getOrDefault(word, 0));
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> e1.getValue() == e2.getValue() ? e2.getKey().compareTo(e1.getKey()) : e1.getValue() - e2.getValue());
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        LinkedList<String> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.addFirst(pq.poll().getKey());
        }
        return res;
    }
}




// Bucket sort + Trie
// This method is derived from 347. Top K Frequent Elements. At 347, we use bucket sort(LinkedList in each bucket) to find top K frequency integers and we can choose any integer if there is a tie of frequency . But in this question, the problem is that when there is a tie of frequency, we need to compare the lexicographic order. Thus using bucket sort(LinkedList in each bucket) is not good.
// The way to solve the tie problem is to use either trie or BST.
// Time Complexity: O(nm) = O(n), m time to construct trie for each word and m is a constant
// Space Complexity: O(nm) = O(n), m space for each bucket and m is a constant
class Solution {
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isEnd = false;
    }
    
    private void addWord(TrieNode root, String word) {
        for (char c : word.toCharArray()) {
            if (root.next[c - 'a'] == null) {
                root.next[c - 'a'] = new TrieNode();
            }
            root = root.next[c - 'a'];
        }
        root.isEnd = true;
    }
    
    private void getWord(TrieNode root, List<String> res, int k, StringBuilder sb) {
        if (res.size() == k) {
            return;
        }
        if (root.isEnd) {
            res.add(sb.toString());
        }
        for (int i = 0; i < 26; i++) {
            TrieNode node = root.next[i];
            if (node != null) {
                sb.append((char)('a' + i));
                getWord(node, res, k, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, 1 + freq.getOrDefault(word, 0));
        }
        TrieNode[] buckets = new TrieNode[words.length + 1];
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            int f = entry.getValue();
            if (buckets[f] == null) {
                buckets[f] = new TrieNode();
            }
            addWord(buckets[f], entry.getKey());
        }
        List<String> res = new ArrayList<>();
        for (int f = words.length; f >= 0 && res.size() < k; f--) {
            if (buckets[f] != null) {
                getWord(buckets[f], res, k, new StringBuilder());
            }
        }
        return res;
    }
}




// https://leetcode.com/problems/top-k-frequent-words/discuss/431008/Summary-of-all-the-methods-you-can-imagine-of-this-problem

// To help you guys have a better understanding of this problem, I tried to summary the methods I saw from others in this post. This is my first time to write a summary post, so correct me if there is any problem. Thanks!

// To analyze Time Complexity and Space Complexity: n is the total number of words, m is the average length of each word

// Just Sorting
// The easiest way to think of this problem and easy to implement.
// Time complexity: O(nlogn), naive sort is o(nlogn)
// Space complexity: O(n), for map and list

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        List<Map.Entry<String, Integer>> l = new LinkedList<>();
        for(Map.Entry<String, Integer> e:map.entrySet()){
            l.add(e);
        }
        Collections.sort(l, new MyComparator());//just use our Comparator to sort
        List<String> ans = new LinkedList<>();
        for(int i = 0;i<=k-1;i++){
            ans.add(l.get(i).getKey());
        }
        return ans;
    }
}
/*
Implement our own comparator for this problem, I will also use this Comparator in other methods(A little different in minHeap method).
We can also use anonymous Comparaotr or Lambda function.
*/
class MyComparator implements Comparator<Map.Entry<String, Integer>> {

    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
        String word1 = e1.getKey();
        int freq1 = e1.getValue();
        String word2 = e2.getKey();
        int freq2 = e2.getValue();
        if(freq1!=freq2){
            return freq2-freq1;
        }
        else {
            return word1.compareTo(word2);
        }
    }
}




// Bucket sort + BST
// The reason we use Trie is to break the tie of same word frequency. Thus we can easily use BST to replace Trie(In Java, we can use TreeMap or TreeSet)
// Time Complexity: O(n), not sure
// Space Complexity: O(n), not sure

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        TreeMap<String, Integer>[] buckets = new TreeMap[words.length];
        for(Map.Entry<String, Integer> e:map.entrySet()){
            String word = e.getKey();
            int freq = e.getValue();
            if(buckets[freq]==null){
                buckets[freq] = new TreeMap<>((a, b)->{
                    return a.compareTo(b);
                });
            }
            buckets[freq].put(word, freq);
        }
        
        List<String> ans = new LinkedList<>();
        for(int i = buckets.length-1;i>=0;i--){
            if(buckets[i]!=null){
                TreeMap<String, Integer> temp = buckets[i];
                if(temp.size()<k){
                    k = k - temp.size();
                    while(temp.size()>0){
                        ans.add(temp.pollFirstEntry().getKey());
                    }  
                }
                else {
                    while(k>0){
                        ans.add(temp.pollFirstEntry().getKey());
                        k--;
                    }
                    break;
                }
            }
        }     
        return ans;
    }
}




// Quick select
// If the question is to find Kth frequency word, quick select is a good solution and only cost O(n), for this question, after getting Top K frequency words by using quick select, we also need to do a sort to make sure they are in the right order.
// Time Complexity: O(n+KlogK), n time for quick select and KlogK time for sort
// Space Complexity: O(n)

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word:words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        
        Map.Entry<String, Integer>[] entrys = new Map.Entry[map.size()];
        int index = 0;
        for(Map.Entry<String, Integer> e:map.entrySet()){
            entrys[index] = e;
            index++;
        }
        //do quick select
        int start = 0;
        int end = entrys.length-1;
        int mid = 0;
        while(start<=end){
            mid = partition(entrys, start, end);
            if(mid == k-1){
                break;
            }
            else if(mid<k-1){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        List<String> ans = new LinkedList<>();
        List<Map.Entry<String, Integer>> l = new LinkedList<>();
        for(int i = 0;i<=mid;i++){
            l.add(entrys[i]);
        }
        //still need to sort these K words, because we only know they are in result, but not in right order
        Collections.sort(l, new MyComparator());
        for(Map.Entry<String, Integer> e:l){
            ans.add(e.getKey());
        }
        return ans;
    }
    
    private int partition(Map.Entry<String, Integer>[] entrys, int start, int end){
        int pivot = start;
        int left = start + 1;
        int right = end;
        MyComparator myComparator = new MyComparator();
        while(true){
            while(left<=end){
                if(myComparator.compare(entrys[left], entrys[pivot])<=0){
                    left++;
                }
                else {
                    break;
                }
            }
            
            while(right>=start+1){
                if(myComparator.compare(entrys[right], entrys[pivot])>0){
                    right--;
                }
                else {
                    break;
                }
            }
            if(left>right){
                break;
            }
            swap(entrys, left, right);
        }
        swap(entrys, pivot, right);
        return right;
    }

    private void swap(Map.Entry<String, Integer>[] entrys, int i, int j){
        Map.Entry<String, Integer> a = entrys[i];
        entrys[i] = entrys[j];
        entrys[j] = a;
    }
}

class MyComparator implements Comparator<Map.Entry<String, Integer>> {

    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
        String word1 = e1.getKey();
        int freq1 = e1.getValue();
        String word2 = e2.getKey();
        int freq2 = e2.getValue();
        if(freq1!=freq2){
            return freq2-freq1;
        }
        else {
            return word1.compareTo(word2);
        }
    }
}