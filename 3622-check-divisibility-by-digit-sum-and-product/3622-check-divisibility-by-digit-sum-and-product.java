class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int pro = 1;
        int temp = n; 
        while (n != 0) {
            int rem = n % 10; 
            sum += rem;
            pro *= rem;
            n /= 10;       
        }
        int val = sum + pro;
        return val != 0 && temp % val == 0;
    }
}