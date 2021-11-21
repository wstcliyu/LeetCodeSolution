class SnapshotArray {
    // https://leetcode.com/problems/snapshot-array/discuss/350562/JavaPython-Binary-Search
    // lee215

    // Complexity
    // Time O(logS)
    // Space O(S)
    // where S is the number of set called.

    // SnapshotArray(int length) is O(N) time
    // set(int index, int val) is O(1) in Python and O(logSnap) in Java
    // snap() is O(1)
    // get(int index, int snap_id) is O(logSnap)
    
    TreeMap<Integer, Integer>[] treeMaps;
    int snapshotId;

    public SnapshotArray(int length) {
        treeMaps = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            treeMaps[i] = new TreeMap<Integer, Integer>();
            treeMaps[i].put(0, 0);
        }
        snapshotId = 0;
    }
    
    public void set(int index, int val) {
        treeMaps[index].put(snapshotId, val);
    }
    
    public int snap() {
        return snapshotId++;
    }
    
    public int get(int index, int snap_id) {
        return treeMaps[index].floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */