package lifecoding;

public class RavonvesieArray {
    public int equilibriumIndex(int[] arr) {
        int total = 0;

        for (int x : arr) {
            total += x;
        }

        int leftSum = 0;

        for (int i = 0; i < arr.length; i++) {
            int rightSum = total - leftSum - arr[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }
}