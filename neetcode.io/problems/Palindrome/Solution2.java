// Here is my thought process for solving this problem:
// It is clear the we need to use a two pointer technique to solve this problem.
// The complication comes from the fact that we need to skip non-alphanumeric characters.
// We can use the "Character.isLetterOrDigit()" method to check if a character is alphanumeric.
// The key insight is that we need to advance the left and right pointers when we encounter
// a non-alphanumeric character. This is because we need to skip these characters.
// Hence we need to use the while loops to advance the left and right pointers.

// Time complexity: O(n) where "n" is the number of characters in the input string.
// But this solution is more efficient than the previous one because we do not use additional space
// and we use a single iteration to solve the problem.
class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while(left < right) {
            while(left < right && !isAlphaNumeric(chars[left])) {
                left++;
            }

            while(left < right && !isAlphaNumeric(chars[right])) {
                right--;
            }

            if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                return false;
            }
            
            left++;
            right--;
        }
        

        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        return Character.isLetterOrDigit(c);
    }
}
