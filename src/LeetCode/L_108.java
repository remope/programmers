package LeetCode;

import LeetCode.DataStructure.TreeNode;

public class L_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBST(nums, 0, nums.length - 1);
    }
    public TreeNode makeBST(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeBST(nums, start, mid - 1);
        root.right = makeBST(nums, mid + 1, end);
        return root;
    }
}
