// This is a pretty naive approach
// The complexity of the solution is O(n^2)
// Even if we iterate from j to i, the complexity is still O(n^2)
class Solution1 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] {(j + 1), (i + 1)};
                }
            }
        }

        return new int[0];
    }
}
