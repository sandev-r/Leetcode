class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isComposite = new boolean[n];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (!isComposite[i]) {
                count++;

                // Mark all multiples of i as composite
                for (int j = i * 2; j < n; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        return count;
    }
}