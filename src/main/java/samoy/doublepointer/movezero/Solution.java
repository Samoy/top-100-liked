package samoy.doublepointer.movezero;

class Solution {
    public void moveZeroes(int[] nums) {
        // 遍历指针
        int i = 0;

        // 写入指针，初始位置为0，用于将非零元素写入
        int writeIndex = 0;

        // 遍历数组
        while (i < nums.length) {
            // 如果当前元素不为0，将其写入writeIndex对应的位置
            if (nums[i] != 0) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
            // 无论当前元素是否为0，都移动遍历指针
            i++;
        }

        // 填充剩余位置为0
        while (writeIndex < nums.length) {
            nums[writeIndex] = 0;
            writeIndex++;
        }
    }
}
