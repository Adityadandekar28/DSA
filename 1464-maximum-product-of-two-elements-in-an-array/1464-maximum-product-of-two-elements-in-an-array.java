class Solution {
    public int maxProduct(int[] nums) {
        int maxProduct=0;
        int i=0;
        int j=nums.length-1;
        while(i<j){
        int product= (nums[i]-1)* (nums[j]-1);
        if(nums[i]<nums[j]){
            i++;
        }else{
            j--;
        }
        maxProduct=Math.max(maxProduct,product);
    }
    return maxProduct;
}
}