class Solution {
    class Point implements Comparable<Point> {
        int x, y, count;
        String path;

        Point(int x, int y, int count, String path) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.path = path;
        }

        @Override
        public int compareTo(Point p) {
            return this.count != p.count ? this.count - p.count : this.path.compareTo(p.path);
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(x + ",").append(y + ",").append(count + ",").append(path);
            return sb.toString();
        }
    }
    
    private int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private String[] instructions = {"r", "l", "u", "d"};
    
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        Point[][] points = new Point[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                points[i][j] = new Point(i, j, Integer.MAX_VALUE, "");
            }
        }

        points[ball[0]][ball[1]].count = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(points[ball[0]][ball[1]]);

        while (!pq.isEmpty()) {
            Point point = pq.poll();

            for (int i = 0; i < 4; i++) {
                int x = point.x + dirs[i][0];
                int y = point.y + dirs[i][1];
                int count = 0;
                
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0 && (x != hole[0] || y != hole[1])) {
                    x += dirs[i][0];
                    y += dirs[i][1];
                    count++;
                }

                if (x == hole[0] && y == hole[1]) {
                    count++;
                } else {
                    x -= dirs[i][0];
                    y -= dirs[i][1];
                }

                Point temp = new Point(x, y, point.count + count, point.path + instructions[i]);
                if (points[x][y].compareTo(temp) > 0) {
                    points[x][y] = temp;
                    pq.add(points[x][y]);
                }
            }
        }
        
        return points[hole[0]][hole[1]].count == Integer.MAX_VALUE ? "impossible" : points[hole[0]][hole[1]].path;
    }
}