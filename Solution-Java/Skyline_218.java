// Priority Queue
class Skyline_218 {
    // Second voted solution
    /*
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>(); // height list to store all buildings' heights
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]}); // start of a building, height stored as negtive
            height.add(new int[]{b[1], b[2]});  // end of a building, height stored as positive
        }
        Collections.sort(height, Comparator.comparing((int[] p) -> p[0]).thenComparing(p -> p[1]));
        
        // a pq that stores all the encountered buildings' heights in descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int preMax = 0;
        pq.add(0);
        for (int[] h : height) {
            if (h[1] < 0) {
                pq.add(-h[1]);   // h[1] < 0, that means it meets a new building, so add it to pq
            } else {
                pq.remove(h[1]); // h[1] >=0, that means it has reached the end of the building, so remove it from pq
            }
            
            // the current max height in all encountered buildings
            int curMax = pq.peek();
            // if the max height is different from the previous one, that means a critical point is met, add to result list
            if (curMax != preMax) {
                preMax = curMax;
                res.add(Arrays.asList(h[0], curMax));
            }
        }
        return res;
    }
    */



    // Rewrite second voted solution: Use TreeMap instead of PriorityQueue
    // Much faster because PriorityQueue does not support remove in lgn time
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] building : buildings) {
            // start point has negative height value
            height.add(new int[]{building[0], -building[2]});
            // end point has normal height value
            height.add(new int[]{building[1], building[2]});
        }
        Collections.sort(height, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });
        // Use a maxHeap to store possible heights
        // But priority queue does not support remove in lgn time
        // treemap support add, remove, get max in lgn time, so use treemap here
        // key: height, value: number of this height
        TreeMap<Integer, Integer> pq = new TreeMap<>();
        pq.put(0, 1);
        // Before starting, the previous max height is 0;
        int prev = 0;
        // visit all points in order
        for (int[] h : height) {
            // a start point, add height
            if (h[1] < 0) {
                pq.put(-h[1], pq.getOrDefault(-h[1], 0) + 1);
            } else {  // a end point, remove height
                if (pq.get(h[1]) > 1) {
                    pq.put(h[1], pq.get(h[1]) - 1);
                } else {
                    pq.remove(h[1]);
                }
            }
            int cur = pq.lastKey();
            // compare current max height with previous max height, update result and 
            // previous max height if necessary
            if (cur != prev) {
                res.add(Arrays.asList(h[0], cur));
                prev = cur;
            }
        }
        return res;
    }



    // Good submission
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        
        //max heap by height. if same height des, by startX asc
        PriorityQueue<int[]> heightHeap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[2] == b[2] ? a[0] - b[0] : b[2] - a[2];
            } 
        });
        
        //create a pre to start with. we update the pre in all cases to the last processed building. 
        int[] pre = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
        for(int[] b : buildings) {
            
            // this is executed only if there is some unprocessed buildings in the heap
            // and our curent pre and next building are not overlapped.
            while(!heightHeap.isEmpty() && b[0] > pre[1]) { // totally separated
                //get the highest unprocessed.
                int[] curHeighest = heightHeap.poll();
                //if it is before pre end, we have already considered its effect.
                if(curHeighest[1] <= pre[1]) continue;
                //to result, we should add a point with height of that one and end of pre.
                res.add(Arrays.asList(pre[1], curHeighest[2]));
                //move pre to last processed highest one.
                pre = curHeighest;
            }
            
            //case when new building height is more than pre
            if(b[2] > pre[2]) {
                if(b[0] == pre[0]) { // we always make sure pre is the last element in the res
                    // if b[0] and pre[0] overlap but b is higher than pre, then we track the point in b not pre
                    res.remove(res.size() - 1);
                }
                res.add(Arrays.asList(b[0], b[2])); // highest point possibly has a pos in result;
                if(b[1] < pre[1]) {
                    heightHeap.offer(pre); //previous covers more length, need to add into heightheap for furture.
                }
                pre = b;
            }
            else if(b[1] > pre[1]) { //current is longer than pre.
                if(b[2] == pre[2]) { //if same height, just update end of pre
                    pre[1] = b[1];
                } else {
                    heightHeap.offer(b); //add to heap so that we can process it when pre ends.
                }
            }
        }
        
        
        while(!heightHeap.isEmpty()) { //we are at the end but still have some unprocesed 
            //heights which goes beyond the end of last building
            int[] cur = heightHeap.poll();
            if(cur[1] <= pre[1]) continue;
            res.add(Arrays.asList(pre[1], cur[2]));
            pre = cur;
        }
        
        if(pre[2] > 0) {
            res.add(Arrays.asList(pre[1], 0));
        }
        return res;   
    }
}




