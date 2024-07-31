// Similar to Solution1, we want to use a two pointer technique to solve this problem.
// The key insight is that we can use the fact that the input array is sorted to our advantage.
// If the sum of the two numbers is too big, we need to move the right pointer to the left.
// If the sum of the two numbers is too small, we need to move the left pointer to the right.

// With this insight the solution is very simple and elegant. We just need to 
// keep moving the pointers aka indexes until we find the two numbers that sum to the target.
class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            // It is a sorted array, so if sum is too big, we need to move a pointer to the left
            if (sum > target) {
                right--;
            // It is a sorted array, so if sum is too small, we need to move a pointer to the right    
            } else if (sum < target) {
                left++;
            } else {
                return new int[] {left + 1, right + 1};
            }
        }
        
        return new int[0];
    }
}
