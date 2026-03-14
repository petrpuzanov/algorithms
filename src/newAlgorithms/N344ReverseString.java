package newAlgorithms;

//https://leetcode.com/problems/reverse-string/description/
public class N344ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temporaryLetter = s[left];
            s[left] = s[right];
            s[right] = temporaryLetter;
            left++;
            right--;
        }
    }
}
