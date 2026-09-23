class Solution {
public:
    int minOperations(vector<int>& a, int x) {
        int k = reduce(a.begin(), a.end()) - x;
        int n = a.size();
        if (k < 0) {
            return -1;
        } else if (k == 0) {
            return n;
        }
        int b = -1;
        int s = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + a[i];
            while (sum > k) {
                sum = sum - a[s++];
            }
            if (sum == k) {
                b = max(b, i - s + 1);
            }
        }
        return b == -1 ? -1 : n - b;
    }
};