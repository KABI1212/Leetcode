class Solution {
    public int missingMultiple(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%k==0)
            {
                list.add(nums[i]);
            }
        }
        return check(list,k);
    }
    public static int check(List<Integer> list,int k)
    {
        for(int i=k;i<=200;i=i+k)
        {
                if(!list.contains(i))
                {
                    return i;
                }
        }
        return 0;
    }
}