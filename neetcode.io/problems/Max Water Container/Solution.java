// The solution to this problem is very similar to the solution to the problem 
// "Two Integer Sum" in problems/Two%20Integer%20Sum/Solution2.java.
// We use a two pointer technique to solve this problem.
// Here a few things that we need to solve the problem:
// - Area is computed as width * height.
// - Width is computed as the difference between the right and left pointers.
// Right is the index of the last element in the array, left is the index of the first element 
// in the array.
// - Height is computed as the minimum of the two numbers at the left and right pointers. We need to
// compute the minimum because the area is limited by the shorter of the two lines.
// - We need to move the left and right pointers based on the height of the two lines. If the left
// line is shorter, we need to move the left pointer to the right. If the right line is shorter, we
// need to move the right pointer to the left.
class Solution {
    public int maxArea(int[] nums) {
        int max = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int width = right - left;
            int height = Math.min(nums[left], nums[right]);
            int area = width * height;

            max = Math.max(max, area);

            if (nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
