class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i = 0; i< t.length(); i++){
            map.put(t.charAt(i) , map.getOrDefault(t.charAt(i) , 0) + 1);
        }
        int req = map.size();
        int formed = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
           window.put(ch, window.getOrDefault(ch, 0) + 1);
           if(map.containsKey(ch) && map.get(ch).intValue() == window.get(ch).intValue()){
              formed++;
           }

           while(formed == req){
               if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                  char remove = s.charAt(left);

                window.put(remove, window.get(remove) - 1);
                    if (map.containsKey(remove) &&
                    window.get(remove) < map.get(remove)) {

                    formed--;
                }

                left++;
           }
        }
          return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}