class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
       int n = items.length;
        int[] frees = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    frees[i]++;
                }
            }
        }

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int cost = items[i][1];
            int bonus = frees[i];

            for (int b = budget; b >= cost; b--) {
                dp[b] = Math.max(dp[b], dp[b - cost] + 1 + bonus);
            }

            for (int b = cost; b <= budget; b++) {
                dp[b] = Math.max(dp[b], dp[b - cost] + 1);
            }
        }

        return dp[budget]; 
    }
}