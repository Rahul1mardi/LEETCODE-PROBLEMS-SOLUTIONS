class Solution {
    public int majorityElement(int[] nums) {
int count = 0, m = 0;
        for (int x : nums) {
            if (count == 0) {
                m = x;
                count = 1;
            } else {
                count += m == x ? 1 : -1;
            }
        }
        return m;
    }
}