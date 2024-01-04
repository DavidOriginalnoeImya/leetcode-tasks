package ge.davab.leetcode.search_in_rotated_sorted_array_33;

class Solution {
    public int search(int[] nums, int target) {
        return advBinSearch(target, nums, 0, nums.length - 1);
    }

    public int advBinSearch(int target, int[] nums, int left, int right) {
        if (left > right) return -1;

        int mid = (right + left) / 2;

        if (nums[mid] == target) return mid;

        if (nums[left] <= nums[mid]) {
            if (target < nums[mid] && target >= nums[left])
                return advBinSearch(target, nums, left, mid - 1);
            else
                return advBinSearch(target, nums, mid + 1, right);
        }
        else {
            if (target > nums[mid] && target <= nums[right])
                return advBinSearch(target, nums, mid + 1, right);
            else
                return advBinSearch(target, nums, left, mid - 1);
        }
    }
}
