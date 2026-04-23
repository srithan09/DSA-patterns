import java.util.ArrayList;
import java.util.Stack;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data)
    {
        this.data = data;
    }
}

public class Solution {

    public ArrayList<Integer> boundaryTraversal(TreeNode root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        
        if(root == null) return res;

        if(!isLeaf(root)) res.add(root.data);

        addLeftBoundary(root.left, res);
        addLeaves(root, res);
        addRightBoundary(root.right, res);

        return res;
    }

    public boolean isLeaf(TreeNode root)
    {
        return root.left == null && root.right == null;
    }

    public void addLeftBoundary(TreeNode root, ArrayList<Integer> res)
    {
        TreeNode curr = root;

        while(curr != null)
        {
            // ✅ FIX: use curr instead of root
            if(!isLeaf(curr))
            {
                res.add(curr.data);
            }

            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    public void addLeaves(TreeNode root , ArrayList<Integer> res)
    {
        if(root == null) return;
        if(isLeaf(root))
        {
            res.add(root.data);
            return;
        }
        addLeaves(root.left, res);
        addLeaves(root.right, res);
    }

    public void addRightBoundary(TreeNode root, ArrayList<Integer> res)
    {
        TreeNode node = root;
        Stack<Integer> st = new Stack<>();
        while(node != null)
        {
            if(!isLeaf(node))
            {
                st.push(node.data);
            }
            if(node.right != null) node = node.right;
            else node = node.left;
        }
        while(!st.isEmpty())
        {
            res.add(st.pop());
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // Creating sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        // Call boundary traversal
        ArrayList<Integer> result = sol.boundaryTraversal(root);
        // Print result
        System.out.println("Boundary Traversal:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}