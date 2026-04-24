import java.util.ArrayList;
import java.util.List;

class TreeNode
{
    int data;
    TreeNode left;
    TreeNode  right;
    TreeNode(int data)
    {
        this.data = data;
    }
}
public class Solution {
    public List<Integer> leftView(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        dfs(root,0,ans);
        return ans;
    }
    public void dfs(TreeNode root,int currLevel,List<Integer> ans)
    {
        if(root == null) return;
        if(currLevel == ans.size())
        {
            ans.add(root.data);
        }
        dfs(root.left, currLevel +1, ans);
        dfs(root.right, currLevel +1, ans);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        Solution sol = new Solution();
        List<Integer> ans = sol.leftView(root);
        System.out.println("Left view " + ans);
    }
}
