// Approach 1: Double Pass Depth-First Search (DFS)
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = findMaxDepth(nestedList);
        return weightedSum(nestedList, 1, maxDepth);
    }

    private int findMaxDepth(List<NestedInteger> list) {
        int maxDepth = 1;
        
        for (NestedInteger nested : list) {
            if (!nested.isInteger()) {
                maxDepth = Math.max(maxDepth, 1 + findMaxDepth(nested.getList()));
            }
        }
        
        return maxDepth;
    }
    
    private int weightedSum(List<NestedInteger> list, int depth, int maxDepth) {
        int answer = 0;
        for (NestedInteger nested : list) {
            if (nested.isInteger()) {
                answer += nested.getInteger() * (maxDepth - depth + 1);
            } else {
                answer += weightedSum(nested.getList(), depth + 1, maxDepth);
            }
        }
        return answer;
    }
}




// Approach 2: Single Pass Depth-First Search (DFS)
class WeightedSumTriplet {
    int maxDepth;
    int sumOfElements;
    int sumOfProducts;

    WeightedSumTriplet(int maxDepth, int sumOfElements, int sumOfProducts) {
        this.maxDepth = maxDepth;
        this.sumOfElements = sumOfElements;
        this.sumOfProducts = sumOfProducts;
    }
}

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        WeightedSumTriplet weightedSumTriplet = getWeightedSumTriplet(nestedList, 1);
        int maxDepth = weightedSumTriplet.maxDepth;
        int sumOfElements = weightedSumTriplet.sumOfElements;
        int sumOfProducts = weightedSumTriplet.sumOfProducts;
        
        return (maxDepth + 1) * sumOfElements - sumOfProducts;
    }

    private WeightedSumTriplet getWeightedSumTriplet(List<NestedInteger> list, int depth) {
        int sumOfProducts = 0;
        int sumOfElements = 0;
        int maxDepth = 0;
        
        for (NestedInteger nested : list) {
            if (nested.isInteger()) {
                sumOfProducts += nested.getInteger() * depth;
                sumOfElements += nested.getInteger();
                maxDepth = Math.max(maxDepth, depth);
            } else {
                WeightedSumTriplet result = getWeightedSumTriplet(nested.getList(), depth + 1);
                sumOfProducts += result.sumOfProducts;
                sumOfElements += result.sumOfElements;
                maxDepth = Math.max(maxDepth, result.maxDepth);
            }
        }
        
        return new WeightedSumTriplet(maxDepth, sumOfElements, sumOfProducts);
    }
}




// Approach 3: Single Pass Breadth-First Search (BFS)
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Queue<NestedInteger> Q = new LinkedList<>();
        Q.addAll(nestedList);

        int depth = 1;
        int maxDepth = 0;
        int sumOfElements = 0;
        int sumOfProducts = 0;

        while (!Q.isEmpty()) {
            int size = Q.size();
            maxDepth = Math.max(maxDepth, depth);
            
            for (int i = 0; i < size; i++) {
                NestedInteger nested = Q.poll();
                
                if (nested.isInteger()) {
                    sumOfElements += nested.getInteger();
                    sumOfProducts += nested.getInteger() * depth;
                } else {
                    Q.addAll(nested.getList());
                }
            }
            depth++;
        }
        return (maxDepth + 1) * sumOfElements - sumOfProducts;
    }
}