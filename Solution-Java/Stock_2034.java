// https://leetcode.com/problems/stock-price-fluctuation/discuss/1513413/JavaC%2B%2BPython-Strightforward-Solutions
// Solution from lee215 (same idea as mine)
class StockPrice {
    TreeMap<Integer, Integer> record = new TreeMap<>();
    TreeMap<Integer, Set<Integer>> vals = new TreeMap<>();

    public void update(int timestamp, int price) {
        if (record.containsKey(timestamp)) {
            int prevPrice = record.get(timestamp);
            Set<Integer> book = vals.get(prevPrice);
            book.remove(timestamp);
            if (book.isEmpty()) {
                vals.remove(prevPrice);
            }
        }
        vals.computeIfAbsent(price, k -> new HashSet<>()).add(timestamp);
        record.put(timestamp, price);
    }

    public int current() {
        return record.lastEntry().getValue();
    }

    public int maximum() {
        return vals.lastKey();
    }

    public int minimum() {
        return vals.firstKey();
    }
}