class Solution {
    public int numTilePossibilities(String tiles) {
        int[] counts = new int[26];
        for (char c : tiles.toCharArray()) counts[c - 'A']++;
        return backtrack(counts);
    }
    
    private int backtrack(int[] counts) {
        int sum = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 0) continue;
            sum++;
            counts[i]--;
            sum += backtrack(counts);
            counts[i]++;
        }
        return sum;
    }
}





// https://leetcode.com/problems/letter-tile-possibilities/discuss/308284/Concise-java-solution
// Thoughts

// input: AAB
// count: A -> 2, B -> 1

// For sequence of length 1:

// We can pick either A, or B.
// So we have "A", "B".
// For sequence of length 2:

// We build it based on "sequence of length 1"
// For "A":
// count: A -> 1, B -> 1
// We can still pick either A, or B
// So we have "AA", "AB"
// For "B":
// count: A -> 2, B -> 0
// We can only pick A
// So we have "BA"
// For sequence of length 3: blablabla

// Implementation

// We don't need to keep track of the sequence. We only need count
// If we implement the above idea by each level (Count all sequence of length 1, then count all sequence of length 2, etc), we have to remember previous sequence.
// So we use recursion instead. Just remember to add the count back (arr[i]++).