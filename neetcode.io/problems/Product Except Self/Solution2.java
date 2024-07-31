// This is another solution to the problem "Product Except Self".
// I couldn't solve this problem, because I got stuck.
// It seems that there is a standard algorithm named "Prefix Sums". Here we are
// calculating the prefix product and the suffix product and then multiplying them.
// This is a very elegant solution and I will try to remember it for the future.
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        int right = 1, left = 1;
        
        for (int i = 0; i < nums.length; i++) {
            arr[i] = left;
            left *= nums[i];
        }
        
        for (int i = nums.length - 1; i >= 0; i--) {
            arr[i] *= right;
            right *= nums[i];
        }
        
        return arr;
    }
}  
