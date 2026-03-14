package newAlgorithms;

//https://leetcode.com/problems/valid-palindrome/description/
public class N125ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;

        while (left >= right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            if (!Character.isLetterOrDigit(left)) {
                left++;
            } else if (!Character.isLetterOrDigit(right)) {
                right--;
            } else {
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }
                left++;
                right++;
            }
        }
        return true;
    }
}
