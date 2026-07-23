
import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class LinkedListInBinaryTree {

    public static boolean isSubPath(ListNode head, TreeNode root) {

        if (root == null)
            return false;

        return dfs(head, root)
                || isSubPath(head, root.left)
                || isSubPath(head, root.right);
    }

    private static boolean dfs(ListNode head, TreeNode node) {

        if (head == null)
            return true;

        if (node == null)
            return false;

        if (head.val != node.val)
            return false;

        return dfs(head.next, node.left)
                || dfs(head.next, node.right);
    }

    public static void main(String[] args) {

        // Linked List: 4 -> 2 -> 8
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

        /*
                  1
                /   \
               4     4
                \   /
                 2 2
                /   \
               1     6
                    /
                   8
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(4);
        root.right = new TreeNode(4);

        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);

        root.right.left = new TreeNode(2);
        root.right.left.right = new TreeNode(6);
        root.right.left.right.left = new TreeNode(8);

        boolean ans = isSubPath(head, root);

        System.out.println("Is Linked List present in Tree? " + ans);
    }
}