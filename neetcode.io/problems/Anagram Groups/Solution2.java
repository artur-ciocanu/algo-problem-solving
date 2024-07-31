// The second solution to the problem of grouping anagrams.
// The key insight is that we can compute the key for the anagram group by 
// counting the frequency of each character. So the core algo is the same as the first solution,
// but the way we compute the key is different and more efficient.

// Time complexity: O(n * m) where "n" is the number of strings and "m" is the length of the longest string.
// As we can see because we don't have to sort the string to compute the key, the time complexity is better.
class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = getKey(str);

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();

                list.add(str);

                map.put(key, list);
            }
        }

        return new ArrayList<>(map.values());
    }

    private static String getKey(String str) {
        int[] count = new int[26];
        
        for (char c : str.toCharArray()) {
            count[c - 'a']++;
        }

        return Arrays.toString(count);
    }
}
