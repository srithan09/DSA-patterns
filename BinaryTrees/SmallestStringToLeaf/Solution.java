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
    String result = "~";
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder str = new StringBuilder();
        dfs(root,str);
        return result;
    }
    public void dfs(TreeNode root,StringBuilder path)
    {
        if(root == null) return;
        char ch = (char) ('a'+root.data);
        path.append(ch);
        if(root.left == null && root.right == null)
        {
            String current  = new StringBuilder(path).reverse().toString();
            if(current.compareTo(result) < 0)
            {
                result = current;
            }
        }
        dfs(root.left, path);
        dfs(root.right, path);
        path.deleteCharAt(path.length() - 1);
    }
    public static void main(String[] args) {
        
    }
}
