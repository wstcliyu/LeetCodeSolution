// Approach 1: BFS (Breadth-First Search)
// Time: O(NK), Space: O(NK)
class StepState {
    /**
     * data object to keep the state info for each step:
     * <steps, row, col, remaining_eliminations>
     */
    public int steps, row, col, k;

    public StepState(int steps, int row, int col, int k) {
        this.steps = steps;
        this.row = row;
        this.col = col;
        this.k = k;
    }

    @Override
    public int hashCode() {
        // needed when we put objects into any container class
        return (this.row + 1) * (this.col + 1) * this.k;
    }

    @Override
    public boolean equals(Object other) {
        /**
         * only (row, col, k) matters as the state info
         */
        if (!(other instanceof StepState)) {
            return false;
        }
        StepState newState = (StepState) other;
        return (this.row == newState.row) && (this.col == newState.col) && (this.k == newState.k);
    }

    @Override
    public String toString() {
        return String.format("%d %d %d", this.row, this.col, this.k);
    }
}

class Solution {
    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        int[] target = {rows - 1, cols - 1};

        // if we have sufficient quotas to eliminate the obstacles in the worst case,
        // then the shortest distance is the Manhattan distance.
        if (k >= rows + cols - 2) {
            return rows + cols - 2;
        }

        Deque<StepState> queue = new LinkedList<>();
        HashSet<StepState> seen = new HashSet<>();

        // (steps, row, col, remaining quota to eliminate obstacles)
        StepState start = new StepState(0, 0, 0, k);
        queue.addLast(start);
        seen.add(start);

        while (!queue.isEmpty()) {
            StepState curr = queue.pollFirst();

            // we reach the target here
            if (target[0] == curr.row && target[1] == curr.col) {
                return curr.steps;
            }

            int[] nextSteps = {curr.row, curr.col + 1, curr.row + 1, curr.col,
                    curr.row, curr.col - 1, curr.row - 1, curr.col};

            // explore the four directions in the next step
            for (int i = 0; i < nextSteps.length; i += 2) {
                int nextRow = nextSteps[i];
                int nextCol = nextSteps[i + 1];

                // out of the boundary of grid
                if (0 > nextRow || nextRow == rows || 0 > nextCol || nextCol == cols) {
                    continue;
                }

                int nextElimination = curr.k - grid[nextRow][nextCol];
                StepState newState = new StepState(curr.steps + 1, nextRow, nextCol, nextElimination);

                // add the next move in the queue if it qualifies.
                if (nextElimination >= 0 && !seen.contains(newState)) {
                    seen.add(newState);
                    queue.addLast(newState);
                }
            }
        }

        // did not reach the target
        return -1;
    }
}




// Approach 2: A* (A Star) Algorithm
// Time: O(NKlog(NK)), Space: O(NK)
class StepState implements Comparable {
    /**
     * state info for each step:
     * <estimation, steps, row, col, remaining_eliminations>
     */
    public int estimation, steps, row, col, k;
    private int[] target;

    public StepState(int steps, int row, int col, int k, int[] target) {
        this.steps = steps;
        this.row = row;
        this.col = col;
        this.k = k;

        this.target = target;
        int manhattanDistance = target[0] - row + target[1] - col;
        // h(n) = manhattan distance,  g(n) = 0
        // estimation = h(n) + g(n)
        this.estimation = manhattanDistance + steps;
    }

    @Override
    public int hashCode() {
        return (this.row + 1) * (this.col + 1) * this.k;
    }

    @Override
    public int compareTo(Object o) {
        // order the elements solely based on the 'estimation' value
        StepState other = (StepState) o;
        return this.estimation - other.estimation;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StepState)) {
            return false;
        }
        StepState newState = (StepState) o;
        return (this.row == newState.row) && (this.col == newState.col) && (this.k == newState.k);
    }

    @Override
    public String toString() {
        return String.format("(%d %d %d %d %d)",
                this.estimation, this.steps, this.row, this.col, this.k);
    }
}

class Solution {

    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        int[] target = {rows - 1, cols - 1};

        PriorityQueue<StepState> queue = new PriorityQueue<>();
        HashSet<StepState> seen = new HashSet<>();

        // (steps, row, col, remaining quota to eliminate obstacles)
        StepState start = new StepState(0, 0, 0, k, target);
        queue.offer(start);
        seen.add(start);

        while (!queue.isEmpty()) {
            StepState curr = queue.poll();

            // we can reach the target in the shortest path (manhattan distance),
            //   even if the remaining steps are all obstacles
            int remainMinDistance = curr.estimation - curr.steps;
            if (remainMinDistance <= curr.k) {
                return curr.estimation;
            }

            int[] nextSteps = {curr.row, curr.col + 1, curr.row + 1, curr.col,
                    curr.row, curr.col - 1, curr.row - 1, curr.col};

            // explore the four directions in the next step
            for (int i = 0; i < nextSteps.length; i += 2) {
                int nextRow = nextSteps[i];
                int nextCol = nextSteps[i + 1];

                // out of the boundary of grid
                if (0 > nextRow || nextRow == rows || 0 > nextCol || nextCol == cols) {
                    continue;
                }

                int nextElimination = curr.k - grid[nextRow][nextCol];
                StepState newState = new StepState(
                        curr.steps + 1, nextRow, nextCol, nextElimination, target);

                // add the next move in the queue if it qualifies.
                if (nextElimination >= 0 && !seen.contains(newState)) {
                    seen.add(newState);
                    queue.offer(newState);
                }
            }
        }

        // did not reach the target
        return -1;
    }
}