class Solution {
public:
    int smallestIndex(vector<int>& n) {
        for(int i=0;i<n.size();i++)
        {
            int sum=0;
            while(n[i]>0)
            {
                sum=sum+n[i]%10;
                n[i]/=10;
            }
            if(sum==i)
            {
                return i;
            }
        }
        return -1;
    }
};