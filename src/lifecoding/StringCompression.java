package lifecoding;

public class StringCompression {
    public String compress(String s) {
        if (s == null || s.length() == 0) return "";

        StringBuilder sb = new StringBuilder();

        int count = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (i < s.length() && s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(s.charAt(i - 1));
                sb.append(count);
                count = 1;
            }
        }

        return sb.toString();
    }
}