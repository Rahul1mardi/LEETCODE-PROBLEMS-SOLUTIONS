class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<List<Integer>> buckets = new ArrayList<>();
        
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int key : map.keySet()) {
            int freq = map.get(key);
            buckets.get(freq).add(key);
        }

        int[] res = new int[k];
        int idx = 0;

        for (int i = buckets.size() - 1; i >= 0; i--) {
            for (int num : buckets.get(i)) {
                res[idx] = num;
                idx++;
                if (idx == k) {
                    return res;
                }
            }
        }

        return res;
    }
}
