class StringIterator {
    
    int idx, count;
    char c;
    String s;

    public StringIterator(String compressedString) {
        idx = 0;
        count = 0;
        s = compressedString;
    }
    
    public char next() {
        if (hasNext()) {
            count--;
            return c;
        }
        return ' ';
    }
    
    public boolean hasNext() {
        if (count == 0 && idx < s.length()) {
            c = s.charAt(idx);
            while (++idx < s.length() && Character.isDigit(s.charAt(idx))) {
                count = count * 10 + (s.charAt(idx) - '0');
            }
        }
        return count > 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */