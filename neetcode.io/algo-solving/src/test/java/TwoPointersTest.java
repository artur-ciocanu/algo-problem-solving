import org.junit.jupiter.api.Test;

public class TwoPointersTest {
    @Test
    public void testTwoPointers() {
        int[] nums = {1,2,3,7,5};
        int searchedSum = 12;

        sumSubArray1(nums, searchedSum);
        sumSubArray2(nums, searchedSum);
    }

    private void sumSubArray1(int[] nums, int searchedSum) {
        int iter = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            iter++;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                iter++;

                if (sum == searchedSum) {
                    System.out.println("1: Found sum at " + (i + 1) + " and " + (j + 1));
                    System.out.println("2: Iterations: " + iter);
                    return;
                }
            }
        }
    }

    private void sumSubArray2(int[] nums, int searchedSum) {
        int currentSum = 0;
        int j = 0;
        int iter = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            iter++;

            while (currentSum > searchedSum && j < i) {
                currentSum -= nums[j];
                j++;
                iter++;
            }

            if (currentSum == searchedSum) {
                System.out.println("2: Found sum at " + (j + 1) + " and " + (i + 1));
                System.out.println("2: Iterations: " + iter);
                return;
            }
        }
    }
}
