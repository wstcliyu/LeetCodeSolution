// https://leetcode.com/problems/concatenated-words/discuss/348972/Java-Common-template-Word-Break-I-Word-Break-II-Concatenated-Words
// Summary of Word Break series 139, 140, 472

// Top-down
class Solution {
  public List<String> findAllConcatenatedWordsInADict(String[] words) {
 //sort the array in asc order of word length, since longer words are formed by shorter words.
	Arrays.sort(words, (a,b) -> a.length() - b.length());

	List<String> result = new ArrayList<>();

	//list of shorter words 
	HashSet<String> preWords = new HashSet<>();

	for(int i=0; i< words.length; i++){
	  //Word Break-I problem.
	  if(topDown(words[i], preWords, 0, new Boolean[words[i].length()])) {
	      result.add(words[i]);
	  }
	  preWords.add(words[i]);
	}
	return result;
  }

  private boolean topDown(String s, HashSet<String> wordDict, int startIndex, Boolean[] memo) {
	if(wordDict.isEmpty()) {
	 return false;
	}
	// if we reach the beyond the string, then return true
	// s = "leetcode" when "code" is being checked in the IF() of the loop, we reach endIndex == s.length(), 
	// and wordDict.contains("code") => true and topDown(s, wordDict, endIndex, memo) needs to return true. 
	if(startIndex == s.length()) {
	 return true;
	}

	// memo[i] = true means => that the substring from index i can be segmented. 
	// memo[startIndex] means => wordDict contains substring from startIndex and it can be segemented.
	if(memo[startIndex] != null) { //Boolean[] array's default value is "null"
	 return memo[startIndex];
	}

	for(int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++) {
	 if(wordDict.contains(s.substring(startIndex, endIndex)) && topDown(s, wordDict, endIndex, memo)) {
	     memo[startIndex] = true;
	     return true;
	 }
	}
	memo[startIndex] = false;
	return false;
  }
}




// Bottom-up
class Solution {	 
   public List<String> findAllConcatenatedWordsInADict(String[] words) {
   
    //sort the array in asc order of word length, since longer words are formed by shorter words.
    Arrays.sort(words, (a,b) -> a.length() - b.length());
    
	List<String> result = new ArrayList<>();
    
    //list of shorter words 
    HashSet<String> preWords = new HashSet<>();
    
    for(int i=0; i< words.length; i++){
        //Word Break-I problem.
        if(wordBreak(words[i], preWords)) result.add(words[i]);
        preWords.add(words[i]);
    }
    return result;
   }
   
   private boolean wordBreak(String s, HashSet<String> preWords){
    if(preWords.isEmpty()) return false;
    
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    
    for(int i = 1; i <= s.length(); i++){
        for(int j = 0; j < i; j++){
            if(dp[j] && preWords.contains(s.substring(j, i))){
                dp[i] = true;
                break;
            }
        }
    }
    return dp[s.length()];
   }
}