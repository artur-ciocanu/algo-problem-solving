import org.junit.jupiter.api.Test;

import java.util.*;

public class TopKTest {
    @Test
    public void testTopK() {
        int[] nums = {1,2,2,3,3,3};
        int k = 2;
        int[] result = topKFrequent(nums, k);

        System.out.println(Arrays.toString(result));
    }

    private int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        Comparator<Map.Entry<Integer, Integer>> comparator = (a, b) -> b.getValue() - a.getValue();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(comparator);

        heap.addAll(map.entrySet());

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            Map.Entry<Integer, Integer> entry = heap.poll();

            res[i] = entry.getKey();
        }

        return res;
    }
}
