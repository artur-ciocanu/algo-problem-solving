// This is a solution for the problem "Top K Frequent Elements"
// Here is my thought process for solving this problem:
// 1. Use a map to store the frequency of each number.
// 2. Use a max heap to store the entries of the map.
// 3. Iterate through the map and add the entries to the heap.
// 4. Poll the heap k times to get the top k frequent elements.

// Time complexity: O(n * log n) where "n" is the number of elements in the input array.
// The log n comes from the heap operations. Polling from the heap is log n.
// NOTE: In Java PriorityQueue is a min heap by default. To make it a max heap,
// we can pass a custom comparator to the constructor.
class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
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
