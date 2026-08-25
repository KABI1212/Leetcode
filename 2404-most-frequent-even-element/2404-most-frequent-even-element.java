class Solution {
    public int mostFrequentEven(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                list.add(nums[i]);
            }
        }
        if (list.size() == 0) return -1;
        
        return check(list);
    }
    public static int check(ArrayList<Integer> list) {
        int max = 0;
        int count = 1;
        int res = list.get(0); 

        for (int i = 0; i < list.size() - 1; i++) {
            int a = list.get(i);
            int b = list.get(i + 1);

            if (a == b) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                    res = a;
                }
                count = 1; 
            }
        }
        if (count > max) {
            res = list.get(list.size() - 1);
        }
        return res;
    }
}