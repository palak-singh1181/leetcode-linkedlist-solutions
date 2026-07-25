
public class FlattenBinaryTreeToLinkedList {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void flatten(TreeNode root) {

        TreeNode curr = root;

        while (curr != null) {

            if (curr.left != null) {

                TreeNode prev = curr.left;

                while (prev.right != null) {
                    prev = prev.right;
                }

                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }

            curr = curr.right;
        }
    }

    public static void printList(TreeNode root) {

        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        flatten(root);

        System.out.print("Flattened Tree: ");
        printList(root);
    }
}