// Divide and Conquer
class Solution {
  /**
   *  Divide-and-conquer algorithm to solve skyline problem,
   *  which is similar with the merge sort algorithm.
   */
  public List<List<Integer>> getSkyline(int[][] buildings) {
    int n = buildings.length;
    List<List<Integer>> output = new ArrayList<List<Integer>>();

    // The base cases
    if (n == 0) return output;
    if (n == 1) {
      int xStart = buildings[0][0];
      int xEnd = buildings[0][1];
      int y = buildings[0][2];

      output.add(new ArrayList<Integer>() {{add(xStart); add(y); }});
      output.add(new ArrayList<Integer>() {{add(xEnd); add(0); }});
      // output.add(new int[]{xStart, y});
      // output.add(new int[]{xEnd, 0});
      return output;
    }

    // If there is more than one building,
    // recursively divide the input into two subproblems.
    List<List<Integer>> leftSkyline, rightSkyline;
    leftSkyline = getSkyline(Arrays.copyOfRange(buildings, 0, n / 2));
    rightSkyline = getSkyline(Arrays.copyOfRange(buildings, n / 2, n));

    // Merge the results of subproblem together.
    return mergeSkylines(leftSkyline, rightSkyline);
  }

  /**
   *  Merge two skylines together.
   */
  public List<List<Integer>> mergeSkylines(List<List<Integer>> left, List<List<Integer>> right) {
    int nL = left.size(), nR = right.size();
    int pL = 0, pR = 0;
    int currY = 0, leftY = 0, rightY = 0;
    int x, maxY;
    List<List<Integer>> output = new ArrayList<List<Integer>>();

    // while we're in the region where both skylines are present
    while ((pL < nL) && (pR < nR)) {
      List<Integer> pointL = left.get(pL);
      List<Integer> pointR = right.get(pR);
      // pick up the smallest x
      if (pointL.get(0) < pointR.get(0)) {
        x = pointL.get(0);
        leftY = pointL.get(1);
        pL++;
      }
      else {
        x = pointR.get(0);
        rightY = pointR.get(1);
        pR++;
      }
      // max height (i.e. y) between both skylines
      maxY = Math.max(leftY, rightY);
      // update output if there is a skyline change
      if (currY != maxY) {
        updateOutput(output, x, maxY);
        currY = maxY;
      }
    }

    // there is only left skyline
    appendSkyline(output, left, pL, nL, currY);

    // there is only right skyline
    appendSkyline(output, right, pR, nR, currY);

    return output;
  }

  /**
   * Update the final output with the new element.
   */
  public void updateOutput(List<List<Integer>> output, int x, int y) {
    // if skyline change is not vertical -
    // add the new point
    if (output.isEmpty() || output.get(output.size() - 1).get(0) != x)
      output.add(new ArrayList<Integer>() {{add(x); add(y); }});
      // if skyline change is vertical -
      // update the last point
    else {
      output.get(output.size() - 1).set(1, y);
    }
  }

  /**
   *  Append the rest of the skyline elements with indice (p, n)
   *  to the final output.
   */
  public void appendSkyline(List<List<Integer>> output, List<List<Integer>> skyline,
                            int p, int n, int currY) {
    while (p < n) {
      List<Integer> point = skyline.get(p);
      int x = point.get(0);
      int y = point.get(1);
      p++;

      // update output
      // if there is a skyline change
      if (currY != y) {
        updateOutput(output, x, y);
        currY = y;
      }
    }
  }
}