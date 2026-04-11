package newAlgorithms.sorting;

public class N75SortColors {
    public void sortColors(int[] nums) {
        int left = 0;
        int curr = 0;
        int right = nums.length - 1;

        while (curr <= right) {
            if (nums[curr] == 0) {
                int temp = nums[left];
                nums[left] = nums[curr];
                nums[curr] = temp;
                left++;
                curr++;
            } else if (nums[curr] == 2) {
                int temp = nums[right];
                nums[right] = nums[curr];
                nums[curr] = temp;
                right--;
            } else {
                curr++;
            }
        }
    }
}
