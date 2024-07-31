// This is very, very elegant. I will try to remember this solution for the future.
// There are two key insights here:
// 1. We need to figure out how many sequence of numbers we have. To determine that
// we can use a set to store the numbers and then iterate through the numbers. Then
// we can check if the number - 1 is in the set. If it is not, then we know
// we found the number that starts the sequence. Once we know the starting number
// we can "blindly" increment and check if the number is in the set. If it is, we increment
// the length of the sequence. If it is not, we know we reached the end of the sequence.
// Another key idea is to Math.max() to always have the max length of the sequence.
class Solution2 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int n : numSet) {
            if (!numSet.contains(n - 1)) {
                int length = 1;
                
                while (numSet.contains(n + length)) {
                    length++;
                }
                
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
}
