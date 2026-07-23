class Solution {
    public boolean isNumber(String s) {

        int n = s.length();
        int i = 0;

        // Check optional sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }

        // Digits before decimal point
        boolean hasDigit = false;

        while (i < n && Character.isDigit(s.charAt(i))) {
            hasDigit = true;
            i++;
        }

        // Check decimal point
        if (i < n && s.charAt(i) == '.') {
            i++;

            // Digits after decimal point
            while (i < n && Character.isDigit(s.charAt(i))) {
                hasDigit = true;
                i++;
            }
        }

        // There must be at least one digit
        if (!hasDigit) {
            return false;
        }

        // Check exponent
        if (i < n && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            i++;

            // Optional exponent sign
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }

            // Exponent must contain at least one digit
            boolean exponentDigit = false;

            while (i < n && Character.isDigit(s.charAt(i))) {
                exponentDigit = true;
                i++;
            }

            if (!exponentDigit) {
                return false;
            }
        }

        // All characters must have been consumed
        return i == n;
    }
}
