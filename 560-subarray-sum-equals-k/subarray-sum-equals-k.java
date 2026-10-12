class Solution {
    public int subarraySum(int[] nums, int k) {
   Map<Integer, Integer> prefixCount = new HashMap<>();
    prefixCount.put(0, 1); 

    int runningSum = 0, count = 0;
    for (int num : nums) {
        runningSum += num;
        
        count += prefixCount.getOrDefault(runningSum - k, 0);
        prefixCount.merge(runningSum, 1, Integer::sum);
    }
    return count;
}
}