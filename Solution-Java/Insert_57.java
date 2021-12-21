// My updated solution
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ls = new ArrayList<>();
        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            ls.add(intervals[i++]);
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval = new int[]{Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1])};
            i++;
        }
        ls.add(newInterval);

        while (i < intervals.length) {
            ls.add(intervals[i++]);
        }
        
        return ls.toArray(new int[ls.size()][]);
    }
}




class Solution {
	class Interval {
		int start, end;
		Interval() {start = 0; end = 0;}
		Interval(int s, int e) {
			start = s;
			end = e;
		} 
	}

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for (Interval i : intervals) {
            if (i.end < newInterval.start) {
                res.add(i);
            } else if (i.start > newInterval.end) {
                res.add(newInterval);
                newInterval = i;
            } else {
                int s = Math.min(i.start, newInterval.start);
                int e = Math.max(i.end, newInterval.end);
                newInterval = new Interval(s, e);
            }
        }
        res.add(newInterval);
        return res;
    }
}