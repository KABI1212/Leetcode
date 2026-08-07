class Solution {

    public String smallestNumber(String num, long t) {
        long value = t;
        for (int d = 2; d <= 9; d++) {
            while (value % d == 0) {
                value /= d;
            }
        }
        if (value != 1) {
            return "-1";
        }
        int n = num.length();
        char[] digits = num.toCharArray();
        long[] remaining = new long[n + 1];
        remaining[0] = t;
        int lastIndex = n - 1;
        for (int i = 0; i < n; i++) {
            if (digits[i] == '0') {
                lastIndex = i;
                break;
            }
            remaining[i + 1] = remaining[i] / gcd(remaining[i], digits[i] - '0');
        }
        if (remaining[n] == 1) {
            return num;
        }
        for (int i = lastIndex; i >= 0; i--) {

            for (char ch = (char) (digits[i] + 1); ch <= '9'; ch++) {
                digits[i] = ch;
                long need = remaining[i];
                need /= gcd(need, ch - '0');
                int factor = 9;
                for (int j = n - 1; j > i; j--) {
                    while (factor > 1 && need % factor != 0) {
                        factor--;
                    }
                    digits[j] = (char) ('0' + factor);
                    need /= factor;
                }
                if (need == 1) {
                    return new String(digits);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        long need = t;
        for (int d = 9; d >= 2; d--) {
            while (need % d == 0) {
                result.append((char) ('0' + d));
                need /= d;
            }
        }
        while (result.length() < n + 1) {
            result.append('1');
        }
        return result.reverse().toString();
    }
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}