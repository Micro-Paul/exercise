package chapter1;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Paul
 */
public class Solution extends VersionControl {

    public static void main(String[] args) {
        Solution test = new Solution();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        System.out.println(test.search(nums, 9));

        int[] numss = {1, 3, 5, 6};
        System.out.println(test.searchInsert(numss, 5));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                return left;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = right - 1;
            }
        }
        return left;
    }

    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     * <p>
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     *
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }

    public int[] sortedSquares2(int[] nums) {
        int n = nums.length;
        int neg = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                neg = i;
            } else {
                break;
            }
        }
        int[] result = new int[n];
        int index = 0, i = neg, j = neg + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                // 全正数情况
                result[index] = nums[j] * nums[j];
                ++j;
            } else if (j == n) {
                // 全负数情况
                result[index] = nums[i] * nums[i];
                --i;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                result[index] = nums[i] * nums[i];
                --i;
            } else {
                result[index] = nums[j] * nums[j];
                ++j;
            }
            ++index;
        }
        return result;
    }

    /**
     * [-4,-1,0,3,10]
     * [-7,-3,2,3,11]
     * @param nums
     * @return
     */
    public int[] sortedSquares3(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                result[pos] = nums[i] * nums[i];
                ++i;
            } else {
                result[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return result;
    }
}
