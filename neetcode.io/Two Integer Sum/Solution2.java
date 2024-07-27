// Key insight is to use a hashmap to store the difference between the target 
// and the current element.
// If we x and y then target - x = y, hence we can use the hashmap to retrieve
// the right index.
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
