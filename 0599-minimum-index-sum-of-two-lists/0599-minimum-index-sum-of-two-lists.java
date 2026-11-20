class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> lst = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i<list1.length ; i++){
            if(!map.containsKey(list1[i])) {map.put(list1[i], i);}
        }

        Map<String, Integer> nmap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < list2.length ; i++){
            if(map.containsKey(list2[i])){
                int x = map.get(list2[i]);
                int sum = i+x;
                min = Math.min(min,sum);
                if(!nmap.containsKey(list2[i])){ nmap.put(list2[i], sum);}
            }
        }
        for(Map.Entry<String, Integer> entry : nmap.entrySet()){
            String key = entry.getKey();
            int val = entry.getValue();
            if(val == min) lst.add(key);
        }

        return lst.toArray(new String[0]);

    }
}