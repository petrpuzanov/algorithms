package lifecoding;

public class TwoMaxElements {
    public int[] top2(int[] nums) {
        if (nums == null || nums.length < 2) {
            throw new IllegalArgumentException("Need at least 2 elements");
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x > max1) {
                max2 = max1;
                max1 = x;
            } else if (x > max2 && x != max1) {
                max2 = x;
            }
        }

        return new int[]{max1, max2};
    }
}
