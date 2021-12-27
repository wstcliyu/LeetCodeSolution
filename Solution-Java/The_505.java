// Approach #1 Depth First Search
// Time complexity : O(m * n * max(m,n)). 
// Complete traversal of maze will be done in the worst case. 
// Here, m and n refers to the number of rows and columns of the maze. 
// Further, for every current node chosen, we can travel upto a maximum depth of max(m,n) in any direction.
// Space complexity : O(mn). distancedistance array of size m * n is used.
class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, distance);
        int res = distance[destination[0]][destination[1]];
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
    public void dfs(int[][] maze, int[] start, int[][] distance) {
        for (int[] dir : dirs) {
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int count = 0;
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
                count++;
            }
            x -= dir[0];
            y -= dir[1];
            if (distance[x][y] > count + distance[start[0]][start[1]]) {
                distance[x][y] = count + distance[start[0]][start[1]];
                dfs(maze, new int[]{x, y}, distance);
            }
        }
    }
}




// Approach #2 Using Breadth First Search
// Time complexity : O(m * n * max(m,n)). 
// Complete traversal of maze will be done in the worst case. 
// Here, m and n refers to the number of rows and columns of the maze. 
// Further, for every current node chosen, we can travel upto a maximum depth of max(m,n) in any direction.
// Space complexity : O(mn). distancedistance array of size m * n is used.
class Solution {
	private int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start[0], start[1]});
        
        while (!q.isEmpty()) {
        	int[] point = q.removeFirst();
        	for (int[] dir : dirs) {
        		int x = point[0] + dir[0];
        		int y = point[1] + dir[1];
        		int count = 0;
        		while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
        			x += dir[0];
        			y += dir[1];
        			count++;
        		}
        		x -= dir[0];
        		y -= dir[1];
        		if (distance[x][y] > count + distance[point[0]][point[1]]) {
        			distance[x][y] = count + distance[point[0]][point[1]];
        			q.add(new int[]{x, y});
        		}
        	}
        }

        int res = distance[destination[0]][destination[1]];
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}




// Approach #4 Using Dijkstra Algorithm and Priority Queue
// Time complexity : O(m * n * log(mn)). 
// Complete traversal of maze will be done in the worst case giving a factor of mnmn. 
// Further, poll method is a combination of heapifying(O(log(n))) and removing the top element(O(1)) from the priority queue, 
// and it takes O(n) time for n elements. In the current case, poll introduces a factor of log(mn).
// Space complexity : O(mn). distancedistance array of size m * n is used and queuequeue size can grow upto m * n in worst case.
class Solution {
	private int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{start[0], start[1], 0});
        
        while (!pq.isEmpty()) {
        	int[] point = pq.poll();
        	for (int[] dir : dirs) {
        		int x = point[0] + dir[0];
        		int y = point[1] + dir[1];
        		int count = 0;
        		while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
        			x += dir[0];
        			y += dir[1];
        			count++;
        		}
        		x -= dir[0];
        		y -= dir[1];
        		if (distance[x][y] > count + distance[point[0]][point[1]]) {
        			distance[x][y] = count + distance[point[0]][point[1]];
        			pq.add(new int[]{x, y, distance[x][y]});
        		}
        	}
        }
        
        int res = distance[destination[0]][destination[1]];
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}