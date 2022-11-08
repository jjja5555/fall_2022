package edu.northeastern.martin;

public class Solution1 {
    private ListNode globalHead;

    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }

        return buildTree(0, length - 1);
    }

    private TreeNode buildTree(int left, int right) {
        //End condition
        if (left > right) {
            return null;
        }

        //Find mid point
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();

        //Start In-Order
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }

}
