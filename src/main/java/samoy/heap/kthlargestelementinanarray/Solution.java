package samoy.heap.kthlargestelementinanarray;

/**
 * @link <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-100-liked">数组中的第K个最大元素</a>
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 数组长度
        int n = nums.length;

        // 调用quickselect方法，注意转换为找第n-k小的元素，即第k大元素
        return quickselect(nums, 0, n - 1, n - k);
    }

    // 快速选择方法，用于在nums[left...right]区间内找到第k小的元素
    int quickselect(int[] nums, int left, int right, int kSmallest) {
        // 基准情形：如果区间只剩一个元素，直接返回该元素（即第k小的元素）
        if (left == right) return nums[kSmallest];

        // 选择区间的第一个元素作为基准元素x
        int x = nums[left];

        // 初始化两个指针i和j，i从左侧开始向右扫描，j从右侧开始向左扫描
        int i = left - 1, j = right + 1;

        // 当i<j时，持续循环
        while (i < j) {
            // 找到第一个大于或等于x的元素
            do i++; while (nums[i] < x);

            // 找到第一个小于或等于x的元素
            do j--; while (nums[j] > x);

            // 如果i仍然小于j，交换nums[i]和nums[j]的位置，使得i左边的都小于x，j右边的都大于x
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        // 根据j的位置，决定是在j的左边还是右边继续递归查找第k小的元素
        if (kSmallest <= j) return quickselect(nums, left, j, kSmallest); // 在左侧[left, j]区间内继续查找
        else return quickselect(nums, j + 1, right, kSmallest); // 在右侧[j+1, right]区间内继续查找
    }
}
