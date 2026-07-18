class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
      int  min_length = Integer.MAX_VALUE;
        int left =0;
        for (int right =0; right<nums.length; right++){
            sum+= nums[right];
            while(sum>= target){
                min_length=Math.min(min_length, right -left+1);
                 sum-=nums[left];
                 left++;
               
            }

}
 if(min_length==Integer.MAX_VALUE){
    return 0;
 }
 return min_length;
        }
      
            }
    
