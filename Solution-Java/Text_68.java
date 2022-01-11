// https://leetcode.com/problems/text-justification/discuss/24902/Java-easy-to-understand-broken-into-several-functions
// Most voted solution
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0; List<String> result = new ArrayList<>();
        
        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            result.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }
        
        return result;
    }
    
    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right++].length();
        
        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth)
            sum += 1 + words[right++].length();
            
        return right - 1;
    }
    
    private String justify(int left, int right, String[] words, int maxWidth) {
        if (right - left == 0) return padResult(words[left], maxWidth);
        
        boolean isLastLine = right == words.length - 1;
        int numSpaces = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);
        
        String space = isLastLine ? " " : blank(totalSpace / numSpaces);
        int remainder = isLastLine ? 0 : totalSpace % numSpaces;
        
        StringBuilder result = new StringBuilder();
        for (int i = left; i <= right; i++)
            result.append(words[i])
                .append(space)
                .append(remainder-- > 0 ? " " : "");
        
        return padResult(result.toString().trim(), maxWidth);
    }
    
    private int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) wordsLength += words[i].length();
        return wordsLength;
    }
    
    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }
    
    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }
}




// Second voted solution
class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<>();
        int N = words.length;
        for (int i = 0, k, l; i < N; i += k) {
            for (k = l = 0; i + k < N && l + words[i + k].length() <= L - k; k++) {
                l += words[i + k].length();
            }
            StringBuilder sb = new StringBuilder(words[i]);
            // If k == 1, it means there is only 1 word in this line
            // So the following loop will not execute
            // This line will be left justified
            for (int j = 0; j < k - 1; j++) {
                if (i + k == N) {
                    // The last line must be left justified
                    sb.append(' ');
                } else {
                    int q = (L - l) / (k - 1);
                    int r = (L - l) % (k - 1);
                    for (int z = 0; z < q + (j < r ? 1 : 0); z++) {
                        sb.append(' ');
                    }
                }
                
                sb.append(words[i + j + 1]);
            }
            while (sb.length() < L)
                sb.append(' ');
            res.add(sb.toString());
        }
        return res;
    }
}