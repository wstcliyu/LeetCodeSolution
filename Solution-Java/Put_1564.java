// Let n be the number of boxes and m be the number of rooms in the warehouse.




// Approach 1: Add Smallest Boxes to the Rightmost Warehouse Rooms
// Time complexity: O(nlog(n) + m) because we need to sort the boxes O(nlogn) and iterate over the warehouse rooms and boxes O(n + m).
// Space complexity: O(1) because we use two pointers to iterate over the boxes and warehouse rooms. 
// If we are not allowed to modify the warehouse array, we will need O(m) extra space.
class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        // Preprocess the height of the warehouse rooms to get usable heights
        for (int i = 1; i < warehouse.length; i++) {
            warehouse[i] = Math.min(warehouse[i - 1], warehouse[i]);
        }

        // Iterate through boxes from smallest to largest
        Arrays.sort(boxes);

        int count = 0;

        for (int i = warehouse.length - 1; i >= 0; i--) {
            // Count the boxes that can fit in the current warehouse room
            if (count < boxes.length && boxes[count] <= warehouse[i]) {
                count++;
            }
        }

        return count;
    }
}




// Approach 2: Add Largest Possible Boxes from Left to Right
// What if the interviewer requires us to use O(1) space and does not allow us to modify the original warehouse array? 
// This follow-up request excludes the possibility of preprocessing the input array as we did before.
// Time complexity: O(n log(n) + m) because we need to sort the boxes and iterate over the warehouse rooms and boxes.
// Space: O(1)
class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {

        int i = boxes.length - 1;
        int count = 0;
        Arrays.sort(boxes);

        for (int room : warehouse) {
            // Iterate through boxes from largest to smallest
            // Discard boxes that doesn't fit in the current warehouse
            while (i >= 0 && boxes[i] > room) {
                i--;
            }

            if (i == -1) return count;
            count++;
            i--;
        }

        return count;
    }
}