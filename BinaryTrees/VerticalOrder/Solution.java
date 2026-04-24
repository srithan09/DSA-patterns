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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root,0,0,map);
        for(TreeMap<Integer,PriorityQueue<Integer>> level : map.values())
        {
            ArrayList<Integer> list = new ArrayList<>();
            for (PriorityQueue<Integer> pq : level.values())
            {
                while(!pq.isEmpty())
                {
                    list.add(pq.poll());
                }
            }
            ans.add(list);
        }
        return ans;
    }
    public void dfs(TreeNode root,int x,int y,TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map)
    {
        if(root == null) return;
        map.putIfAbsent(x, new TreeMap<>());
        TreeMap<Integer,PriorityQueue<Integer>> innerMap = map.get(x);
        innerMap.putIfAbsent(y, new PriorityQueue<>());
        innerMap.get(y).add(root.data);
        dfs(root.left, x-1, y+1, map);
        dfs(root.right, x+1 , y+1, map);
    }
    public static void main(String[] args) {
         Solution sol = new Solution();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
        List<List<Integer>> ans = new ArrayList<>();
        ans = sol.verticalTraversal(root);
        System.out.println(ans);
    }
}
