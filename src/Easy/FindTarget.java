package Easy;

import java.util.HashMap;
import java.util.Map;

public class FindTarget {
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        return hasTarget(root, k, map);
    }
    public boolean hasTarget(TreeNode root, int k, Map<Integer,Integer> map){
        if (root == null)
            return false;
        if (map.containsKey(k-root.val))
            return true;
        else{
            map.put(root.val,1);
            return hasTarget(root.left,k,map) || hasTarget(root.right,k,map);
        }
    }
}
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}