import java.util.*;
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
     int ans;
    public int sumNumbers(TreeNode root) {
        ans =0;
        func(root,0);
        return ans;
    }
    public void func(TreeNode root,int val)
    {
        if(root == null) return;
        val = val *10;
        val = val + root.data;
        if(root.left == null && root.right == null)
        {
            ans = ans+val;
        }
        func(root.left,val);
        func(root.right,val);
    }

    public static void main(String[] args) {
         TreeNode  root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        Solution sol = new Solution();
        int ans = sol.sumNumbers(root);
        System.out.println(ans);
    }
}
