class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        boolean result = false;

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                result = true;
                break;
            }

            set.add(nums[i]);
        }

        return result;
    }
}
