import java.util.ArrayList;

public class Main {

    // Function returns ArrayList of TreeNodes in in-order
    // traversal given the root of the tree.
    public ArrayList<TreeNode> inOrder(TreeNode root) {
        ArrayList<TreeNode> left = new ArrayList<TreeNode>();
        ArrayList<TreeNode> right = new ArrayList<TreeNode>();
        if (root.left != null) {
            left = inOrder(root.left);
        }
        if (root.right != null) {
            right = inOrder(root.right);
        }
        ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
        for (TreeNode node : left) {
            arr.add(node);
        }
        arr.add(root);
        for (TreeNode node : right) {
            arr.add(node);
        }
        return arr;
    }

    // Checks if the tree is a BST
    public boolean isValidBST(TreeNode root) {
        boolean valid = true;
        // array is an in-order traversal of the tree
        ArrayList<TreeNode> array = inOrder(root);

        // checks that each value is less than the next
        // if it is not this is not a BST since it should
        // be in order
        for (int i = 0; i < array.size() - 1; i++) {
            if (array.get(i).val >= array.get(i+1).val) {
                valid = false;
            }
        }
        return valid;
    }

    public static void main(String[] args) {
        TreeNode root4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        root4.left = node3;
        root4.right = node8;
        node3.right = node4;
        node8.left = node7;
        node8.right = node9;

        Main obj = new Main();
        System.out.print(obj.isValidBST(root4));
    }
}