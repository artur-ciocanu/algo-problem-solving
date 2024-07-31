// This is a very, very naive solution to the problem "Palindrome".
// Here is my thought process for solving this problem:
// 1. Convert the input string to a char array.
// 2. Iterate through the char array and add only alphanumeric characters to an array list.
// 3. Compare the first and last element of the array list.
// 4. If they are not equal, return false.

// Time complexity: O(n) where "n" is the number of characters in the input string.
// The solution uses two iterations and uses additional space to store the alphanumeric characters.
// There is a better solution that uses a similar two pointer technique but without the need 
// for additional space.
class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        List<Character> list = new ArrayList<>();

        for (char c : chars) {
            if (isAlphaNumeric(c)) {
                list.add(c);
            }
        }

        int j = list.size() - 1;

        for (Character c : list) {
            if (c != list.get(j)) {
                return false;
            }
            j--;
        }

        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        return Character.isLetterOrDigit(c);
    }
}
