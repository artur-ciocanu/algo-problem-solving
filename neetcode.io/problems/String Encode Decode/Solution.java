// The key insight for this problem is that we can encode the list of strings 
// by concatenating the length of each string with the string itself.

// I didn't solve this problem, because I got stuck, I have figured out that I need
// to add the length and use some kind of delimiter. My mistake was that I added the length
// at the end of the string, but I should have added it at the beginning. Having lenght
// at the beginning makes sure that even if we strings that contain the delimiter, we can
// still decode the string correctly. 
class Solution {

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
