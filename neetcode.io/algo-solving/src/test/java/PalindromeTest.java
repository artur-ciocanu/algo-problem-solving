import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PalindromeTest {
    @Test
    public void testPalindrome() {
        System.out.println(isPalindrome1("Was it a car or a cat I saw?"));
        System.out.println(isPalindrome1("tab a cat"));

        System.out.println(isPalindrome2("Was it a car or a cat I saw?"));
        System.out.println(isPalindrome2("tab a cat"));
    }

    public boolean isPalindrome1(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        List<Character> list = new ArrayList<>();
        int iter = 0;

        for (char c : chars) {
            iter++;

            if (isAlphaNumeric(c)) {
                list.add(c);
            }
        }

        int j = list.size() - 1;

        for (Character c : list) {
            iter++;

            if (c != list.get(j)) {
                System.out.println("1: Iterations: " + iter);
                return false;
            }
            j--;
        }

        System.out.println("1: Iterations: " + iter);

        return true;
    }

    public boolean isPalindrome2(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        int iter = 0;

        while (left < right) {
            iter++;

            while (left < right && !isAlphaNumeric(chars[left])) {
                left++;
            }

            while (left < right && !isAlphaNumeric(chars[right])) {
                right--;
            }

            if (Character.toLowerCase(chars[left]) != Character.toLowerCase(chars[right])) {
                System.out.println("2: Iterations: " + iter);
                return false;
            }

            left++;
            right--;
        }

        System.out.println("2: Iterations: " + iter);

        return true;
    }

    private static boolean isAlphaNumeric(char c) {
        return Character.isLetterOrDigit(c);
    }
}
