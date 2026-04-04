package newAlgorithms.twoPointers;

public class N283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int write = 0;

        // переносим все НЕ нули вперед
        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != 0) {
                nums[write] = nums[read];
                write++;
            }
        }

        // заполняем нулями
        while (write < nums.length) {
            nums[write] = 0;
            write++;
        }
    }
}
