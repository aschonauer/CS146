import java.util.Scanner;


public class Main {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left != null) {
            invertTree(root.left);
        }
        if (root.right != null) {
            invertTree(root.right);
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(8);
        root.left = node1;
        root.right = node2;

        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node3;
        node1.right = node4;

        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node2.left = node5;
        node5.right = node6;
        System.out.println(root.val);
        System.out.println(root.left.val + " " + root.right.val);
        System.out.println(root.left.left.val + " " + root.left.right.val + " " + root.right.left.val + " E" );
        System.out.println("E E E E E " + root.right.left.right.val);
        Main obj = new Main();
        root = obj.invertTree(root);
        System.out.println(root.val);
        System.out.println(root.left.val + " " + root.right.val);
        System.out.println("E " + root.left.right.val + " " + root.right.left.val + " " + root.right.right.val);
        System.out.println(" " + root.left.right.left.val + " E E E E E");
    }
}