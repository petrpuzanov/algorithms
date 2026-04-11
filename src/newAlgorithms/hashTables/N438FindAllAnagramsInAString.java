package newAlgorithms.hashTables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N438FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        if (s.length() < p.length()) return res;

        int[] pCount = new int[26];
        int[] window = new int[26];

        // считаем частоты p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            window[s.charAt(i) - 'a']++;

            // уменьшаем окно
            if (i >= p.length()) {
                window[s.charAt(i - p.length()) - 'a']--;
            }

            // проверяем
            if (Arrays.equals(pCount, window)) {
                res.add(i - p.length() + 1);
            }
        }

        return res;
    }
}
