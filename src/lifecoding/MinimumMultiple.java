package lifecoding;

public class MinimumMultiple {
    public static int minProduct(int[] arr) {
        if (arr.length < 2) {
            throw new IllegalArgumentException("Need at least 2 elements");
        }

        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;

        for (int x : arr) {
            // обновляем минимумы
            if (x <= min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }

            // обновляем максимумы
            if (x >= max1) {
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max2 = x;
            }
        }

        long prod1 = (long) min1 * min2;
        long prod2 = (long) max1 * max2;

        return (int) Math.min(prod1, prod2);
    }
}
