package newAlgorithms.slidingWindow;

import java.util.Arrays;

public class N594LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int maxWindow = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 1) {
                left++;
            }
            if (nums[right] - nums[left] == 1) {
                maxWindow = Math.max(maxWindow, right - left + 1);
            }
        }
        return maxWindow;
    }
}
