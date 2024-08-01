import org.junit.jupiter.api.Test;

public class MaxWaterContainerTest {
    @Test
    public void testMaxWaterContainer() {
        int[] nums = {1,7,2,5,4,7,3,6};

        System.out.println(maxAreaBruteForce(nums));
        System.out.println(maxAreaOptimized(nums));
    }

    private int maxAreaBruteForce(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int width = j - i;
                int height = Math.max(nums[i], nums[j]);

                System.out.println("Width: " + width + " Height: " + height);

                int area = height * width;

                max = Math.max(max, area);

                System.out.println("Area: " + area);
            }
        }

        return max;
    }

    private int maxAreaOptimized(int[] nums) {
        int max = 0;

        for (int i = 0, j = nums.length - 1; i < j;) {
            int width = j - i;
            int height = Math.min(nums[i], nums[j]);
            int area = width * height;

            max = Math.max(max, area);

            if (nums[i] < nums[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
}
