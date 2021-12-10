// Approach 1: Breadth-First Search
class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            // check if reach zero
            if (arr[node] == 0) {
                return true;
            }
            if (arr[node] < 0) {
                continue;
            }

            // check available next steps
            if (node + arr[node] < n) {
                q.offer(node + arr[node]);
            }
            if (node - arr[node] >= 0) {
                q.offer(node - arr[node]);
            }
            // mark as visited
            arr[node] = -arr[node];
        }
        return false;
    }
}




// Approach 2: Depth-First Search
class Solution {
    public boolean canReach(int[] arr, int start) {
        if (start >= 0 && start < arr.length && arr[start] >= 0) {
            if (arr[start] == 0) {
                return true;
            }
            arr[start] = -arr[start];
            return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
        }
        return false;
    }
}




// My solution: DFS
// Like Course_207, Course_210
class Solution {
    
    enum State {
        UNKNOWN,
        VISITING,
        VISITED
    }
    
    public boolean canReach(int[] arr, int start) {
        State[] states = new State[arr.length];
        Arrays.fill(states, State.UNKNOWN);
        dfs(arr, start, states);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && states[i] == State.VISITED) {
                return true;
            }
        }
        return false;
    }
    
    private void dfs(int[] arr, int i, State[] states) {
        if (states[i] == State.VISITING) {
            return;
        }
        states[i] = State.VISITING;
        if (i + arr[i] < arr.length) {
            dfs(arr, i + arr[i], states);
        }
        if (i - arr[i] >= 0) {
            dfs(arr, i - arr[i], states);
        }
        states[i] = State.VISITED;
    }
}