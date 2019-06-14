package Medium;

import java.util.ArrayList;
import java.util.List;

/*
1019.链表中的下一个更大节点
给出一个以头节点 head 作为第一个节点的链表。链表中的节点分别编号为：node_1, node_2, node_3, ... 。
每个节点都可能有下一个更大值（next larger value）：对于 node_i，如果其 next_larger(node_i) 是 node_j.val，那么就有 j > i 且  node_j.val > node_i.val，而 j 是可能的选项中最小的那个。如果不存在这样的 j，那么下一个更大值为 0 。
返回整数答案数组 answer，其中 answer[i] = next_larger(node_{i+1}) 。
 */
public class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode tmp = head;
        while(tmp != null){
            list.add(tmp.val);
            tmp = tmp.next;
        }
        int[] dp = new int[list.size()];
        for (int i=list.size()-2; i>=0; i--){
            if (list.get(i) < list.get(i+1))
                dp[i] = list.get(i+1);
            else if (list.get(i) == list.get(i+1))
                dp[i] = dp[i+1];
            else{
                for (int j = i+1; j<list.size(); j++){
                    if (list.get(i) < dp[j]){
                        dp[i] = dp[j];
                        break;
                    }
                }
            }
        }
        return dp;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
