// My solution
class PeekingIterator implements Iterator<Integer> {
    
    private Integer peek;
    private Iterator<Integer> it;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    if (iterator.hasNext()) {
            peek = iterator.next();
        }
        it = iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = peek;
        peek = null;
        if (it.hasNext()) {
            peek = it.next();
        }
        return res;
	}
	
	@Override
	public boolean hasNext() {
	    return peek != null;
	}
}