import org.junit.jupiter.api.Test;

import java.util.*;

public class StringEncodeAndDecodeTest {
    @Test
    public void testEncodeDecode() {
        List<String> strs = new ArrayList<>();

        strs.add("");
        strs.add("   ");
        strs.add("!@#$%^&*()_+");
        strs.add("LongStringWithNoSpaces");
        strs.add("Another, String With, Commas");

        String encoded = encode(strs);
        List<String> decoded = decode(encoded);

        System.out.println(strs);
        System.out.println(encoded);
        System.out.println(decoded);
    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str: strs) {
            sb.append(str.length()).append('#').append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.valueOf(str.substring(i, j));
            i = j + 1 + length;

            list.add(str.substring(j + 1, i));
        }

        return list;
    }


}
