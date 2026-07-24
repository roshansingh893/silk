class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rad = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        
        for(int i = 0; i < senate.length(); i++){
            if(senate.charAt(i) == 'R') {
                rad.offer(i);
                }
            else{
                dire.offer(i);
            }
        }

        while(!rad.isEmpty() && !dire.isEmpty()){
           if(rad.peek() > dire.peek()){
               rad.poll();
               int next = dire.poll();
               next = next + senate.length();
               dire.offer(next);
           } else {
              dire.poll();
              int next = rad.poll();
              next = next + senate.length();
              rad.offer(next);
           } 
        }

        if(rad.isEmpty()){
            return new String("Dire");
        } else {

            return new String("Radiant");
        }



    }
}