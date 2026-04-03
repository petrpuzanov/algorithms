package newAlgorithms.twoPointers;

public class N443StringCompression {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0; // куда пишем
        int i = 0;     // читаем

        while (i < n) {
            char current = chars[i];
            int count = 0;

            // считаем одинаковые символы
            while (i < n && chars[i] == current) {
                i++;
                count++;
            }

            // записываем символ
            chars[write++] = current;

            // если больше 1 — записываем число
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}
