// Here is my thought process for solving this problem:
// 1. Use a map to store the anagram groups.
// 2. Map key is the sorted string. This ensure that thing like "eat" and "tea" will have the same key.
// 3. Iterate through the input strings.
// 4. During iteration compute the key for the current string aka the sorted string.
// 5. If the key is already in the map, add the current string to the list of strings for that key.
// 6. If the key is not in the map, create a new list and add the current string to it.

// Time complexity: O(n * m * log m) where "n" is the number of strings and "m" is the length of the longest string.
// We log m because we are sorting the string that will be the key.
class Solution1 {
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
        char[] chars = str.toCharArray();

        Arrays.sort(chars);

        return new String(chars);
    }
}
