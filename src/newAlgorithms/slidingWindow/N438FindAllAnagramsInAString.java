package newAlgorithms.slidingWindow;

import java.util.ArrayList;
import java.util.List;
//todo
public class N438FindAllAnagramsInAString {
    // abc abc
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        int[] count = new int[26];
        int left = 0;
        int right = 0;
        int needed = p.length();
        for (int i = 0; i < p.length(); i++) {
            count[p.charAt(i) - 'a']++;
        }
        while (right < s.length()) {
            char r = s.charAt(right);
            if (count[r - 'a'] > 0) {
                needed--;
            }
            count[r - 'a']--;
            right++;

            if (needed == 0) {
                result.add(left);
            }

            if (right - left == p.length()) {
                char l = s.charAt(left);

                if (count[l - 'a'] >= 0) {
                    needed++;
                }
                count[l - 'a']++;
                left++;
            }
        }
        return result;
    }
}
