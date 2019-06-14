package Easy;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
1018. 可被 5 整除的二进制前缀
给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 */
public class PrefixesDivBy5 {
    public static void main(String[] args){
        int[] A={0,1,1,1,1,1};
        List<Boolean> res = prefixesDivBy5(A);
        Iterator<Boolean> iterator = res.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next().toString()+" ");
        }
    }
    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<Boolean>();
        int nums = 0;
        for (int i=0; i<A.length; i++){
            nums = (nums*2+A[i])%10;
            if (nums%5==0)
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
}
