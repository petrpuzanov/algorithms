package newAlgorithms.hashTables;

public class N136SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
