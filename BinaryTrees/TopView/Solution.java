import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode
{
    int data;
    TreeNode right;
    TreeNode left;
    TreeNode(int data)
    {
        this.data = data;
    }
}
class Pair
{
    TreeNode node;
    int vertices;
    Pair (TreeNode node, int vertices)
    {
        this.node = node;
        this.vertices = vertices;
    }
}
public class Solution {
    public List<Integer> topLevel(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        Queue<Pair> q = new  LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                Pair p = q.poll();
                TreeNode node = p.node;
                int vertices = p.vertices;
                if(!map.containsKey(vertices))
                {
                    map.put(vertices, node.data);
                }
                if(node.left != null)
                {
                    q.add(new Pair(node, vertices -1));
                }
                if(node.right != null)
                {
                    q.add(new Pair(node, vertices+1));
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
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(70);
        Solution sol = new Solution();
        List<Integer> ans = sol.topLevel(root);
        System.out.println(ans);

    }
}
