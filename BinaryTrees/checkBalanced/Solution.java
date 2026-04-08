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
    public boolean checkBalanced(TreeNode root)
    {
        return dfs(root) != -1;
    }
    public int dfs(TreeNode root)
    {
        if(root == null) return 0;
        int lh = dfs(root.left);
        int rh = dfs(root.right);
        if(lh == -1 || rh == -1) return -1;
        if(Math.abs(lh-rh)>1) return -1;
        return 1+ Math.max(lh,rh);
    }
    public static void main(String[] args) {
        Solution  s1 = new Solution();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
        System.out.println(s1.checkBalanced(root));
    }
}
