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
    // Main Trvaersal order used would be PreOrder Traversal (root -> left -> right)
    // 1. use ArrayList to store all the path from root-> node
    //2.add the elements till we reach null if the node is found on that part of the subtree -> remove the elemnt which u previously added
    //3. if found return true and return the whole path 
    //4. if reaches to the end then we need to return false and remove the last element inserted and traverse the remaing paths
    //5. if any path return true then we stop the traversal and return the total list\
      public List<Integer> pathStore(TreeNode root, int x)
      {
        List<Integer> ans = new  ArrayList<>();
        func(root, ans,x);
        return ans;
      } 
    public boolean func(TreeNode root,List<Integer>ans,int x)
    {
        if(root == null) return false;
        ans.add(root.data);
        if(root.data == x)
        {
            return true;
        }
        if(func(root.left, ans, x) == true || func(root.right, ans, x)) return true;
        ans.remove(ans.size()-1);
        return false;
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
        List<Integer> ans  = sol.pathStore(root, 7);
        System.out.println(ans);
    }
}
