/*给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

        示例 1:

        输入: [1,2,0]
        输出: 3



        示例 2:

        输入: [3,4,-1,1]
        输出: 2



        示例 3:

        输入: [7,8,9,11,12]
        输出: 1*/
package lianxi0414;

import java.util.*;
public class test0414 {
    public static void main(String[] args) {
        Solution S = new Solution();
        int[] nums = new int[]{3,4,-1,1};
        int num = S.firstMissingPositive(nums);
        System.out.println(num);
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        int m = 1;
        int i = 0;
        if(nums.length == 0){
            return 1;
        }
        Arrays.sort(nums);
        while(i < nums.length){
            if(nums[i] < nums.length && nums[i] >= 1){
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
            i++;
        }
        for(i = 0; i < nums.length;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
}