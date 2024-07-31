// Here is my thought process for solving this problem:
// 1. Sort the input array in ascending order using a heap aka PriorityQueue.
// 2. Iterate through the sorted array and count consecutive numbers.
// 3. Add the count to a max heap.
// 4. Return the top element of the max heap. Top element is the longest consecutive sequence.

// Time complexity: O(n * log n), the "log n" comes from the heap operations.
class Solution1 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> sorted = new PriorityQueue<>();
        PriorityQueue<Integer> longest = new PriorityQueue<>(Collections.reverseOrder());

        for (int num: nums) {
            sorted.add(num);
        }

        int previous = sorted.poll();
        int count = 1;

        while (!sorted.isEmpty()) {
            int current = sorted.poll();

            if (current == previous) {
                continue;
            }

            if (current - previous == 1) {
                count++;
            } else {
                longest.add(count);
                count = 1;
            }

            previous = current;
        }

        longest.add(count);
        
        return longest.peek();
    }
}
