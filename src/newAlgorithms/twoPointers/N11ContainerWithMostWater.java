package newAlgorithms.twoPointers;

//https://leetcode.com/problems/container-with-most-water/description/
public class N11ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxResult = 0;

        while (left < right) {
            maxResult = Math.max(maxResult, (right - left) * Math.min(height[left], height[right]));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxResult;
    }
}
