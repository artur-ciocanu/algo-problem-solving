// Here we use a pretty naive approach
// We first check if the lengths of the two strings are equal
// Then we count the sum of the ASCII values of the characters in the two strings
// If the sums are equal, we convert the strings to sets of bytes and check if the sets are equal
// This is not a very efficient solution, but it works
class Solution1 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int scount = count(s);
        int tcount = count(t);

        if (scount != tcount) {
            return false;
        }

        Set<Byte> sset = toSet(s);
        Set<Byte> tset = toSet(t);
        
        return sset.equals(tset);
    }

    private Set<Byte> toSet(String s) {
        Set<Byte> result = new HashSet<>();
        byte[] bytes = s.getBytes();

        for (int i = 0; i < bytes.length; i++) {
            result.add(bytes[i]);
        }

        return result;
    }

    private int count(String s) {
        byte[] bytes = s.getBytes();
        int result = 0;

        for (int i = 0; i < bytes.length; i++) {
            result += bytes[i];
        }

        return result;
    }
}
