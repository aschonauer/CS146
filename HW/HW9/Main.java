import java.util.Scanner;

public class Main {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        if(p.val < root.val && q.val < root.val) {
            node = node.left;
        }
        else if (p.val > root.val && q.val > root.val) {
            node = node.right;
        }
        else {
            return root;
        }
        return lowestCommonAncestor(node, p, q);
    }
    public static void main(String[] args) {
        // Takes number of nodes and creates root with inputted value
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int nodeCount = in.nextInt();
        System.out.print("Enter root node value: ");
        TreeNode root = new TreeNode(in.nextInt());

        // Builds the BST
        for(int i = 0; i < nodeCount - 1; i++) {
            TreeNode current = root;
            System.out.print("Enter node value: ");
            TreeNode temp = new TreeNode(in.nextInt());
            boolean insert = false;
            while (!insert) {
                if (current.val > temp.val) {
                    if (current.left == null) {
                        current.left = temp;
                        insert = true;
                    }
                    else {
                        current = current.left;
                    }
                }
                else if (current.val < temp.val) {
                    if (current.right == null) {
                        current.right = temp;
                        insert = true;
                    }
                    else {
                        current = current.right;
                    }
                }
                else {
                    System.out.print("All values must be unique!");
                    return;
                }
            }
        }

        // Takes in input for which nodes to be used
        System.out.print("Enter value of node1 (value must be in BST): ");
        int val1 = in.nextInt();
        System.out.print("Enter value of node2 (value must be in BST): ");
        int val2 = in.nextInt();

        //Finds the target nodes to find the common ancestor for them
        boolean found = false;
        TreeNode current = root;
        TreeNode node1 = new TreeNode();
        TreeNode node2 = new TreeNode();

        while (!found) {
            if (val1 == current.val) {
                node1 = current;
                found = true;
            }
            else if (val1 < current.val) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }

        current = root;
        found = false;
        while (!found) {
            if (val2 == current.val) {
                node2 = current;
                found = true;
            }
            else if (val2 < current.val) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }

        // Find common ancestor node using lowestCommonAncestor
        Main obj = new Main();
        TreeNode node = obj.lowestCommonAncestor(root, node1, node2);
        System.out.print("Lowest common ancestor: " + node.val);

    }
}
