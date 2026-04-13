package newAlgorithms.twoPointers;

public class N443StringCompression {
    public int compress(char[] chars) {
        int right = chars.length;
        int write = 0;
        int left = 0;

        while (left < right) {
            char current = chars[left];
            int count = 0;

            while (left < right && chars[left] == current) {
                left++;
                count++;
            }

            chars[write++] = current;

            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}
