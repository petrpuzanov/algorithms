package newAlgorithms.hashTables;

public class N567PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == window[i]) matches++;
        }

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            if (matches == 26) return true;

            int index = s2.charAt(right) - 'a';
            window[index]++;
            if (window[index] == s1Count[index]) matches++;
            else if (window[index] == s1Count[index] + 1) matches--;

            index = s2.charAt(left) - 'a';
            window[index]--;
            if (window[index] == s1Count[index]) matches++;
            else if (window[index] == s1Count[index] - 1) matches--;

            left++;
        }

        return matches == 26;
    }
}
