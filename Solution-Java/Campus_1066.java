// Here N is the number of workers, and M is the number of bikes.
// P(M,N) = M!/(M−N)!
// C(M,N)=M!/((M−N)!⋅N!)




// Approach 1: Greedy Backtracking
// Time: O(P(M,N))
// Space: O(M + N)
class Solution {
    // Maximum number of bikes is 10
    boolean visited [] = new boolean[10];
    int smallestDistanceSum = Integer.MAX_VALUE;
    
    // Manhattan distance
    private int findDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
    
    private void minimumDistanceSum(int[][] workers, int workerIndex, int[][] bikes, int currDistanceSum) {
        if (workerIndex >= workers.length) {
            smallestDistanceSum = Math.min(smallestDistanceSum, currDistanceSum);
            return;
        }
        // If the current distance sum is greater than the smallest result 
        // found then stop exploring this combination of workers and bikes
        if (currDistanceSum >= smallestDistanceSum) {
            return;
        }
        for (int bikeIndex = 0; bikeIndex < bikes.length; bikeIndex++) {
            // If bike is available
            if (!visited[bikeIndex]) {
                visited[bikeIndex] = true;
                minimumDistanceSum(workers, workerIndex + 1, bikes, 
                    currDistanceSum + findDistance(workers[workerIndex], bikes[bikeIndex]));
                visited[bikeIndex] = false;
            }
        }
    }
    
    public int assignBikes(int[][] workers, int[][] bikes) {
        minimumDistanceSum(workers, 0, bikes, 0);
        return smallestDistanceSum;
    } 
}




// Approach 2: Top-Down Dynamic Programming + BitMasking
// Time: O(M * 2^M)
// Space: O(2^M)
class Solution {
    // Maximum value of mask will be 2^(Number of bikes)
    // and number of bikes can be 10 at max
    int memo [] = new int[1024];
    
    // Manhattan distance
    private int findDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
    
    private int minimumDistanceSum(int[][] workers, int[][] bikes, int workerIndex, int mask) {
        if (workerIndex >= workers.length) {
            return 0;
        }
        
        // If result is already calculated, return it no recursion needed
        if (memo[mask] != -1)
            return memo[mask];
        
        int smallestDistanceSum = Integer.MAX_VALUE;
        for (int bikeIndex = 0; bikeIndex < bikes.length; bikeIndex++) {
            // Check if the bike at bikeIndex is available
            if ((mask & (1 << bikeIndex)) == 0) {
                // Adding the current distance and repeat the process for next worker
                // also changing the bit at index bikeIndex to 1 to show the bike there is assigned
                smallestDistanceSum = Math.min(smallestDistanceSum, 
                                               findDistance(workers[workerIndex], bikes[bikeIndex]) + 
                                               minimumDistanceSum(workers, bikes, workerIndex + 1, 
                                                                  mask | (1 << bikeIndex)));
            }
        }
        
        // Memoizing the result corresponding to mask
        return memo[mask] = smallestDistanceSum;
    }
    
    public int assignBikes(int[][] workers, int[][] bikes) {
        Arrays.fill(memo, -1);
        return minimumDistanceSum(workers, bikes, 0, 0);
    }
}




// Approach 3: Bottom-Up Dynamic Programming + BitMasking
// Time: O(M * 2^M)
// Space: O(2^M)
class Solution {
    // Maximum value of mask will be 2^(Number of bikes)
    // And number of bikes can be 10 at max
    int memo [] = new int[1024];
    
    // Count the number of ones using Brian Kernighan’s Algorithm
    private int countNumOfOnes(int mask) {
        int count = 0;
        while (mask != 0) {
            mask &= (mask - 1);
            count++;
        } 
        return count;
    }
    
    // Manhattan distance
    private int findDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
    
    private int minimumDistanceSum(int[][] workers, int[][] bikes) {
        int numOfBikes = bikes.length;
        int numOfWorkers = workers.length;
        int smallestDistanceSum = Integer.MAX_VALUE;

        // 0 signifies that no bike has been assigned and
        // Distance sum for not assigning any bike is equal to 0
        memo[0] = 0;
        
        // Traverse over all the possible values of mask
        for (int mask = 0; mask < (1 << numOfBikes); mask++) {
            int nextWorkerIndex = countNumOfOnes(mask);
            
            // If mask has more number of 1's than the number of workers
            // Then we can update our answer accordingly
            if (nextWorkerIndex >= numOfWorkers) {
                smallestDistanceSum = Math.min(smallestDistanceSum, memo[mask]);
                continue;
            }
            
            for (int bikeIndex = 0; bikeIndex < numOfBikes; bikeIndex++) {
                // Checking if the bike at bikeIndex has already been assigned
                if ((mask & (1 << bikeIndex)) == 0) {
                    int newMask = (1 << bikeIndex) | mask;
                    
                    // Updating the distance sum for newMask
                    memo[newMask] = Math.min(memo[newMask], memo[mask] + 
                                             findDistance(workers[nextWorkerIndex], bikes[bikeIndex]));
                }
            }
        }
        
        return smallestDistanceSum;
    }
    
    public int assignBikes(int[][] workers, int[][] bikes) {      
        // Initializing the answers for all masks to be INT_MAX
        Arrays.fill(memo, Integer.MAX_VALUE);
        return minimumDistanceSum(workers, bikes);
	}
}




// Approach 4: Priority Queue (Similar to Dijkstra's Algorithm)
// Time: O(P(M,N) * log(P(M,N)) + (M * log(P(M,N)) * 2^M)
// Space: O(P(M, N) + 2^M)
class Solution {
    // Manhattan distance
    private int findDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
    
    // Count the number of ones using Brian Kernighan’s Algorithm
    private int countNumOfOnes(int mask) {
        int count = 0;
        while (mask != 0) {
            mask &= (mask - 1);
            count++;
        } 
        return count;
    }
    
    public int assignBikes(int[][] workers, int[][] bikes) {
        int numOfBikes = bikes.length, numOfWorkers = workers.length;
        
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<Integer> visited = new HashSet<>();

        // Initially both distance sum and mask is 0
        priorityQueue.add(new int[]{0, 0});
        while (!priorityQueue.isEmpty()) {
            int currentDistanceSum = priorityQueue.peek()[0];
            int currentMask = priorityQueue.peek()[1];
            priorityQueue.remove();
            
            // Continue if the mask is already traversed
            if (visited.contains(currentMask))
                continue;
            
            // Marking the mask as visited
            visited.add(currentMask);
            // Next Worker index would be equal to the number of 1's in currentMask
            int workerIndex = countNumOfOnes(currentMask);
            
            // Return the current distance sum if all workers are covered
            if (workerIndex == numOfWorkers) {
                return currentDistanceSum;
            }

            for (int bikeIndex = 0; bikeIndex < numOfBikes; bikeIndex++) {
                // Checking if the bike at bikeIndex has been assigned or not
                if ((currentMask & (1 << bikeIndex)) == 0) {
                    int nextStateDistanceSum = currentDistanceSum + 
                        findDistance(workers[workerIndex], bikes[bikeIndex]);
                    
                    // Put the next state pair into the priority queue
                    int nextStateMask = currentMask | (1 << bikeIndex);
                    priorityQueue.add(new int[]{nextStateDistanceSum, nextStateMask});
                }
            }
        }
        
        // This statement will never be executed provided there is at least one bike per worker
        return -1;
    }
}