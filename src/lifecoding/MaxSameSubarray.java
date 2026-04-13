package lifecoding;

public class MaxSameSubarray {
    public int maxRepeatingCharSubstring(String s) {
        int max = 0;
        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }

        return s.length() == 0 ? 0 : Math.max(max, count);
    }
}
