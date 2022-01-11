// https://leetcode.com/problems/sentence-screen-fitting/discuss/90846/JAVA-optimized-solution-17ms
// Second voted solution (DP)
// sub-problem: if there's a new line which is starting with certain index in sentence, what is the starting index of next line (nextIndex[]). 
// BTW, we compute how many times the pointer in current line passes over the last index (times[]).
// relation : ans += times[i], i = nextIndex[i], for _ in 0..<row. where i indicates what is the first word in the current line.
// Time complexity : O(n*(cols/lenAverage)) + O(rows), where n is the length of sentence array, lenAverage is the average length of the words in the input array.
class Solution {
	public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] nextIndex = new int[sentence.length];
        int[] times = new int[sentence.length];
        for(int i=0;i<sentence.length;i++) {
            int curLen = 0;
            int cur = i;
            int time = 0;
            while(curLen + sentence[cur].length() <= cols) {
                curLen += sentence[cur++].length()+1;
                if(cur==sentence.length) {
                    cur = 0;
                    time ++;
                }
            }
            nextIndex[i] = cur;
            times[i] = time;
        }
        int ans = 0;
        int cur = 0;
        for(int i=0; i<rows; i++) {
            ans += times[cur];
            cur = nextIndex[cur];
        }
        return ans;
    }
}




// https://leetcode.com/problems/sentence-screen-fitting/discuss/90845/21ms-18-lines-Java-solution
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                    start--;
                }
            }
        }
        
        return start / s.length();
    }
}