import org.junit.jupiter.api.Test;

import java.util.*;


public class ThreeIntegerSumTest {
    @Test
    public void testThreeIntegerSum() {
        int[] numbers = {-2,0,0,2,2};
        List<List<Integer>> resul = threeSum(numbers);

        System.out.println(resul);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int[] numbers = new int[nums.length];

        System.arraycopy(nums, 0, numbers, 0, nums.length);

        Arrays.sort(numbers);

        System.out.println(Arrays.toString(numbers));

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
