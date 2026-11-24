class Solution {
    public int maxLength(int[] nums) {
         int n = nums.length;
        int maxLen = 0;
        
        int maxVal = 0;
        int totalLcm = 1;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);      /// practice this 
            totalLcm = lcm(totalLcm, num);
        }
        int limit = totalLcm * maxVal;

        for (int i = 0; i < n; i++) {
            int prod = 1;
            int g = 0;
            int l = 1;

            for (int j = i; j < n; j++) {
                prod *= nums[j];
                
                if (prod > limit) {
                    break;
                }

                g = gcd(g, nums[j]);
                l = lcm(l, nums[j]);

                if (prod == g * l) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}