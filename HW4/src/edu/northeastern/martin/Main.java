package edu.northeastern.martin;

import com.sun.source.tree.Tree;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Q1
        Solution1 s1 = new Solution1();
        TreeNode result1 = s1.sortedListToBST(new ListNode(10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9))))));
        System.out.println("Use debug to check result, put break point here.");

        //Q2
        Solution2 s2 = new Solution2();
        Node result2 = s2.treeToDoublyList(new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5)));
        System.out.println("Use debug to check result, put break point here.");

        //Q3
        Solution3 s3 = new Solution3();
        System.out.println(s3.isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));

        //Q4
        Solution4 s4 = new Solution4();
        TreeNode node4 = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
        s4.recoverTree(node4);
        System.out.println();

        //Q5
        BSTIterator bstIterator = new BSTIterator(new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20))));
        System.out.println(bstIterator.next());     // return 3
        System.out.println(bstIterator.next());     // return 7
        System.out.println(bstIterator.hasNext());  // return True
        System.out.println(bstIterator.next());     // return 9
        System.out.println(bstIterator.hasNext());  // return True
        System.out.println(bstIterator.next());     // return 15
        System.out.println(bstIterator.hasNext());  // return True
        System.out.println(bstIterator.next());     // return 20
        System.out.println(bstIterator.hasNext());  // return False

        //Q6
        Codec ser = new Codec();
        Codec deser = new Codec();
        String tree = ser.serialize(new TreeNode(2, new TreeNode(1), new TreeNode(3)));
        System.out.println(tree);
        TreeNode ans = deser.deserialize(tree);
        System.out.println("Use debug to check result, put break point here.");

        //Q7
        Solution7 s7 = new Solution7();
        TreeNode head = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode output7 = s7.inorderSuccessor(head, head.left);
        System.out.println("Use debug to check result, put break point here.");

        //Q8
        Solution8 s8 = new Solution8();
        System.out.println(s8.rangeSumBST(new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18))), 7, 15));

    }


}
