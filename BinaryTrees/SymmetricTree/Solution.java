class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data)
    {
        this .data = data;
    }
}
public class Solution {
    public boolean symmetric(TreeNode root)
    {
        return root == null || dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode root1,TreeNode root2)
    {
        if(root1 == null || root2 == null) return root1 == root2;
        if(root1.data != root2.data) return false;
        return dfs(root1.left, root2.right) && dfs(root1.right, root2.left);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.left = new TreeNode(3);
        Solution sol = new Solution();
        System.out.println(sol.symmetric(root));
    }
}
