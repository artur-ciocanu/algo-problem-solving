// This is a very, very naive solution to the problem "Product Except Self".
// Time complexity: O(n^2) where "n" is the number of elements in the input array.
// It is not elegant and not efficient. But it is a good starting point to understand the problem.
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;

            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }

            result[i] = product;
        }

        return result;
    }
}  
