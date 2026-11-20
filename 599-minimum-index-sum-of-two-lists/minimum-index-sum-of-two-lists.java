class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (i > min)
                break;
            if (map.containsKey(list2[i])) {
                int x = map.get(list2[i]);
                int sum = i + x;
                if (sum < min) {
                    ans.clear();
                    ans.add(list2[i]);
                    min = sum;
                } else if (sum == min) {
                    ans.add(list2[i]);
                }
            }
        }
        return ans.toArray(new String[0]);

    }
}