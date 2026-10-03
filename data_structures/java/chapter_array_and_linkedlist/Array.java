package chapter_array_and_linkedlist;

import java.util.Arrays;

public class Array {
    /** 随机访问元素 */
    public static int randomAccess(int[] nums) {
        // 在区间 [0, nums.length) 中随机选择一个数字
        int randomIndex = (int) (Math.random() * nums.length);
        // 访问随机索引的元素
        return nums[randomIndex];
    }

    /** 拓展数组长度 */
    public static int[] extend(int[] nums, int newCapacity) {
        // 初始化新数组
        int[] newNums = new int[newCapacity];
        // 将原数组中的元素复制到新数组
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = nums[i];
        }
        // 返回新数组
        return newNums;
    }

    /** 在数组的索引index处插入元素num，index从0开始 */
    public static void insert(int[] nums, int num, int index) {
        for (int i = nums.length - 1; i > index; i--){
            nums[i] = nums[i - 1];
        }
        nums[index] = num;
    }

    /** 删除索引index处的元素 */
    public static void remove(int[] nums, int index) {
        for (int i = index + 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
    }

    /** 遍历数组 */
    public static void traverse(int[] nums) {
        System.out.println("开始遍历数组");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /* 在数组中查找指定元素 */
    public static int find(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        /* 初始化数组 */
        int[] arr = new int[5];
        System.out.println("数组 arr = " + Arrays.toString(arr));
        int[] nums = {1,2,3,4,5};
        System.out.println("数组 nums = " + Arrays.toString(nums));

        System.out.println("随机访问元素 " + Array.randomAccess(nums));

        System.out.println("拓展数组长度 " + Arrays.toString(Array.extend(nums, 10)));

        Array.insert(nums, 0, 1);
        System.out.println("在索引1处插入数字0 " + Arrays.toString(nums));
        Array.insert(nums, 1, 1);
        System.out.println("在索引1处插入数字1 " + Arrays.toString(nums));

        /* 删除元素 */
        remove(nums, 2);
        System.out.println("删除索引 2 处的元素，得到 nums = " + Arrays.toString(nums));

        /* 遍历数组 */
        traverse(nums);

        /* 查找元素 */
        int index = find(nums, 3);
        System.out.println("在 nums 中查找元素 3 ，得到索引 = " + index);
    }
}