package coderun;

import java.util.*;
//8
public class RestoreString {

    public static int[] solve(String s, int m, String[] t) {
        int n = s.length();
        int len = n / m;

        Map<String, Deque<Integer>> map = new HashMap<>();

        // 1. сохраняем куски
        for (int i = 0; i < m; i++) {
            map.computeIfAbsent(t[i], k -> new ArrayDeque<>()).add(i + 1);
        }

        int[] result = new int[m];

        // 2. разбиваем s
        for (int i = 0; i < m; i++) {
            String block = s.substring(i * len, (i + 1) * len);

            Deque<Integer> list = map.get(block);

            int idx = list.pollFirst(); // берём любой
            result[i] = idx;
        }

        return result;
    }
}