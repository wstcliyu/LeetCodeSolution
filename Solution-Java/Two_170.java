// https://leetcode.com/problems/two-sum-iii-data-structure-design/discuss/52005/Trade-off-in-this-problem-should-be-considered
// The big data test only have the condition that lots of add and few find.
// In fact, there has to be one operation's time complexity is O(n) and the other is O(1), no matter add or find.
// So clearly there's trade off when solve this problem, prefer quick find or quick add.
// If consider more find and less add or we only care time complexity in finding.For example, add operation can be pre-done.

// Time: O(n) write, O(1) read
// Space: O(n^2)
public class TwoSum {
    Set<Integer> sum;
    Set<Integer> num;
    
    TwoSum(){
        sum = new HashSet<Integer>();
        num = new HashSet<Integer>();
    }

    // Add the number to an internal data structure.
	public void add(int number) {
	    if(num.contains(number)){
	        sum.add(number * 2);
	    }else{
	        Iterator<Integer> iter = num.iterator();
	        while(iter.hasNext()){
	            sum.add(iter.next() + number);
	        }
	        num.add(number);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    return sum.contains(value);
	}
}




// Time: O(1) write, O(n) read
// Space: O(n)
class TwoSum {
    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Integer n : map.keySet()) {
            int complement = value - n;
            if (map.containsKey(complement){
                if (n != complement || map.get(complement) > 1) {
                	return true;
                }
            }
        }
        return false;
    }
}