import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

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
class Pair{
    int vertices;
    TreeNode node;
    Pair(TreeNode node,int vertices)
    {
        this.node = node;
        this.vertices = vertices;
    }
}
public class Solution {
    public List<Integer> bottomLevel(TreeNode root)
    {
        Queue<Pair> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i =0;i<size;i++)
            {
                Pair p = q.poll();
                int vertices = p.vertices;
                TreeNode node = p.node;
                map.put(vertices, node.data);
                
                if(node.left !=  null)
                {
                    q.add(new Pair(node.left, vertices-1));
                }
                if(node.right != null)
                {
                    q.add(new Pair(node.right, vertices +1));
                }
            }
        }
       for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Solution sol = new Solution();
        List<Integer> result = sol.bottomLevel(root);
        System.out.println("Bottom view: " + result);  // Expected: [4, 2, 1, 3, 6]
    }
}
