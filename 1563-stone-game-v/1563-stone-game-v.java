class Solution {
    private int[][] memo;
    private int[] prefixSum;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new int[n][n];
        prefixSum = new int[n + 1];
        
        // Build prefix sum array for O(1) range sum queries
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }
        
        return solve(stoneValue, 0, n - 1);
    }

    private int solve(int[] stoneValue, int left, int right) {
        // Base case: Only one stone left, score is 0
        if (left == right) {
            return 0;
        }
        
        // Return already computed result
        if (memo[left][right] != 0) {
            return memo[left][right];
        }
        
        int maxScore = 0;
        
        // Try every possible split point k
        for (int k = left; k < right; k++) {
            int leftSum = prefixSum[k + 1] - prefixSum[left];
            int rightSum = prefixSum[right + 1] - prefixSum[k + 1];
            
            if (leftSum < rightSum) {
                // Bob throws away the right row. Alice gets left row.
                maxScore = Math.max(maxScore, leftSum + solve(stoneValue, left, k));
            } else if (leftSum > rightSum) {
                // Bob throws away the left row. Alice gets right row.
                maxScore = Math.max(maxScore, rightSum + solve(stoneValue, k + 1, right));
            } else {
                // Sums are equal. Alice chooses the optimal path.
                maxScore = Math.max(maxScore, Math.max(
                    leftSum + solve(stoneValue, left, k), 
                    rightSum + solve(stoneValue, k + 1, right)
                ));
            }
        }
        
        // Store and return the max score for this interval
        memo[left][right] = maxScore;
        return maxScore;
    }
}