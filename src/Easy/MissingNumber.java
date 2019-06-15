package Easy;
/*
268.缺失数字
给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 */
public class MissingNumber {
    public static void main(String[] args){
        int[] nums = {0,1,2,3,4,6,7,8,9};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        int sum = 0, len = nums.length;
        for (int i = 0; i<len; i++){
            sum += nums[i];
        }
        return len*(len+1)/2 -sum;
    }
}
