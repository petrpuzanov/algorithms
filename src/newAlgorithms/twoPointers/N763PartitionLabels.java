package newAlgorithms.twoPointers;

import java.util.ArrayList;
import java.util.List;
//todo
public class N763PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];

        // шаг 1: last occurrence
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;

        // шаг 2: greedy
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);

            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
