package newAlgorithms.binarySearch;

public class N35SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target > nums[mid]) {
                left = mid;
            } else if (target < nums[mid]) {
                right = mid;
            } else {
                return mid;
            }
        }
        return left;
    }
}
