class Meeting_253 {
	class Interval {
		int start, end;
	}

	// Standard solution #1: Priority Queue
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals.length == 0) return 0;

		PriorityQueue<Integer> allocator = new PriorityQueue<>();

		Arrays.sort(intervals, Comparator.comparing((Interval i) -> i.start));

		// Add the first meeting
		allocator.add(intervals[0].end);

	    // Iterate over remaining intervals
	    for (int i = 1; i < intervals.length; i++) {

	        // If the room due to free up the earliest is free, assign that room to this meeting.
	        if (intervals[i].start >= allocator.peek()) {
	        	allocator.poll();
	      	}

		    // If a new room is to be assigned, then also we add to the heap,
		    // If an old room is allocated, then also we have to add to the heap with updated end time.
		    allocator.add(intervals[i].end);
	    }

	    // The size of the heap tells us the minimum rooms required for all the meetings.
	    return allocator.size();
	}



	// Standard solution #2: Chronological Ordering
	/*
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals.length == 0) return 0;
		int N = intervals.length;
		int[] start = new int[N];
		int[] end = new int[N];
		for (int i = 0; i < N; i++) {
			start[i] = intervals[i].start;
			end[i] = intervals[i].end;
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int usedRooms = 0;
		int startPointer = 0, endPointer = 0;
		while (startPointer < N) {
			if (start[startPointer] >= end[endPointer]) {
				usedRooms--;
				endPointer++;
			}
			usedRooms++;
			startPointer++;
		}
		return usedRooms;
	}
	*/
}




// https://leetcode.com/problems/meeting-rooms-ii/solution/
// Detailed explanation for Approach 2: Chronological Ordering
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
	    // Check for the base case. If there are no intervals, return 0
	    if (intervals.length == 0) {
	      return 0;
	    }

	    Integer[] start = new Integer[intervals.length];
	    Integer[] end = new Integer[intervals.length];

	    for (int i = 0; i < intervals.length; i++) {
	      start[i] = intervals[i][0];
	      end[i] = intervals[i][1];
	    }

	    // Sort the intervals by end time
	    Arrays.sort(
	        end,
	        new Comparator<Integer>() {
	          public int compare(Integer a, Integer b) {
	            return a - b;
	          }
	        });

	    // Sort the intervals by start time
	    Arrays.sort(
	        start,
	        new Comparator<Integer>() {
	          public int compare(Integer a, Integer b) {
	            return a - b;
	          }
	        });

	    // The two pointers in the algorithm: e_ptr and s_ptr.
	    int startPointer = 0, endPointer = 0;

	    // Variables to keep track of maximum number of rooms used.
	    int usedRooms = 0;

	    // Iterate over intervals.
	    while (startPointer < intervals.length) {

	      // If there is a meeting that has ended by the time the meeting at `start_pointer` starts
	      if (start[startPointer] >= end[endPointer]) {
	        usedRooms -= 1;
	        endPointer += 1;
	      }

	      // We do this irrespective of whether a room frees up or not.
	      // If a room got free, then this used_rooms += 1 wouldn't have any effect. used_rooms would
	      // remain the same in that case. If no room was free, then this would increase used_rooms
	      usedRooms += 1;
	      startPointer += 1;

	    }

	    return usedRooms;
  	}
}