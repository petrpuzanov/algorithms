package newAlgorithms.binarySearch;

public class N278FirstBadVersion {
    public class Solution {

        public int firstBadVersion(int n) {
            int left = 1;
            int right = n;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (true
//                        isBadVersion(mid)
                ) {
                    right = mid; // mid может быть первой плохой
                } else {
                    left = mid + 1; // точно справа
                }
            }

            return left; // или right — они равны
        }
    }
}
