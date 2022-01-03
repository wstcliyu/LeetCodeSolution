// Approach 1: Two-Pointers
public class ZigzagIterator {
    private List<List<Integer>> vectors = new ArrayList<>();
    // pointer to vector, and pointer to element
    private Integer pVec = 0, pElem = 0;
    private Integer totalNum = 0, outputCount = 0;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.vectors.add(v1);
        this.vectors.add(v2);
        for (List<Integer> vec : this.vectors) {
            this.totalNum += vec.size();
        }
    }

    public int next() {
        Integer iterNum = 0, ret = null;
        while (iterNum < this.vectors.size()) {
            List<Integer> currVec = this.vectors.get(this.pVec);
            if (this.pElem < currVec.size()) {
                ret = currVec.get(this.pElem);
                this.outputCount += 1;
            }

            iterNum += 1;
            this.pVec = (this.pVec + 1) % this.vectors.size();
            // increment the element pointer once iterating all vectors
            if (this.pVec == 0)
                this.pElem += 1;

            if (ret != null)
                return ret;
        }
        // one should raise an exception here.
        return 0;
    }

    public boolean hasNext() {
        return this.outputCount < this.totalNum;
    }
}




// Approach 2: Queue of Pointers
public class ZigzagIterator {
    private List<List<Integer>> vectors = new ArrayList<>();
    private LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.vectors.add(v1);
        this.vectors.add(v2);
        int index = 0;
        for (List<Integer> vec : this.vectors) {
            if (vec.size() > 0)
                // <index_to_vec, index_to_element_within_vec>
                this.queue.add(new Pair<Integer, Integer>(index, 0));
            index++;
        }
    }

    public int next() {
        // if (this.queue.size() == 0)
        // throw new Exception("Out of elements!");

        // <index_to_vec, index_to_element_within_vec>
        Pair<Integer, Integer> pointer = this.queue.removeFirst();
        Integer vecIndex = pointer.getKey();
        Integer elemIndex = pointer.getValue();
        Integer nextElemIndex = elemIndex + 1;
        // append the pointer for the next round
        // if there are some elements left.
        if (nextElemIndex < this.vectors.get(vecIndex).size())
            this.queue.addLast(new Pair<>(vecIndex, nextElemIndex));

        return this.vectors.get(vecIndex).get(elemIndex);
    }

    public boolean hasNext() {
        return this.queue.size() > 0;
    }
}




// My solution
public class ZigzagIterator {
    
    private ArrayDeque<Iterator<Integer>> q = new ArrayDeque<>();

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        Iterator<Integer> it = v1.iterator();
        if (it.hasNext()) q.add(it);
        it = v2.iterator();
        if (it.hasNext()) q.add(it);
    }

    public int next() {
        Iterator<Integer> it = q.removeFirst();
        int res = it.next();
        if (it.hasNext()) q.add(it);
        return res;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}