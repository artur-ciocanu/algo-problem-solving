import org.junit.jupiter.api.Test;

public class TwoIntergerSumTest {
    @Test
    public void testSumTwoInteger() {
        int[] numbers = {-5,-3,0,2,4,6,8};
        int target = 5;
        int[] result = twoSum(numbers, target);

        System.out.println(result[0] + " " + result[1]);
    }

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
