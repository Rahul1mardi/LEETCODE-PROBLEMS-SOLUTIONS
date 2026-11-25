class Solution {
    private static final long MOD1 = 1_000_000_007L;
    private static final long MOD2 = 998_244_353L;

    private long[] prefixHash1;
    private long[] prefixHash2;
    private long[] power1;
    private long[] power2;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        buildRollingHashes(nums);

        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (hasUniqueSubarrayOfLength(n, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private void buildRollingHashes(int[] nums) {
        int n = nums.length;
        long base = 100_003L + new Random().nextInt(1_000_000);

        prefixHash1 = new long[n + 1];
        prefixHash2 = new long[n + 1];
        power1 = new long[n + 1];
        power2 = new long[n + 1];

        power1[0] = 1;
        power2[0] = 1;

        for (int i = 0; i < n; i++) {
            prefixHash1[i + 1] = (prefixHash1[i] * base + nums[i]) % MOD1;
            prefixHash2[i + 1] = (prefixHash2[i] * base + nums[i]) % MOD2;
            power1[i + 1] = (power1[i] * base) % MOD1;
            power2[i + 1] = (power2[i] * base) % MOD2;
        }
    }

    private boolean hasUniqueSubarrayOfLength(int n, int len) {
        Set<Long> seen = new HashSet<>();
        Set<Long> duplicates = new HashSet<>();

        for (int i = 0; i <= n - len; i++) {
            long hash = getSubarrayHash(i, i + len);
            if (!seen.add(hash)) {
                duplicates.add(hash);
            }
        }

        return seen.size() > duplicates.size();
    }

    private long getSubarrayHash(int start, int end) {
        int len = end - start;
        long hash1 = (prefixHash1[end] - (prefixHash1[start] * power1[len]) % MOD1 + MOD1) % MOD1;
        long hash2 = (prefixHash2[end] - (prefixHash2[start] * power2[len]) % MOD2 + MOD2) % MOD2;
        return (hash1 << 32) | hash2;
    }
}
