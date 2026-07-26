class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0]+ nums[1]+ nums[2];
        int min_diff = Integer.MAX_VALUE;
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2;i++){

            int left=i+1;
            int right = nums.length-1;
            while(left<right){

             int sum= nums[i] + nums[left] + nums[right];
                if (sum== target){
                    return sum;
                }else if(sum<target){
                    left++;
                }else{
                    right--;
                }
                int curr_diff = Math.abs(target - sum);
                if(curr_diff < min_diff){
                    result = sum;
                    min_diff= curr_diff;
                }
            }
        }
        return result;
    }
}