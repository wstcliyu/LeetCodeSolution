// Approach 3: Using Sorting + Binary Search
public class Solution {

	public int[] binary_search(int[][] intervals, int target, int start, int end) {
		if (start >= end) {
			if (intervals[start][0] >= target) {
				return intervals[start];
			}
			return null;
		}
		int mid = (start + end) / 2;
		if (intervals[mid][0] < target) {
			return binary_search(intervals, target, mid + 1, end);
		} else {
			return binary_search(intervals, target, start, mid);
		}
	}

  	public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        HashMap<int[], Integer> hash = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            hash.put(intervals[i], i);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = binary_search(intervals, intervals[i][1], 0, intervals.length - 1);
            res[hash.get(intervals[i])] = interval == null ? -1 : hash.get(interval);
        }
        return res;
    }
}




// Approach 4: Using TreeMap
public class Solution {

  public int[] findRightInterval(int[][] intervals) {
    TreeMap<Integer, Integer> starts = new TreeMap<>();
    int res[] = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      starts.put(intervals[i][0], i);
    }
    for (int i = 0; i < intervals.length; i++) {
      Map.Entry<Integer, Integer> pos = starts.ceilingEntry(intervals[i][1]);
      res[i] = pos == null ? -1 : pos.getValue();
    }
    return res;
  }
}




// Approach 5: Using Two Arrays without Binary Search
public class Solution {

  public int[] findRightInterval(int[][] intervals) {
    int[][] endIntervals = Arrays.copyOf(intervals, intervals.length);
    HashMap<int[], Integer> hash = new HashMap<>();
    for (int i = 0; i < intervals.length; i++) {
      hash.put(intervals[i], i);
    }
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    Arrays.sort(endIntervals, (a, b) -> a[1] - b[1]);
    int j = 0;
    int[] res = new int[intervals.length];
    for (int i = 0; i < endIntervals.length; i++) {
      while (j < intervals.length && intervals[j][0] < endIntervals[i][1]) {
        j++;
      }
      res[hash.get(endIntervals[i])] = j == intervals.length ? -1 : hash.get(intervals[j]);
    }
    return res;
  }
}
