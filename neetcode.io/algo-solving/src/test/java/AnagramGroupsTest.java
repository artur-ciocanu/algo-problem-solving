import org.junit.jupiter.api.Test;

import java.util.*;

public class AnagramGroupsTest {
    @Test
    public void testAnagramGroups() {
        String[] strs = {"act","pots","tops","cat","stop","hat"};
        List<List<String>> result = groupAnagrams(strs);

        System.out.println(result);
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = getKey(str);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
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
