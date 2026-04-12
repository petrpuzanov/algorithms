package newAlgorithms.bitOperations;

public class N136SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
//todo
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
