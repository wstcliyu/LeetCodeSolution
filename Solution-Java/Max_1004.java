class Max_1004 {
    public int longestOnes(int[] A, int K) {
        int l = 0;
        for (int a : A) {
            if (a == 0) K--;
            if (K < 0 && A[l++] == 0) K++;
        }
        return A.length - l;
    }
}