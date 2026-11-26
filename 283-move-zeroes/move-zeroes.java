class Solution {
    public void moveZeroes(int[] nums) {
     int insertPost = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != insertPost) {
                    int temp = nums[insertPost];
                    nums[insertPost] = nums[i];
                    nums[i] = temp;
                }
                insertPost++;
            }
        }   
    }
}