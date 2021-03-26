class Substring_30 {
    public List<Integer> findSubstring(String s, String[] words) {
        int wl = words[0].length();
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, 1 + freq.getOrDefault(w, 0));
        }
        for (int i = 0; i < wl; i++) {
            int start = i;
            int count = words.length;
            Map<String, Integer> seen = new HashMap<>();
            for (int end = start + wl; end <= s.length(); end += wl) {
                String tail = s.substring(end - wl, end);
                if (freq.containsKey(tail)) {
                    seen.put(tail, 1 + seen.getOrDefault(tail, 0));
                    if (seen.get(tail) <= freq.get(tail)) {
                        count--;
                    }
                    if (end - start == wl * words.length) {
                        if (count == 0) res.add(start);
                        String head = s.substring(start, start + wl);
                        seen.put(head, -1 + seen.get(head));
                        if (seen.get(head) < freq.get(head)) {
                            count++;
                        }
                        start += wl;
                    }
                } else {
                    start = end;
                    count = words.length;
                    seen.clear();
                }
            }
        }
        return res;
    }
}