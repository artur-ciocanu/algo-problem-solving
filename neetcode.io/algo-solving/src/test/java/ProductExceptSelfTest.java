import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ProductExceptSelfTest {
    @Test
    public void testProductExceptSelf() {
        int[] nums = {1,2,3,4};
        int[] prefixes = computePrefixes(nums);
        int[] postfixes = computePostfixes(nums);
        //int[] result = productExceptSelf(nums);

        System.out.println(Arrays.toString(prefixes));
        System.out.println(Arrays.toString(postfixes));
    }

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

    public int[] computePrefixes(int[] nums) {
        int[] result = new int[nums.length];

        System.arraycopy(nums, 0, result, 0, nums.length);

        for (int i = 1; i < result.length; i++) {
            result[i] = result[i] * result[i - 1];
        }

        return result;
    }

    public int[] computePostfixes(int[] nums) {
        int[] result = new int[nums.length];

        // Set the last element of the postfix product array
        result[nums.length - 1] = nums[nums.length - 1];

        // Traverse the array from the second-to-last element to the first
        for (int i = nums.length - 2; i >= 0; i--) {
            // Compute the postfix product by multiplying the current element with the postfix product of the next element
            result[i] = nums[i] * result[i + 1];
        }

        return result;
    }
}
