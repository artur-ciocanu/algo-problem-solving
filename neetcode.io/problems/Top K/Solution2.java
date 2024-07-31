// This is a solution for the problem "Top K Frequent Elements"
// We use a variation of the bucket sort algorithm to solve this problem.
// The idea is to count the frequency of each number and then store the numbers in a bucket
// where the index of the bucket is the frequency of the number.
// Then we iterate through the buckets from right to left and add the numbers to the result array.
// Time complexity: O(n) where "n" is the number of elements in the input array.
// This is because we iterate through the input array and then through the buckets.
class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
