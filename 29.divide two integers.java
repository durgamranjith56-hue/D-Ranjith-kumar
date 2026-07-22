class Solution {
    public int divide(int dividend, int divisor) {

        // Special overflow case
        if (dividend == Integer.MIN_VALUE &&
            divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine whether result is negative
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long to safely handle Integer.MIN_VALUE
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long result = 0;

        // Find the quotient using powers of 2
        while (a >= b) {

            long temp = b;
            long multiple = 1;

            // Double divisor using bit shifting
            while (a >= (temp << 1)) {
                temp = temp << 1;
                multiple = multiple << 1;
            }

            // Subtract the largest possible multiple
            a -= temp;
            result += multiple;
        }

        // Apply sign
        if (negative) {
            result = -result;
        }

        // Clamp to 32-bit integer range
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }
}
