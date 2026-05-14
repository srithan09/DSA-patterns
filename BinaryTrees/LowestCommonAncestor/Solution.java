class TreeNode
{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data)
    {
        this.data = data; 
    }
}
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root == null || root == p || root == q)
        {
            return root;
        } 
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null)
        {
            return left;
        }
        return right;
    }
    public static void main(String[] args) {
        // Creating nodes
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        Solution sol = new Solution();
        TreeNode p = root.left;                  
        TreeNode q = root.left.right.right;   
        TreeNode ans = sol.lowestCommonAncestor(root,p,q);
        System.out.println(ans.data);
    }
}
