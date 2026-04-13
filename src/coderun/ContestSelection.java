package coderun;

import java.util.*;
//4
public class ContestSelection {

    public static List<Integer> selectTasks(int n, int k, int[] a) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> used = new HashSet<>();

        // 1. Берем уникальные темы
        for (int i = 0; i < n && result.size() < k; i++) {
            if (!used.contains(a[i])) {
                used.add(a[i]);
                result.add(a[i]);
            }
        }

        // 2. Добираем любые
        for (int i = 0; i < n && result.size() < k; i++) {
            result.add(a[i]);
        }

        return result;
    }
}