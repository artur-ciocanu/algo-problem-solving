// The solution is based on the idea that if two strings are anagrams, 
// they must have the same length and the same frequency of each character.
class Solution2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
          return false;
        }

        // The constrains of the problem state that the strings will only 
        // contain lowercase letters, we have 26 letters in the alphabet, hence
        // array size is 26. Each slot in the array will store the frequency of
        // the corresponding letter in the alphabet.
        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        for (int n : store) {
          if (n != 0) {
            return false;
          }
        }

        return true;
    }
}
