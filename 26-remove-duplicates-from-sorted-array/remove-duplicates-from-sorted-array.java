class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int s = 0;
        for (int f = 1; f<nums.length ; f++){
            if (nums[f]!= nums[s]){
                s++;
                nums[s]=nums[f];
            }
        }
    return s + 1;
    }
}