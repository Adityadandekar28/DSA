class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        
        // 1. Whitespace: Ignore leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // If the string is completely empty or just spaces
        if (i == n) {
            return 0;
        }
        
        // 2. Signedness: Determine the sign
        int sign = 1;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        // 3 & 4. Conversion & Rounding
        int result = 0;
        int maxLimit = Integer.MAX_VALUE / 10;
        
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            
            // Check for potential overflow before multiplying by 10
            // Integer.MAX_VALUE is 2147483647, ending in 7.
            if (result > maxLimit || (result == maxLimit && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        return result * sign;
    }
}