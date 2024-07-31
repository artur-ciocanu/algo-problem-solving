import org.junit.jupiter.api.Test;

import java.util.*;

public class LongestConsecutiveSequenceTest {
    @Test
    public void testLongestConsecutiveSequence() {
        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            set.add(num);
        }

        for (int num: nums) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                map.put(num, count);
            }
        }
    }

    public int longestConsecutive(int[] nums) {
        TreeSet<Integer> sorted = new TreeSet<>();

        for (int num: nums) {
            sorted.add(num);
        }

        PriorityQueue<Integer> longest = new PriorityQueue<>(Collections.reverseOrder());
        Iterator<Integer> iterator = sorted.iterator();
        int previous = iterator.next();
        int count = 1;

        while (iterator.hasNext()) {
            int current = iterator.next();

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

        if (longest.isEmpty()) {
            longest.add(count);
        }

        return longest.peek();
    }
}
