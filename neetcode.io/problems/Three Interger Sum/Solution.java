// There are a few key insights in this solution:
// 1. We need to sort the array to use the two pointer technique.
// 2. If the first element is greater than 0, we can break out of the loop, since
// there is no way we can find a sum of 0.
// 3. We need to skip duplicate numbers to avoid duplicate triplets.
// 4. We need to use the two pointer technique to find the sum of three numbers.

// Time complexity: O(n^2) where "n" is the number of elements in the input array.
// One thing to note for this solution is that we need to skip duplicate numbers 
// to avoid duplicate triplets in the result. This is why we have the while loops
// to skip duplicate numbers.

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
        int[] numbers = new int[nums.length];

        System.arraycopy(nums, 0, numbers, 0, nums.length);

        Arrays.sort(numbers);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > 0) {
                break;
            }

            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = numbers.length - 1;

            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    result.add(Arrays.asList(numbers[i], numbers[left], numbers[right]));

                    left++;
                    right--;

                    while (left < right && numbers[left] == numbers[left - 1]) {
                        left++;
                    }
                }
            }
        }

        return result;
    }
}
