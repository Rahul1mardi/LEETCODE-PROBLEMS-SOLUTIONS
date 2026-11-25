class Solution {
    static final long M1 = 1_000_000_007L, M2 = 998_244_353L;
    long[] h1, h2, p1, p2;
    int n;
    public int smallestUniqueSubarray(int[] nums) {
      n = nums.length;
        long base = 100_003L + new Random().nextInt(1_000_000);
        h1 = new long[n + 1]; h2 = new long[n + 1];
        p1 = new long[n + 1]; p2 = new long[n + 1];
        p1[0] = 1; p2[0] = 1;

        for (int i = 0; i < n; i++) {
            h1[i + 1] = (h1[i] * base + nums[i]) % M1;
            h2[i + 1] = (h2[i] * base + nums[i]) % M2;
            p1[i + 1] = (p1[i] * base) % M1;
            p2[i + 1] = (p2[i] * base) % M2;
        }

        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (hasUnique(mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean hasUnique(int len) {
        Set<Long> seen = new HashSet<>(), duplicates = new HashSet<>();
        for (int i = 0; i <= n - len; i++) {
            long hash1 = (h1[i + len] - (h1[i] * p1[len]) % M1 + M1) % M1;
            long hash2 = (h2[i + len] - (h2[i] * p2[len]) % M2 + M2) % M2;
            long combined = (hash1 << 32) | hash2;
            if (!seen.add(combined)) duplicates.add(combined);
        }
        return seen.size() > duplicates.size();  
    }
}